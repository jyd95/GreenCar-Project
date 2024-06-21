package ch01;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReservationPanel extends JFrame {
	// 백그라운드 패널
	private JPanel backgroundJPanel;

	// 메뉴 버튼
	private JButton brandFilterBtn;
	private JButton carTypeFilterBtn;
	private JButton fuelTypeFilterBtn;
	private JButton priceFilterBtn;
	private JButton licenseFilterBtn;

	// 차 버튼
	private JLabel avan;

	public ReservationPanel() {
		initData();
		setInitLayout();
	}

	public void initData() {
		// 패널
		backgroundJPanel = new BackgroundPanel();
		avan = new JLabel(new ImageIcon("img/useavan.png"));

		// 버튼
		brandFilterBtn = new JButton("브랜드");
		carTypeFilterBtn = new JButton("차종");
		fuelTypeFilterBtn = new JButton("유종");
		priceFilterBtn = new JButton("가격순");
		licenseFilterBtn = new JButton("면허");

	}

	public void setInitLayout() {
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 패널
		backgroundJPanel.setSize(getWidth(), getHeight());
		backgroundJPanel.setBackground(Color.WHITE);
		backgroundJPanel.setLayout(null);
		add(backgroundJPanel);

		// car 이미지
		avan.setBounds(0, 300, 330, 250);
		avan.setLayout(null);
		backgroundJPanel.add(avan);

		// 메뉴바 버튼
		brandFilterBtn.setBounds(150, 40, 103, 50);
		carTypeFilterBtn.setBounds(300, 40, 103, 50);
		fuelTypeFilterBtn.setBounds(450, 40, 103, 50);
		priceFilterBtn.setBounds(600, 40, 103, 50);
		licenseFilterBtn.setBounds(750, 40, 103, 50);

		brandFilterBtn.setBorder(null);
		carTypeFilterBtn.setBorder(null);
		fuelTypeFilterBtn.setBorder(null);
		priceFilterBtn.setBorder(null);
		licenseFilterBtn.setBorder(null);

		brandFilterBtn.setContentAreaFilled(false);
		carTypeFilterBtn.setContentAreaFilled(false);
		fuelTypeFilterBtn.setContentAreaFilled(false);
		priceFilterBtn.setContentAreaFilled(false);
		licenseFilterBtn.setContentAreaFilled(false);

		brandFilterBtn.setFont(new Font("궁서", Font.BOLD, 20));
		carTypeFilterBtn.setFont(new Font("궁서", Font.BOLD, 20));
		fuelTypeFilterBtn.setFont(new Font("궁서", Font.BOLD, 20));
		priceFilterBtn.setFont(new Font("궁서", Font.BOLD, 20));
		licenseFilterBtn.setFont(new Font("궁서", Font.BOLD, 20));

		backgroundJPanel.add(brandFilterBtn);
		backgroundJPanel.add(carTypeFilterBtn);
		backgroundJPanel.add(fuelTypeFilterBtn);
		backgroundJPanel.add(priceFilterBtn);
		backgroundJPanel.add(licenseFilterBtn);

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
		new ReservationPanel();
	}

}