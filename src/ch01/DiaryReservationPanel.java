package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import calendar.Diary;
import calendar.SwingCalendar3;

public class DiaryReservationPanel extends JFrame {

	private String receivedCarname;
	private Diary dr;

	// 패널
	private JPanel backgroundPanel;

	// 라벨
	private JLabel logoLabel;
	private JLabel dateLabel;
	private JLabel returnLabel;
	private JLabel headerLabel;
	private JLabel midLabel;
	private JLabel calendarLabel;
	private JLabel oneLineLabel;

	// 버튼
	private JButton reserveBtn;
	private JButton choiceDateBtn;
	private JButton completeSelectionBtn;

	// 이미지
	private ImageIcon reserveImg;
	private ImageIcon rentImg;
	private ImageIcon returnImg;

	public DiaryReservationPanel(String receivedCarname) {
		this.receivedCarname = receivedCarname;
		initData();
		setInitLayout();
		addBtnListener();
	}

	public DiaryReservationPanel() {
		initData();
		setInitLayout();
		addBtnListener();
	}

	public void initData() {

		// 패널
		backgroundPanel = new JPanel();

		// 라벨 이미지
		headerLabel = new JLabel("날짜 선택하기");
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));
		midLabel = new JLabel(new ImageIcon("img/reserveLogo3.png"));
		calendarLabel = new JLabel(new ImageIcon("img/calender.png"));
		oneLineLabel = new JLabel(new ImageIcon("img/oneline.png"));
		dateLabel = new JLabel("대여일 : ");
		returnLabel = new JLabel("반납일 : ");

		// 이미지
		reserveImg = new ImageIcon("img/reserveBtn.png");
		rentImg = new ImageIcon("img/chooseDate.png");
		returnImg = new ImageIcon("img/선택한 날짜로 예약하기.png");

		// 버튼
		reserveBtn = new JButton(reserveImg);
		choiceDateBtn = new JButton(rentImg);
		completeSelectionBtn = new JButton(returnImg);

	}

	public void setInitLayout() {

		// 프레임 설정
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		// 배경 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 라벨 이미지
		logoLabel.setBounds(30, 0, 105, 200);
		oneLineLabel.setBounds(0, 170, 1000, 20);
		headerLabel.setBounds(200, 50, 300, 100);
		dateLabel.setBounds(280, 660, 300, 100);
		returnLabel.setBounds(280, 690, 300, 100);

		logoLabel.setLayout(null);
		headerLabel.setLayout(null);
		dateLabel.setLayout(null);
		returnLabel.setLayout(null);

		headerLabel.setFont(new Font("궁서", Font.BOLD, 30));
		dateLabel.setFont(new Font("궁서", Font.BOLD, 25));
		returnLabel.setFont(new Font("궁서", Font.BOLD, 25));

		backgroundPanel.add(dateLabel);
		backgroundPanel.add(returnLabel);
		backgroundPanel.add(logoLabel);
		backgroundPanel.add(headerLabel);
		backgroundPanel.add(oneLineLabel);

		// 중간 로고
		midLabel.setBounds(250, 150, 500, 700);
		calendarLabel.setBounds(250, 100, 500, 700);

		midLabel.setLayout(null);
		calendarLabel.setLayout(null);

		backgroundPanel.add(calendarLabel);
		backgroundPanel.add(midLabel);

		// 버튼
		reserveBtn.setBounds(330, 700, 370, 50);
		choiceDateBtn.setBounds(350, 610, 300, 50);
		completeSelectionBtn.setBounds(310, 830, 400, 50);

		reserveBtn.setBorder(null);
		choiceDateBtn.setBorder(null);
		completeSelectionBtn.setBorder(null);

		reserveBtn.setContentAreaFilled(false);
		choiceDateBtn.setContentAreaFilled(false);
		completeSelectionBtn.setContentAreaFilled(false);
		completeSelectionBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (HomePagePanel.movement == 2) {
					CarReservationPanel crp = new CarReservationPanel(SwingCalendar3.startDate, SwingCalendar3.EndDate);
					crp.setVisible(true);
					setVisible(false);
				} else {
					ReservationUpdatePage rup = new ReservationUpdatePage(receivedCarname, SwingCalendar3.startDate, SwingCalendar3.EndDate);
					rup.setVisible(false);
					setVisible(false);
					JOptionPane.showConfirmDialog(null, "예약되었습니다.", "알림",
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		backgroundPanel.add(reserveBtn, 0);
		backgroundPanel.add(choiceDateBtn, 0);
		backgroundPanel.add(completeSelectionBtn, 0);

		setVisible(true);
	}

	public void updatedateLabelText(String newText) {
		dateLabel.setText(newText);
	}

	public void updateReturnLabelText(String newText) {
		returnLabel.setText(newText);
	}

	public void addBtnListener() {
		choiceDateBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new SwingCalendar3(DiaryReservationPanel.this);
			}
		});

		logoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HomePagePanel(HomePagePanel.username);
				setVisible(false);
			}
		});
	}
}