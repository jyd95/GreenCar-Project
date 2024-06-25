package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.CarDAO;
import DTO.ReservationDTO;

public class ReservationUpdatePage extends JFrame {
	private JPanel backgroundPanel;
	
	// 버튼
	private JButton updateCarBtn;
	private JButton updateDateBtn;
	private JButton cancelReservationBtn;
	private ImageIcon periodImg;
	private ImageIcon changeCarImg;
	private ImageIcon cancelImg;

	// 분류
	private JTextField reservationPersonInfo;
	private JTextField reservationCarInfo;
	private JTextField reservationId;
	private JTextField reservationname;
	private JTextField reservationPhoneNumber;
	private JTextField reservationCarType;
	private JTextField reservationCarBrand;
	private JTextField reservationCarPuel;
	private JTextField reservationCarRentDate;
	private JTextField reservationCarReturnDate;
	private Color headerColor = new Color(220, 220, 220);

	// 넘어온 값
	private static int receivedid;
	private static String receivedname;
	private static String receivedCarname;
	private static String receivedStartDate;
	private static String receivedEndDate;
	
	
	
	// 예약자 정보 값
	private JTextField id;
	private JTextField name;
	private JTextField phoneNumber;
	private static JTextField licenseGrade;
	
	// 차량 정보 값
	private static JTextField carName;
	private JTextField carNumber;
	private JTextField cartype;
	private JTextField carbrand;
	private JTextField carpuel;
	private JTextField rentdate;
	private JTextField returndate;

	// 제목
	private JTextField title;

	// 로고
	private JLabel logoLabel;

	// 차량 이미지
	private JLabel imgLabel;
	private String carPicture;
	
	public static int getReceivedid() {
		return receivedid;
	}

	public static String getReceivedname() {
		return receivedname;
	}
	
	public static JTextField carNameTextField() {
		return carName;
	}
	
	public static JTextField getLicenseGrade() {
		return licenseGrade;
	}
	

	public ReservationUpdatePage(int receivedid, String receivedname) {
		this.receivedid = receivedid;
		this.receivedname = receivedname;
		initData();
		setInitLayout();
		addEventListener();
		rvDTO();
	}
	public ReservationUpdatePage(String receivedCarname, String receivedStartDate, String receivedEndDate) {
		this.receivedCarname = receivedCarname;
		this.receivedStartDate = receivedStartDate;
		this.receivedEndDate = receivedEndDate;
		initData();
		setInitLayout();
		addEventListener();
	}
	
	

	public ReservationUpdatePage() {
		initData();
		setInitLayout();
		addEventListener();
	}

	
	
