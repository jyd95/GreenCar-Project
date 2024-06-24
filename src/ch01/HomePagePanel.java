package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

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

<<<<<<< HEAD:src/main/HomePagePanel.java
import ch01.CarReservationPanel;
import ch01.DiaryReservationPanel;
import ch01.InputReservationInfo;
import ch01.ReservationSearch;

=======
>>>>>>> 11f7854c383deecb27093032461b13b03b864d5c:src/ch01/HomePagePanel.java
public class HomePagePanel extends JFrame {
	public static String username = null;
	public static int movement = 0;
	// movement 의 값, 0 = 초기값, 1 = 차량으로 예약하기, 2 = 날짜로 예약하기.

	// 패널
	private JPanel backgroundPanel;
	private JPanel searchPanel;

	// 로고
	private JLabel logoLabel;
	private JLabel usernameLabel;

	// 메뉴 버튼
	private JButton carReserveBtn;
	private JButton dateReserveBtn;
	private JButton usedCarBtn;

	// 검색 보드
	private JTextArea mainSearchBox;
	private JTextField writeSearchBox;
	private ImageIcon dotbogyImg;
	private JButton searchBtn;

	// main 이미지
	private JLabel greenCarLabel1;
	private JLabel greenCarLabel2;

	/// 이미지 교체 타이머
	private Timer timer;
	private int currentImageIndex = 0;

	public HomePagePanel(String username) {
		this.username = username;
		initData();
		setInitLayout();
		initListener();
		addBtnListener();
	}

	public void initData() {
		// 패널
		backgroundPanel = new BackgroundPanel();
		searchPanel = new JPanel();

		// 로고레이블
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));

		// 상단 메뉴바 버튼
		carReserveBtn = new JButton("<html><body><center>차량으로<br>예약하기</center></body></html>\")");
		dateReserveBtn = new JButton("<html><body><center>날짜로<br>예약하기</center></body></html>\")");
		usedCarBtn = new JButton("<html><body><center>예약조회<br>및 변경하기</center></body></html>");

		// 검색 기능
		mainSearchBox = new JTextArea();
		writeSearchBox = new JTextField(47);
		dotbogyImg = new ImageIcon("img/zoomin.png");
		searchBtn = new JButton(dotbogyImg);

		// main 이미지
		greenCarLabel1 = new JLabel(new ImageIcon("img/backgroundImg.jpg"));
		greenCarLabel2 = new JLabel(new ImageIcon("img/backgroundImg2.jpg"));
		usernameLabel = new JLabel(username + "님, 환영합니다.");
		usernameLabel.setBounds(750, -80, 105, 200);
		usernameLabel.setLayout(null);
		backgroundPanel.add(usernameLabel);
	}

	public void setInitLayout() {
		// 프레임 설정
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
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
		logoLabel.setBounds(30, 0, 105, 200);
		logoLabel.setLayout(null);
		backgroundPanel.add(logoLabel);

		// main logo
		greenCarLabel1.setBounds(0, 330, 1001, 668);
		greenCarLabel2.setBounds(0, 330, 1001, 668);

		greenCarLabel1.setLayout(null);
		greenCarLabel2.setLayout(null);

		backgroundPanel.add(greenCarLabel1);
		backgroundPanel.add(greenCarLabel2);

		// 상단 메뉴바 버튼
		carReserveBtn.setBounds(300, 40, 103, 50);
		dateReserveBtn.setBounds(500, 40, 103, 50);
		usedCarBtn.setBounds(700, 40, 172, 50);

		carReserveBtn.setBorder(null);
		dateReserveBtn.setBorder(null);
		usedCarBtn.setBorder(null);

		carReserveBtn.setContentAreaFilled(false);
		dateReserveBtn.setContentAreaFilled(false);
		usedCarBtn.setContentAreaFilled(false);

		carReserveBtn.setFont(new Font("궁서", Font.BOLD, 20));
		dateReserveBtn.setFont(new Font("궁서", Font.BOLD, 20));
		usedCarBtn.setFont(new Font("궁서", Font.BOLD, 20));

		backgroundPanel.add(carReserveBtn);
		backgroundPanel.add(dateReserveBtn);
		backgroundPanel.add(usedCarBtn);

		// 검색 박스
		// mainSearchBox.setBounds(400, 200, 1000, 40);
		searchBtn.setBorder(null);
		searchBtn.setContentAreaFilled(false);
		searchBtn.setFont(new Font("궁서", Font.BOLD, 20));

		backgroundPanel.add(mainSearchBox);

		setVisible(true);

		carReserveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				movement = 1;
				CarReservationPanel crp = new CarReservationPanel();
				crp.setVisible(true);
				setVisible(false);
			}
		});

		usedCarBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ReservationSearch rs = new ReservationSearch();
				rs.main(null);
			}
		});

	}

	private void initListener() {
		writeSearchBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});
	}

	private void sendMessage() {
		if (!writeSearchBox.getText().equals(null)) {
			String message = writeSearchBox.getText();
			System.out.println(message);
			writeSearchBox.setText("");
			writeSearchBox.requestFocus();
		}
	}

	public void addBtnListener() {
		dateReserveBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				movement = 2;
				new DiaryReservationPanel();
				setVisible(false);

			}
		});
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
		new HomePagePanel(username);
	}

}