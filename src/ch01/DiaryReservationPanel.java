package ch01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import calendar.SwingCalendar3;
import main.HomePagePanel;

public class DiaryReservationPanel extends JFrame {

	// 패널
	private JPanel backgroundPanel;

	// 상단 로고
	private JLabel logoLabel;

	// 로고
	private JLabel midLabel;
	private JLabel calendarLabel;

	// 버튼
	private JButton reserveBtn;
	private JButton rentDateBtn;
	private JButton rturnDateBtn;

	// 이미지
	private ImageIcon reserveImg;
	private ImageIcon rentImg;
	private ImageIcon returnImg;

	public DiaryReservationPanel() {
		initData();
		setInitLayout();
		addBtnListener();
	}

	public void initData() {
		// 패널
		backgroundPanel = new JPanel();

		// 로고
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));
		midLabel = new JLabel(new ImageIcon("img/reserveLogo3.png"));
		calendarLabel = new JLabel(new ImageIcon("img/calender.png"));

		// 이미지
		reserveImg = new ImageIcon("img/reserveBtn.png");
		rentImg = new ImageIcon("img/rentDateBtn.png");
		returnImg = new ImageIcon("img/returnDateBtn.png");
		// 버튼
		reserveBtn = new JButton(reserveImg);
		rentDateBtn = new JButton(rentImg);
		rturnDateBtn = new JButton(returnImg);

	}

	public void setInitLayout() {
		setSize(1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);

		// 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// logo 이미지
		logoLabel.setBounds(30, 0, 105, 200);
		logoLabel.setLayout(null);
		backgroundPanel.add(logoLabel);

		// 미드 로고
		midLabel.setBounds(250, 150, 500, 700);
		calendarLabel.setBounds(250, 100, 500, 700);

		midLabel.setLayout(null);
		calendarLabel.setLayout(null);

		backgroundPanel.add(calendarLabel);
		backgroundPanel.add(midLabel);

		// 버튼
		reserveBtn.setBounds(330, 700, 370, 50);
		rentDateBtn.setBounds(270, 630, 300, 50);
		rturnDateBtn.setBounds(460, 630, 300, 50);

		reserveBtn.setBorder(null);
		rentDateBtn.setBorder(null);
		rturnDateBtn.setBorder(null);

		reserveBtn.setContentAreaFilled(false);
		rentDateBtn.setContentAreaFilled(false);
		rturnDateBtn.setContentAreaFilled(false);

		backgroundPanel.add(reserveBtn, 0);
		backgroundPanel.add(rentDateBtn, 0);
		backgroundPanel.add(rturnDateBtn, 0);

		setVisible(true);
	}

	public void addBtnListener() {
		rentDateBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new SwingCalendar3();

			}
		});
		rturnDateBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new SwingCalendar3();

			}
		});
		logoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HomePagePanel();
				setVisible(false);
			}
		});
	}

}