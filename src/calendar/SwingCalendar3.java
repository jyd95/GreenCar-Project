package calendar;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch01.DiaryReservationPanel;

public class SwingCalendar3 extends JFrame implements Runnable {

	private DiaryReservationPanel drp;
	// 다이어리 생성
	private Diary dr;

	// 패널
	private JPanel term;
	private JPanel calendar;

	// 라벨
	private JLabel yearMonthLabel;
	private JLabel headerLabel;

	// 달력 버튼
	private JButton previousBtn;
	private JButton nextBtn;
	private ImageIcon prebtnIcon;
	private ImageIcon nextbtnIcon;

	// 요일 버튼
	private JButton[] buttons;

	// 요일
	private String[] dayAr = { "Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat" };

	// 폰트
	private Font font;

	// 날짜 조절
	private int gap;

	// 클릭횟수 조절
	private int clickCount;

	// 버튼 텍스트 가져오기
	private String firstButtonText;
	private String secondButtonText;

	// 버튼 클릭 횟수
	private boolean firstClick = true;
	private boolean secondClick = true;
	private int firstClickedIndex = -1;

	public SwingCalendar3(DiaryReservationPanel drp) {
		this.drp = drp;
		dr = new Diary();
		initData();
		setInitLayout();

		new Thread(this).start();
	}

	public void initData() {
		// 패널
		calendar = new JPanel();
		term = new JPanel();
		// 라벨
		yearMonthLabel = new JLabel("00년 0월");
		headerLabel = new JLabel("날짜로 예약");
		// 버튼
		prebtnIcon = new ImageIcon("img/left.png");
		nextbtnIcon = new ImageIcon("img/right.png");
		previousBtn = new JButton(prebtnIcon);
		nextBtn = new JButton(nextbtnIcon);
		buttons = new JButton[49];

		// 폰트
		font = new Font("SansSerif", Font.BOLD, 24);

	}

	public void setInitLayout() {
		// 프레임 설정
		setTitle("예약");
		setSize(565, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		// 백그라운드 패널
		calendar.setLayout(new GridLayout(7, 7, 5, 5));
		calendar.setBackground(Color.white);
		calendar.setLocation(0, 100);
		calendar.setSize(550, 260);
		add(calendar);

		term.setBackground(Color.WHITE);
		term.setSize(550, 100);
		term.setLocation(0, 0);
		term.setLayout(new GridLayout(0, 1, 10, 5));
		add(term);

		// 버튼사이 라벨
		yearMonthLabel.setSize(230, 100);
		yearMonthLabel.setLocation(220, 0);
		yearMonthLabel.setFont(font);
		yearMonthLabel.setText(dr.getCalText());
		add(yearMonthLabel, 0);

		// 버튼
		previousBtn.setSize(45, 50);
		previousBtn.setLocation(150, 25);
		previousBtn.setBorder(null);
		previousBtn.setContentAreaFilled(false);
		add(previousBtn, 0);

		nextBtn.setSize(45, 50);
		nextBtn.setLocation(350, 25);
		nextBtn.setBorder(null);
		nextBtn.setContentAreaFilled(false);
		add(nextBtn, 0);

		setVisible(true);
	}

	public void run() {
		// 버튼 생성
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();

			// i값 index에 넣어버리기
			final int index = i;
			clickCount = 1;

			// 캘린더에 에드
			calendar.add(buttons[i]);

			// 버튼 리스너!
			buttons[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

					// 클릭이 1번이면
					if (clickCount % 2 == 1) {
						buttons[index].setEnabled(false);
						firstButtonText = buttons[index].getText();

						////////////////// !!!!!!!!!!!!!!!!!///////////////////////////

						System.out.println(dr.getAllCal(firstButtonText));
						drp.updatedateLabelText("대여일 : " + dr.getAllCal(firstButtonText));

						////////////////// !!!!!!!!!!!!!!!!!///////////////////////////

						// 클릭이 2번이면
					} else if (clickCount % 2 == 0) {
						secondButtonText = buttons[index].getText();
						System.out.println(dr.getAllCal(secondButtonText));
						buttons[index].setEnabled(true);

						// 대여일 , 반납일 출력하기!!!!!!!!!!!
						//////////////// !!!!!!!!!!!!!!!!!!!!!!////////////////////////////

						drp.updateReturnLabelText("반납일 : " + dr.getAllCal(secondButtonText));

						//////////////// !!!!!!!!!!!!!!!!!!!!!!////////////////////////////
					}
					clickCount++;
					if (firstClick) {
						firstClickedIndex = index;
						firstClick = false;
						System.out.println("대여일 : " + dr.getAllCal(firstButtonText));
					} else {
						// 두번쨰 클릭 값 받아 오기
						int secondClickedIndex = index;

						// 버튼 범위 클릭 되게 !
						int start = Math.min(firstClickedIndex, secondClickedIndex);
						int end = Math.max(firstClickedIndex, secondClickedIndex);
						System.out.println("반납일 : " + dr.getAllCal(secondButtonText));

						for (int j = start + 1; j < end + 1; j++) {
							buttons[j].setEnabled(false);
							if (j >= start && j <= end) {
								buttons[j].setEnabled(false);
							}

						}
						firstClickedIndex = -1;
						firstClick = true;

						dispose();
					}
				}
			});
			buttons[i].setFont(new Font("SansSerif", font.BOLD, 20));
			if (i < 7) {
				buttons[i].setText(dayAr[i]);
				buttons[i].setEnabled(false);
				buttons[i].setFont(new Font("SansSerif", font.BOLD, 18));
			}
			if (i % 7 == 0) {
				buttons[i].setForeground(Color.RED);
			}
			if (i % 7 == 6) {
				buttons[i].setForeground(Color.BLUE);
			}
		}
		dr.setButtons(buttons);
		dr.setCal();

		previousBtn.addMouseListener(new MouseAdapter() {

			// 이전버튼 누르면 월이 줄어들게!
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource() == previousBtn) {
					gap = -1;
				}
				dr.initCalData(gap);
				yearMonthLabel.setText(dr.getCalText());
			}
		});

		// 넥스트 버튼 누르면 월이 +1추가!!!!
		nextBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource() == nextBtn) {
					gap = 1;
				}
				dr.initCalData(gap);
				yearMonthLabel.setText(dr.getCalText());
			}
		});
	}

}