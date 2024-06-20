package ch01;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingCalendar extends JFrame {

	// 다이어리 생성
	Diary dr;

	// 패널
	JPanel backgroundPanel;
	JPanel backgroundPanel2;

	// 년월 라벨
	JLabel yearMonthLabel;

	// 달력 버튼
	JButton previousBtn;
	JButton nextBtn;

	// 요일
	private String[] dayAr = { "Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat" };

	// 폰트
	Font font;

	public SwingCalendar() {
		dr = new Diary();
		initData();
		setInitLayout();
	}

	public void initData() {
		// Diary 가져오기

		// 패널
		backgroundPanel = new BackgroundPanel();
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setLayout(null);
		add(backgroundPanel);
		// 라벨
		yearMonthLabel = new JLabel("00년 0월");

		// 버튼
		previousBtn = new JButton("<");
		nextBtn = new JButton(">");

		// 폰트
		font = new Font("SansSerif", Font.BOLD, 24);

	}

	public void setInitLayout() {
		// 프레임 설정
		setTitle("예약");
		setSize(550, 400);
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 백그라운드 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 버튼사이 라벨
		yearMonthLabel.setBounds(230, 40, 120, 50);
		yearMonthLabel.setFont(font);
		yearMonthLabel.setText(dr.getCalText());
		backgroundPanel.add(yearMonthLabel);

		// 버튼
		previousBtn.setBounds(150, 40, 50, 40);
		nextBtn.setBounds(350, 40, 50, 40);

		previousBtn.setFont(font);
		nextBtn.setFont(font);

		backgroundPanel.add(previousBtn);
		backgroundPanel.add(nextBtn);

		setVisible(true);
	}

	private class BackgroundPanel extends JPanel {
		private JPanel backgroundPanel;

		// 백그라운드 패널
		public BackgroundPanel() {
			backgroundPanel = new JPanel();
		}

	}

	public static void main(String[] args) {
		new SwingCalendar();
	}
}
