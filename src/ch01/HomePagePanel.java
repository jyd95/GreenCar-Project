package ch01;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePagePanel extends JFrame {
	// 백그라운드 패널
	private JPanel backgroundPanel;

	// 로고
	private JLabel logoLabel;

	// 메뉴 버튼
	private JButton short_termBtn;
	private JButton long_termBtn;
	private JButton usedCarBtn;

	public HomePagePanel() {
		initData();
		setInitLayout();
	}

	public void initData() {
		// 백그라운드 패널
		backgroundPanel = new BackgroundPanel();

		// 로고레이블
		logoLabel = new JLabel(new ImageIcon("img/logo1.png"));

		// 상단 메뉴바 버튼
		short_termBtn = new JButton("<html><body><center>차량으로<br>예약하기</center></body></html>\")");
		long_termBtn = new JButton("<html><body><center>날짜로<br>에약하기</center></body></html>\")");
		usedCarBtn = new JButton("<html><body><center>예약조회<br>및 변경하기</center></body></html>");
	}

	public void setInitLayout() {
		// 프레임 설정
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 백그라운드 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

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

		setVisible(true);
	}

	private class BackgroundPanel extends JPanel {
		private Image backgroundImage;
		private JPanel backgroundPanel;

		// 백그라운드 패널
		public BackgroundPanel() {
			// backgroundImage = new ImageIcon("img/background.jpg").getImage();
			backgroundPanel = new JPanel();
			add(backgroundPanel);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
		}
	}

	public static void main(String[] args) {
		new HomePagePanel();
	}

}
