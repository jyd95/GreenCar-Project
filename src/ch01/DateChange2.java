package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.CarDAO;
import DTO.ReservationCarDTO;
import calendar.datechangeSwingCalendar4;

public class DateChange2 extends JFrame {

	private JPanel backgroundPanel;

	// 버튼
	private JButton dateChoiceBtn;
	private JButton updateDateBtn;

	private JTextField title;
	private JLabel logoLabel;

	private String rentDate;
	private String returnDate;

	// 분류
	private JTextField reservationid;
	private JTextField username;
	private JTextField startdate;
	private JTextField enddate;

	// 값 넣기
	private JTextField reservationidvalue[];
	private JTextField usernamevalue[];
	private JTextField startdatevalue[];
	private JTextField enddatevalue[];

	private Color headerColor = new Color(220, 220, 220);

	public DateChange2(String rentDate, String returnDate) {
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		initDate();
		setInitLayout();
		addEventListener();
	}

	public DateChange2() {
		initDate();
		setInitLayout();
		addEventListener();
	}

	public void initDate() {

		backgroundPanel = new BackgroundPanel();
		dateChoiceBtn = new JButton(new ImageIcon("img/chooseDate2.png")); // 날짜 선택 이미지로 변경 예정
		updateDateBtn = new JButton(new ImageIcon("img/changePeriod.png"));
		title = new JTextField("대여기간 변경");
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));

		reservationid = new JTextField("예약번호");
		username = new JTextField("예약자 성함");
		startdate = new JTextField("대여일");
		enddate = new JTextField("반납일");

		reservationidvalue = new JTextField[4];
		usernamevalue = new JTextField[4];
		startdatevalue = new JTextField[4];
		enddatevalue = new JTextField[4];

		for (int i = 0; i < 4; i++) {
			reservationidvalue[i] = new JTextField();
			usernamevalue[i] = new JTextField();
			startdatevalue[i] = new JTextField();
			enddatevalue[i] = new JTextField();
		}

		try {
			List<ReservationCarDTO> cardto = CarDAO.viewNameType(ReservationUpdatePage.carNameTextField().getText());
			for (int i = 0; i < cardto.size() && i < 4; i++) {
				reservationidvalue[i].setText(Integer.toString(cardto.get(i).getReservation_id()));
				usernamevalue[i].setText(cardto.get(i).getUsername());
				String rentDate1 = String.valueOf(cardto.get(i).getStart_date());
				String returnDate1 = String.valueOf(cardto.get(i).getEnd_date());
				startdatevalue[i].setText(rentDate1);
				enddatevalue[i].setText(returnDate1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void setInitLayout() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		// 분류값
		reservationid.setBounds(200, 150, 100, 40);
		username.setBounds(300, 150, 100, 40);
		startdate.setBounds(400, 150, 100, 40);
		enddate.setBounds(500, 150, 100, 40);
		reservationid.setFont(new Font("굴림", Font.PLAIN, 15));
		username.setFont(new Font("굴림", Font.PLAIN, 15));
		startdate.setFont(new Font("굴림", Font.PLAIN, 15));
		enddate.setFont(new Font("굴림", Font.PLAIN, 15));
		reservationid.setHorizontalAlignment(JTextField.CENTER);
		reservationid.setEditable(false);
		reservationid.setForeground(Color.BLACK);
		reservationid.setHorizontalAlignment(JTextField.CENTER);
		reservationid.setBackground(headerColor);
		username.setHorizontalAlignment(JTextField.CENTER);
		username.setEditable(false);
		username.setForeground(Color.BLACK);
		username.setHorizontalAlignment(JTextField.CENTER);
		username.setBackground(headerColor);
		startdate.setHorizontalAlignment(JTextField.CENTER);
		startdate.setEditable(false);
		startdate.setForeground(Color.BLACK);
		startdate.setHorizontalAlignment(JTextField.CENTER);
		startdate.setBackground(headerColor);
		enddate.setHorizontalAlignment(JTextField.CENTER);
		enddate.setEditable(false);
		enddate.setForeground(Color.BLACK);
		enddate.setHorizontalAlignment(JTextField.CENTER);
		enddate.setBackground(headerColor);
		backgroundPanel.add(reservationid);
		backgroundPanel.add(username);
		backgroundPanel.add(startdate);
		backgroundPanel.add(enddate);

		// 값넣기
		reservationidvalue[0].setBounds(200, 190, 100, 40);
		usernamevalue[0].setBounds(300, 190, 100, 40);
		startdatevalue[0].setBounds(400, 190, 100, 40);
		enddatevalue[0].setBounds(500, 190, 100, 40);

		reservationidvalue[1].setBounds(200, 230, 100, 40);
		usernamevalue[1].setBounds(300, 230, 100, 40);
		startdatevalue[1].setBounds(400, 230, 100, 40);
		enddatevalue[1].setBounds(500, 230, 100, 40);

		reservationidvalue[2].setBounds(200, 270, 100, 40);
		usernamevalue[2].setBounds(300, 270, 100, 40);
		startdatevalue[2].setBounds(400, 270, 100, 40);
		enddatevalue[2].setBounds(500, 270, 100, 40);

		reservationidvalue[3].setBounds(200, 310, 100, 40);
		usernamevalue[3].setBounds(300, 310, 100, 40);
		startdatevalue[3].setBounds(400, 310, 100, 40);
		enddatevalue[3].setBounds(500, 310, 100, 40);

		for (int i = 0; i < 4; i++) {
			reservationidvalue[i].setFont(new Font("굴림", Font.PLAIN, 15));
			reservationidvalue[i].setHorizontalAlignment(JTextField.CENTER);
			reservationidvalue[i].setEditable(false);
			reservationidvalue[i].setForeground(Color.BLACK);
			reservationidvalue[i].setHorizontalAlignment(JTextField.CENTER);
			reservationidvalue[i].setBackground(Color.white);

			usernamevalue[i].setFont(new Font("굴림", Font.PLAIN, 15));
			usernamevalue[i].setHorizontalAlignment(JTextField.CENTER);
			usernamevalue[i].setEditable(false);
			usernamevalue[i].setForeground(Color.BLACK);
			usernamevalue[i].setHorizontalAlignment(JTextField.CENTER);
			usernamevalue[i].setBackground(Color.white);

			startdatevalue[i].setFont(new Font("굴림", Font.PLAIN, 15));
			startdatevalue[i].setHorizontalAlignment(JTextField.CENTER);
			startdatevalue[i].setEditable(false);
			startdatevalue[i].setForeground(Color.BLACK);
			startdatevalue[i].setHorizontalAlignment(JTextField.CENTER);
			startdatevalue[i].setBackground(Color.white);

			enddatevalue[i].setFont(new Font("굴림", Font.PLAIN, 15));
			enddatevalue[i].setHorizontalAlignment(JTextField.CENTER);
			enddatevalue[i].setEditable(false);
			enddatevalue[i].setForeground(Color.BLACK);
			enddatevalue[i].setHorizontalAlignment(JTextField.CENTER);
			enddatevalue[i].setBackground(Color.white);

		}

		for (int i = 0; i < 4; i++) {
			backgroundPanel.add(reservationidvalue[i]);
			backgroundPanel.add(usernamevalue[i]);
			backgroundPanel.add(startdatevalue[i]);
			backgroundPanel.add(enddatevalue[i]);
		}

		title.setBounds(185, 40, 400, 80);
		title.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		title.setEditable(false);
		title.setForeground(Color.BLACK);
		title.setBackground(new Color(0, 0, 0, 0));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setFont(new Font("궁서체", Font.BOLD, 40));
		backgroundPanel.add(title);

		logoLabel.setBounds(30, 0, 105, 200);
		logoLabel.setLayout(null);
		backgroundPanel.add(logoLabel);

		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 버튼
		dateChoiceBtn.setBounds(70, 400, 300, 95);
		updateDateBtn.setBounds(430, 400, 300, 95);
		dateChoiceBtn.setBorderPainted(false);
		dateChoiceBtn.setContentAreaFilled(false);
		updateDateBtn.setBorderPainted(false);
		updateDateBtn.setContentAreaFilled(false);
		backgroundPanel.add(dateChoiceBtn);
		backgroundPanel.add(updateDateBtn);

	}

	public void addEventListener() {
		dateChoiceBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new datechangeSwingCalendar4(DateChange2.this);
				setVisible(false);
			}
		});

		updateDateBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "선택하신 날짜로 변경하시겠습니까 ?", "알림",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Date rentDate1 = Date.valueOf(rentDate);
					Date returnDate1 = Date.valueOf(returnDate);
					if (returnDate1.after(rentDate1)) {
						if (CarDAO.isDateRangeAvailable(ReservationUpdatePage.carNameTextField().getText(), rentDate1,
								returnDate1) == true) {
							int result2 = JOptionPane.showConfirmDialog(null, "변경되었습니다.", "알림",
									JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
							if (result2 == JOptionPane.YES_OPTION) {
								setVisible(false); // < 안꺼짐..
								Date rentDate2 = Date.valueOf(rentDate);
								Date returnDate2 = Date.valueOf(returnDate);
								try {
									CarDAO.changeDate(rentDate2, returnDate2, ReservationUpdatePage.getReceivedid());
									 new ReservationUpdatePage();
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showConfirmDialog(null, "이미 예약한 사람이 있습니다.", "알림", JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE);
						}
					} else {
						JOptionPane.showConfirmDialog(null, "날짜를 잘못 선택하셨습니다.", "알림", JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
	}

	private class BackgroundPanel extends JPanel {
		private Image backgroundImage;
		private JPanel backgroundPanel;

		public BackgroundPanel() {
			backgroundImage = new ImageIcon("img/updatebackground.jpg").getImage();
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
		new DateChange2(null, null);
	}
}