package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class HomePagePanel2 extends JFrame implements ActionListener {

	CarDetail carDetail;

	// 패널
	private JPanel backgroundPanel;

	// 로고
	private JLabel logoLabel;

	// 차량 버튼
	private JButton k3;
	private JButton k5;
	private JButton model3;
	private JButton nexo;
	private JButton staria;
	private JButton sonata;
	private JButton avante;
	private JButton kanibal;

	public HomePagePanel2() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {
		// 패널
		backgroundPanel = new BackgroundPanel();

		// 로고 라벨
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));

		// 상단 메뉴바 버튼
//		brandFBtn = new JButton("<html><body><center>브랜드 필터</center></body></html>");
//		sortFBtn = new JButton("<html><body><center>차종 필터</center></body></html>");
//		oilFBtn = new JButton("<html><body><center>유종 필터</center></body></html>");
//		priceFBtn = new JButton("<html><body><center>가격순 필터</center></body></html>");
//		licFBtn = new JButton("<html><body><center>면허 필터</center></body></html>");

		// 차량 라벨
		k3 = new JButton(new ImageIcon("img/k3.png"));
		k5 = new JButton(new ImageIcon("img/k5.png"));
		model3 = new JButton(new ImageIcon("img/MODEL3.png"));
		nexo = new JButton(new ImageIcon("img/넥쏘.png"));
		staria = new JButton(new ImageIcon("img/스타리아.png"));
		sonata = new JButton(new ImageIcon("img/쏘나타2.png"));
		avante = new JButton(new ImageIcon("img/아반떼.png"));
		kanibal = new JButton(new ImageIcon("img/카니발2.png"));

	}

	public void setInitLayout() {
		// 프레임 설정
		setSize(1000, 1000);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		// 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// logo 이미지
		logoLabel.setBounds(10, 10, 100, 100);
		logoLabel.setLayout(null);
		backgroundPanel.add(logoLabel);

		// 차량 이미지
		k3.setBounds(60, 230, 200, 200);
		k3.setLayout(null);
		backgroundPanel.add(k3);

		k5.setBounds(280, 230, 200, 200);
		k5.setLayout(null);
		backgroundPanel.add(k5);

		model3.setBounds(500, 230, 200, 200);
		model3.setLayout(null);
		backgroundPanel.add(model3);

		nexo.setBounds(720, 230, 200, 200);
		nexo.setLayout(null);
		backgroundPanel.add(nexo);

		staria.setBounds(60, 550, 200, 200);
		staria.setLayout(null);
		backgroundPanel.add(staria);

		sonata.setBounds(280, 550, 200, 200);
		sonata.setLayout(null);
		backgroundPanel.add(sonata);

		avante.setBounds(500, 550, 200, 200);
		avante.setLayout(null);
		backgroundPanel.add(avante);

		kanibal.setBounds(720, 550, 200, 200);
		kanibal.setLayout(null);
		backgroundPanel.add(kanibal);

		// 상단 메뉴바 버튼
//		brandFBtn.setBounds(150, 40, 172, 50);
//		sortFBtn.setBounds(300, 40, 172, 50);
//		oilFBtn.setBounds(450, 40, 172, 50);
//		priceFBtn.setBounds(600, 40, 172, 50);
//		licFBtn.setBounds(750, 40, 172, 50);
//
//		brandFBtn.setBorder(null);
//		sortFBtn.setBorder(null);
//		oilFBtn.setBorder(null);
//		priceFBtn.setBorder(null);
//		licFBtn.setBorder(null);
		k3.setBorder(null);
		k5.setBorder(null);
		model3.setBorder(null);
		nexo.setBorder(null);
		staria.setBorder(null);
		sonata.setBorder(null);
		avante.setBorder(null);
		kanibal.setBorder(null);

//		brandFBtn.setContentAreaFilled(false);
//		sortFBtn.setContentAreaFilled(false);
//		oilFBtn.setContentAreaFilled(false);
//		priceFBtn.setContentAreaFilled(false);
//		licFBtn.setContentAreaFilled(false);
		k3.setContentAreaFilled(false);
		k5.setContentAreaFilled(false);
		model3.setContentAreaFilled(false);
		nexo.setContentAreaFilled(false);
		staria.setContentAreaFilled(false);
		sonata.setContentAreaFilled(false);
		avante.setContentAreaFilled(false);
		kanibal.setContentAreaFilled(false);

//		brandFBtn.setFont(new Font("궁서", Font.BOLD, 20));
//		sortFBtn.setFont(new Font("궁서", Font.BOLD, 20));
//		oilFBtn.setFont(new Font("궁서", Font.BOLD, 20));
//		priceFBtn.setFont(new Font("궁서", Font.BOLD, 20));
//		licFBtn.setFont(new Font("궁서", Font.BOLD, 20));
//
//		backgroundPanel.add(brandFBtn);
//		backgroundPanel.add(sortFBtn);
//		backgroundPanel.add(oilFBtn);
//		backgroundPanel.add(priceFBtn);
//		backgroundPanel.add(licFBtn);
		backgroundPanel.add(k3);
		backgroundPanel.add(k5);
		backgroundPanel.add(model3);
		backgroundPanel.add(nexo);
		backgroundPanel.add(staria);
		backgroundPanel.add(sonata);
		backgroundPanel.add(avante);
		backgroundPanel.add(kanibal);

		setVisible(true);
	}

	private void addEventListener() {
		k3.addActionListener(this);
		k5.addActionListener(this);
		model3.addActionListener(this);
		nexo.addActionListener(this);
		staria.addActionListener(this);
		sonata.addActionListener(this);
		avante.addActionListener(this);
		kanibal.addActionListener(this);

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
		new HomePagePanel2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == k3) {
			new CarDetail().DetailK3();
		} else if (e.getSource() == k5) {
			new CarDetail().DetailK5();
		} else if (e.getSource() == model3) {
			new CarDetail().DetailModel3();
		} else if (e.getSource() == nexo) {
			new CarDetail().DetailNexo();
		} else if (e.getSource() == staria) {
			new CarDetail().DetailStaria();
		} else if (e.getSource() == sonata) {
			new CarDetail().DetailSonata();
		} else if (e.getSource() == avante) {
			new CarDetail().DetailAvante();
		} else if (e.getSource() == kanibal) {
			new CarDetail().DetailKanibal();
		}
	}
	
	
//	k3.addMouseListener(new MouseAdapter() {
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		new CarDetail().Detailk3();
//	}
//});
//
//k5.addMouseListener(new MouseAdapter() {
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		new CarDetail().Detailk5();
//	}
//});
}