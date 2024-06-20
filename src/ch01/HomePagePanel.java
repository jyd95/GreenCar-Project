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
	private JButton customerServiceBtn;

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
		short_termBtn = new JButton("단기렌터카");
		long_termBtn = new JButton("장기렌터카");
		usedCarBtn = new JButton("중고차 장기렌터카");
		customerServiceBtn = new JButton("고객센터");
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
		customerServiceBtn.setBounds(810, 40, 103, 50);

		short_termBtn.setBorder(null);
		long_termBtn.setBorder(null);
		usedCarBtn.setBorder(null);
		customerServiceBtn.setBorder(null);

		short_termBtn.setContentAreaFilled(false);
		long_termBtn.setContentAreaFilled(false);
		usedCarBtn.setContentAreaFilled(false);
		customerServiceBtn.setContentAreaFilled(false);

		short_termBtn.setFont(new Font("궁서", Font.BOLD, 20));
		long_termBtn.setFont(new Font("궁서", Font.BOLD, 20));
		usedCarBtn.setFont(new Font("궁서", Font.BOLD, 20));
		customerServiceBtn.setFont(new Font("궁서", Font.BOLD, 20));

		backgroundPanel.add(short_termBtn);
		backgroundPanel.add(long_termBtn);
		backgroundPanel.add(usedCarBtn);
		backgroundPanel.add(customerServiceBtn);

		setVisible(true);
	}

	private class BackgroundPanel extends JPanel {
		private Image backgroundImage;
		private JPanel backgroundPanel;

		// 백그라운드 패널
		public BackgroundPanel() {
			//backgroundImage = new ImageIcon("img/background.jpg").getImage();
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
