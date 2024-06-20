package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class HomePagePanel extends JFrame {
	// 패널
	private JPanel backgroundPanel;
	private JPanel searchPanel;

	// 로고
	private JLabel logoLabel;

	// 메뉴 버튼
	private JButton short_termBtn;
	private JButton long_termBtn;
	private JButton usedCarBtn;

	// 검색 보드
	private JTextArea mainSearchBox;
	private JTextField writeSearchBox;
	private JButton searchBtn;

	public HomePagePanel() {
		initData();
		setInitLayout();
	}

	public void initData() {
		// 패널
		backgroundPanel = new BackgroundPanel();
		searchPanel = new JPanel();

		// 로고레이블
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));

		// 상단 메뉴바 버튼
		short_termBtn = new JButton("<html><body><center>차량으로<br>예약하기</center></body></html>\")");
		long_termBtn = new JButton("<html><body><center>날짜로<br>에약하기</center></body></html>\")");
		usedCarBtn = new JButton("<html><body><center>예약조회<br>및 변경하기</center></body></html>");

		// 검색 기능
		mainSearchBox = new JTextArea();
		writeSearchBox = new JTextField(45);
		searchBtn = new JButton("검색");
	}

	public void setInitLayout() {
		// 프레임 설정
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		searchPanel.setBounds(200, 200, 600, 45);
		searchPanel.setBackground(Color.WHITE);
		// searchPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
		searchPanel.setBorder(new LineBorder(Color.ORANGE, 5, true));
		searchPanel.add(writeSearchBox);
		searchPanel.add(searchBtn);
		backgroundPanel.add(searchPanel);

		// logo 이미지
		logoLabel.setBounds(10, 10, 100, 100);
		logoLabel.setLayout(null);
		backgroundPanel.add(logoLabel);

		// 상단 메뉴바 버튼
		short_termBtn.setBounds(200, 40, 103, 50);
		long_termBtn.setBounds(400, 40, 103, 50);
		usedCarBtn.setBounds(600, 40, 172, 50);

		short_termBtn.setBorder(null);
		long_termBtn.setBorder(null);
		usedCarBtn.setBorder(null);

		short_termBtn.setContentAreaFilled(false);
		long_termBtn.setContentAreaFilled(false);
		usedCarBtn.setContentAreaFilled(false);

		short_termBtn.setFont(new Font("궁서", Font.BOLD, 20));
		long_termBtn.setFont(new Font("궁서", Font.BOLD, 20));
		usedCarBtn.setFont(new Font("궁서", Font.BOLD, 20));

		backgroundPanel.add(short_termBtn);
		backgroundPanel.add(long_termBtn);
		backgroundPanel.add(usedCarBtn);

		// 검색 박스
		// mainSearchBox.setBounds(400, 200, 1000, 40);
		searchBtn.setBorder(null);
		searchBtn.setFont(new Font("궁서", Font.BOLD, 20));

		backgroundPanel.add(mainSearchBox);

		setVisible(true);
	}

	private class BackgroundPanel extends JPanel {
		// private Image backgroundImage;
		private JPanel backgroundPanel;

		// 백그라운드 패널
		public BackgroundPanel() {
			// backgroundImage = new ImageIcon("img/background.jpg").getImage();
			backgroundPanel = new JPanel();
		}

//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
//		}
	}

	public static void main(String[] args) {
		new HomePagePanel();
	}

}