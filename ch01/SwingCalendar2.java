package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar2 extends JFrame implements Runnable {
	// 다이어리 생성
	Diary dr;

	// 패널
	JPanel term;
	JPanel calendar;

	// 라벨
	JLabel yearMonthLabel;

	// 달력 버튼
	JButton previousBtn;
	JButton nextBtn;

	// 요일 버튼
	JButton[] buttons;

	// 요일
	private String[] dayAr = { "Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat" };

	// 폰트
	Font font;

	// 날짜 조절
	int gap;

	public SwingCalendar2() {
		dr = new Diary();
		initData();
		setInitLayout();

		new Thread(this).start();
	}

	public void initData() {
		// Diary 가져오기

		// 패널
		calendar = new JPanel();
		term = new JPanel();
		// 라벨
		yearMonthLabel = new JLabel("00년 0월");

		// 버튼
		previousBtn = new JButton("<");
		nextBtn = new JButton(">");
		buttons = new JButton[49];

		// 폰트
		font = new Font("SansSerif", Font.BOLD, 24);

	}

	public void setInitLayout() {
		// 프레임 설정
		setTitle("예약");
		setSize(565, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 백그라운드 패널
		calendar.setLayout(new GridLayout(0, 7));
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
		yearMonthLabel.setLocation(200, 0);
		yearMonthLabel.setFont(font);
		yearMonthLabel.setText(dr.getCalText());
		add(yearMonthLabel, 0);

		// 버튼
		previousBtn.setSize(45, 50);
		previousBtn.setLocation(120, 20);
		add(previousBtn, 0);

		nextBtn.setSize(45, 50);
		nextBtn.setLocation(350, 20);
		add(nextBtn, 0);

		calendar.setLayout(new GridLayout(7, 7, 5, 5));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			calendar.add(buttons[i]);

			buttons[i].setFont(new Font("SansSerif", font.BOLD, 20));
			if (i < 7) {
				buttons[i].setText(dayAr[i]);
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

		setVisible(true);
	}

	@Override
	public void run() {
		previousBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource() == previousBtn) {
					gap = -1;
				}
				dr.initCalData(gap);
				yearMonthLabel.setText(dr.getCalText());
			}
		});
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

	public static void main(String[] args) {
		new SwingCalendar2();
	}

}