	public void rvDTO() {
		ReservationDTO dto = CarDAO.reservationNumSelec(receivedid, receivedname);
		id.setText(Integer.toString(dto.getReservation_id()));
		name.setText((dto.getUsername()));
		phoneNumber.setText((dto.getPhonenum()));
		carName.setText(dto.getCarname());
		carNumber.setText(dto.getCarid());
		cartype.setText((dto.getCartype()));
		carbrand.setText((dto.getBrand()));
		carpuel.setText((dto.getPuel()));
		licenseGrade.setText(dto.getLicenseGrade());
		rentdate.setText((dto.getStart_date().toString()));
		returndate.setText((dto.getEnd_date().toString()));

		// 차량 이미지
		imgLabel = new JLabel(new ImageIcon(setCarPicture(dto.getCarname())));
		imgLabel.setBounds(40, 330, 350, 200);
		backgroundPanel.add(imgLabel);

	}
	
	
	public void initData() {

		backgroundPanel = new BackgroundPanel();

		// 제목
		title = new JTextField("예약 정보");
		// 로고
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));

		// 버튼
		periodImg = new ImageIcon("img/changePeriod.png");
		changeCarImg = new ImageIcon("img/changeCar.png");
		cancelImg = new ImageIcon("img/cancelImg.png");
		updateCarBtn = new JButton(changeCarImg);
		updateDateBtn = new JButton(periodImg);
		cancelReservationBtn = new JButton(cancelImg);

		// 예약자 정보 분류
		reservationPersonInfo = new JTextField("예약자 정보");
		reservationId = new JTextField("예약 번호");
		reservationname = new JTextField("성함");
		reservationPhoneNumber = new JTextField("전화번호");

		// 차량 정보 분류
		reservationCarInfo = new JTextField("예약된 차량 정보");
		reservationCarType = new JTextField("차종");
		reservationCarBrand = new JTextField("차량 브랜드");
		reservationCarPuel = new JTextField("차량 유종");
		reservationCarRentDate = new JTextField("대여일");
		reservationCarReturnDate = new JTextField("반납일");

		// 값 받아오기
		carName = new JTextField();
		carNumber = new JTextField();
		id = new JTextField();
		name = new JTextField();
		phoneNumber = new JTextField();
		cartype = new JTextField();
		carName = new JTextField();
		carbrand = new JTextField();
		carpuel = new JTextField();
		rentdate = new JTextField();
		returndate = new JTextField();
		
		// 1종 2종 값만 받아오기, 출력 x
		licenseGrade = new JTextField();
		
	}

	public void setInitLayout() {

		// 프레임 설정
		setSize(800, 900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		// 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 제목
		title.setBounds(185, 40, 400, 80);
		title.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		title.setEditable(false);
		title.setForeground(Color.BLACK);
		title.setBackground(new Color(0,0,0,0));
		title.setHorizontalAlignment(JTextField.CENTER);
		title.setFont(new Font("궁서체", Font.BOLD, 40));
		backgroundPanel.add(title);

		// 로고
		logoLabel.setBounds(30, 0, 105, 200);
		logoLabel.setLayout(null);
		backgroundPanel.add(logoLabel);

		// 차량 값
		carName.setBounds(120, 160, 160, 50);
		carName.setFont(new Font("굴림", Font.BOLD, 20));
		carName.setHorizontalAlignment(JTextField.CENTER);
		carName.setEditable(false);
		carName.setForeground(Color.BLACK);
		carName.setHorizontalAlignment(JTextField.CENTER);
		carName.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		backgroundPanel.add(carName);

		carNumber.setBounds(145, 220, 100, 30);
		carNumber.setFont(new Font("굴림", Font.BOLD, 15));
		carNumber.setHorizontalAlignment(JTextField.CENTER);
		carNumber.setEditable(false);
		carNumber.setForeground(Color.BLACK);
		carNumber.setHorizontalAlignment(JTextField.CENTER);
		carNumber.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		backgroundPanel.add(carNumber);

		cartype.setBounds(549, 400, 190, 30);
		cartype.setBorder(new LineBorder(new Color(0, 0, 0)));
		cartype.setHorizontalAlignment(JTextField.CENTER);
		cartype.setEditable(false);
		cartype.setForeground(Color.BLACK);
		cartype.setBackground(Color.white);
		backgroundPanel.add(cartype);

		carbrand.setBounds(549, 430, 190, 30);
		carbrand.setBorder(new LineBorder(new Color(0, 0, 0)));
		carbrand.setHorizontalAlignment(JTextField.CENTER);
		carbrand.setEditable(false);
		carbrand.setForeground(Color.BLACK);
		carbrand.setBackground(Color.white);
		backgroundPanel.add(carbrand);

		carpuel.setBounds(549, 460, 190, 30);
		carpuel.setBorder(new LineBorder(new Color(0, 0, 0)));
		carpuel.setHorizontalAlignment(JTextField.CENTER);
		carpuel.setEditable(false);
		carpuel.setForeground(Color.BLACK);
		carpuel.setBackground(Color.white);
		backgroundPanel.add(carpuel);

		rentdate.setBounds(549, 490, 190, 30);
		rentdate.setBorder(new LineBorder(new Color(0, 0, 0)));
		rentdate.setHorizontalAlignment(JTextField.CENTER);
		rentdate.setEditable(false);
		rentdate.setForeground(Color.BLACK);
		rentdate.setBackground(Color.white);
		backgroundPanel.add(rentdate);

		returndate.setBounds(549, 520, 190, 30);
		returndate.setBorder(new LineBorder(new Color(0, 0, 0)));
		returndate.setHorizontalAlignment(JTextField.CENTER);
		returndate.setEditable(false);
		returndate.setForeground(Color.BLACK);
		returndate.setBackground(Color.white);
		backgroundPanel.add(returndate);

		// 차량 이미지
		

		// 예약자 값
		id.setBounds(549, 250, 190, 30);
		id.setHorizontalAlignment(JTextField.CENTER);
		id.setBorder(new LineBorder(new Color(0, 0, 0)));
		id.setEditable(false);
		id.setForeground(Color.BLACK);
		id.setBackground(Color.white);
		backgroundPanel.add(id);

		name.setBounds(549, 280, 190, 30);
		name.setHorizontalAlignment(JTextField.CENTER);
		name.setBorder(new LineBorder(new Color(0, 0, 0)));
		name.setEditable(false);
		name.setForeground(Color.BLACK);
		name.setBackground(Color.white);
		backgroundPanel.add(name);

		phoneNumber.setBounds(549, 310, 190, 30);
		phoneNumber.setHorizontalAlignment(JTextField.CENTER);
		phoneNumber.setBorder(new LineBorder(new Color(0, 0, 0)));
		phoneNumber.setEditable(false);
		phoneNumber.setForeground(Color.BLACK);
		phoneNumber.setBackground(Color.white);
		backgroundPanel.add(phoneNumber);

		// 버튼
		updateCarBtn.setBounds(70, 630, 300, 95);
		updateDateBtn.setBounds(430, 630, 300, 95);
		cancelReservationBtn.setBounds(250, 770, 276, 67);
		cancelReservationBtn.setBorderPainted(false);
		cancelReservationBtn.setContentAreaFilled(false);
		updateCarBtn.setBorderPainted(false);
		updateCarBtn.setContentAreaFilled(false);
		updateDateBtn.setBorderPainted(false);
		updateDateBtn.setContentAreaFilled(false);
		
		backgroundPanel.add(updateCarBtn);
		backgroundPanel.add(updateDateBtn);
		backgroundPanel.add(cancelReservationBtn);

		// 예약자 정보 분류
		reservationPersonInfo.setBounds(450, 210, 100, 30);
		reservationPersonInfo.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		reservationPersonInfo.setEditable(false);
		reservationPersonInfo.setForeground(Color.BLACK);
		reservationPersonInfo.setBackground(new Color(0, 0, 0, 0));
		backgroundPanel.add(reservationPersonInfo);

		reservationId.setBounds(450, 250, 100, 30);
		reservationId.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationId.setEditable(false);
		reservationId.setForeground(Color.BLACK);
		reservationId.setBackground(headerColor);
		reservationId.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationId);

		reservationname.setBounds(450, 280, 100, 30);
		reservationname.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationname.setEditable(false);
		reservationname.setForeground(Color.BLACK);
		reservationname.setBackground(headerColor);
		reservationname.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationname);

		reservationPhoneNumber.setBounds(450, 310, 100, 30);
		reservationPhoneNumber.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationPhoneNumber.setEditable(false);
		reservationPhoneNumber.setForeground(Color.BLACK);
		reservationPhoneNumber.setBackground(headerColor);
		reservationPhoneNumber.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationPhoneNumber);

		// 차량 정보 분류
		reservationCarInfo.setBounds(450, 360, 100, 30);
		reservationCarInfo.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		reservationCarInfo.setEditable(false);
		reservationCarInfo.setForeground(Color.BLACK);
		reservationCarInfo.setBackground(new Color(0, 0, 0, 0));
		backgroundPanel.add(reservationCarInfo);

		reservationCarType.setBounds(450, 400, 100, 30);
		reservationCarType.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarType.setEditable(false);
		reservationCarType.setForeground(Color.BLACK);
		reservationCarType.setBackground(headerColor);
		reservationCarType.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationCarType);

		reservationCarBrand.setBounds(450, 430, 100, 30);
		reservationCarBrand.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarBrand.setEditable(false);
		reservationCarBrand.setForeground(Color.BLACK);
		reservationCarBrand.setBackground(headerColor);
		reservationCarBrand.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationCarBrand);

		reservationCarPuel.setBounds(450, 460, 100, 30);
		reservationCarPuel.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarPuel.setEditable(false);
		reservationCarPuel.setForeground(Color.BLACK);
		reservationCarPuel.setBackground(headerColor);
		reservationCarPuel.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationCarPuel);

		reservationCarRentDate.setBounds(450, 490, 100, 30);
		reservationCarRentDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarRentDate.setEditable(false);
		reservationCarRentDate.setForeground(Color.BLACK);
		reservationCarRentDate.setBackground(headerColor);
		reservationCarRentDate.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationCarRentDate);

		reservationCarReturnDate.setBounds(450, 520, 100, 30);
		reservationCarReturnDate.setBorder(new LineBorder(new Color(0, 0, 0)));
		reservationCarReturnDate.setEditable(false);
		reservationCarReturnDate.setForeground(Color.BLACK);
		reservationCarReturnDate.setBackground(headerColor);
		reservationCarReturnDate.setHorizontalAlignment(JTextField.CENTER);
		backgroundPanel.add(reservationCarReturnDate);

		setVisible(true);

	}

	private String setCarPicture(String carName) {
		if (carName.equals("카니발")) {
			carPicture = "img/1카니발.png";
		} else if (carName.equals("K3")) {
			carPicture = "img/1K3.png";
		} else if (carName.equals("K5")) {
			carPicture = "img/1K5.png";
		} else if (carName.equals("모델3")) {
			carPicture = "img/1모델3.png";
		} else if (carName.equals("넥쏘")) {
			carPicture = "img/1넥쏘.png";
		} else if (carName.equals("스타렉스")) {
			carPicture = "img/1스타리아.png";
		} else if (carName.equals("쏘나타")) {
			carPicture = "img/1쏘나타.png";
		} else if (carName.equals("아반떼")) {
			carPicture = "img/1아반떼.png";
		} else {
			
		}
		return carPicture;
	}

	private class BackgroundPanel extends JPanel {
		private Image backgroundImage;
		private JPanel backgroundPanel;

		// 백그라운드 패널
		public BackgroundPanel() {
			backgroundImage = new ImageIcon("img/updatebackground.jpg").getImage();
			backgroundPanel = new JPanel();
			add(backgroundPanel);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
			g.drawRoundRect(30, 185, 730, 400, 20, 20);
		}
		
	}

	private void addEventListener() {
		updateCarBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				dispose();
				CarChange cc = new CarChange(returndate.getText(), rentdate.getText(), carName.getText());
			}
		});
		updateDateBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new DateChange2(null,null);
				setVisible(false);
			}
		});
		cancelReservationBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말 취소 하시겠습니까 ?", "알림", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					int result2 = JOptionPane.showConfirmDialog(null, "취소 되었습니다.", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
					if (result2 == JOptionPane.YES_OPTION) {
						CarDAO.DeleteReservation(receivedid);
						setVisible(false);
					} else {
					}
				} else {
				}
			}
		});
	}

	public static void main(String[] args) {
		new ReservationUpdatePage();
	}
}