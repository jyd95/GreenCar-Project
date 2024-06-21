package ch01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarDetail extends JFrame implements ActionListener {

	// 배경 패널
	JPanel backgroundPanel = new JPanel();

	// 차량 이미지 라벨
	private JLabel k3;
	private JLabel k5;
	private JLabel model3;
	private JLabel nexo;
	private JLabel staria;
	private JLabel sonata;
	private JLabel avante;
	private JLabel kanibal;

	// 차량 설명 라벨
	private JLabel scripK3;
	private JLabel scripK5;
	private JLabel scripModel3;
	private JLabel scripNexo;
	private JLabel scripStaria;
	private JLabel scripSonata;
	private JLabel scripAvante;
	private JLabel scripKanibal;

	// 차량 이미지 크기
	private int xCar = 60;
	private int yCar = 230;
	private int widthCar = 200;
	private int heightCar = 200;

	// 설명 이미지 크기
	private int xScript = 250;
	private int yScript = 80;
	private int wScript = 500;
	private int hScript = 500;

	// 예약 아이콘 버튼 크기
	private int xReservBtn = 230;
	private int yReservBtn = 500;
	private int wReservBtn = 300;
	private int hReservBtn = 300;

	// 로고 이미지
	private JLabel logoLabel;

	// 예약 버튼
	private JButton reservationL;

	// 새 창 프레임
	public CarDetail() {
		setBounds(0, 0, 800, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setInitLayout();
		setLocationRelativeTo(null);

	}

	public void setInitLayout() {

		// 배경 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 로고 라벨
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));
		logoLabel.setBounds(10, 10, 150, 150);
		logoLabel.setLayout(null);
		backgroundPanel.add(logoLabel);

		// 예약 버튼 이미지
		reservationL = new JButton(new ImageIcon("img/선택한 차량으로 예약하기.png"));
		reservationL.setBounds(xReservBtn, yReservBtn, wReservBtn, hReservBtn);
		reservationL.setLayout(null);
		reservationL.setBorder(null);
		reservationL.setContentAreaFilled(false);
		backgroundPanel.add(reservationL);
		setVisible(true);

	}

	// 새 창에 뜨는 이미지
	public void DetailK3() {

		// 차량 이미지
		k3 = new JLabel(new ImageIcon("img/k3.png"));
		k3.setBounds(xCar, yCar, widthCar, heightCar);
		k3.setLayout(null);
		backgroundPanel.add(k3);
		setVisible(true);

		// 차량 설명 이미지
		scripK3 = new JLabel(new ImageIcon("img/scripK3.png"));
		scripK3.setBounds(xScript, yScript, wScript, hScript);
		scripK3.setLayout(null);
		backgroundPanel.add(scripK3);
		setVisible(true);

	}

	public void DetailK5() {
		k5 = new JLabel(new ImageIcon("img/k5.png"));
		k5.setBounds(xCar, yCar, widthCar, heightCar);
		k5.setLayout(null);
		backgroundPanel.add(k5);
		setVisible(true);

		scripK5 = new JLabel(new ImageIcon("img/scripK5.png"));
		scripK5.setBounds(xScript, yScript, wScript, hScript);
		scripK5.setLayout(null);
		backgroundPanel.add(scripK5);
		setVisible(true);

	}

	public void DetailModel3() {
		model3 = new JLabel(new ImageIcon("img/MODEL3.png"));
		model3.setBounds(xCar, yCar, widthCar, heightCar);
		model3.setLayout(null);
		backgroundPanel.add(model3);
		setVisible(true);

		scripModel3 = new JLabel(new ImageIcon("img/scripModel3.png"));
		scripModel3.setBounds(xScript, yScript, wScript, hScript);
		scripModel3.setLayout(null);
		backgroundPanel.add(scripModel3);
		setVisible(true);

	}

	public void DetailNexo() {
		nexo = new JLabel(new ImageIcon("img/넥쏘.png"));
		nexo.setBounds(xCar, yCar, widthCar, heightCar);
		nexo.setLayout(null);
		backgroundPanel.add(nexo);
		setVisible(true);

		scripNexo = new JLabel(new ImageIcon("img/scripNexo.png"));
		scripNexo.setBounds(xScript, yScript, wScript, hScript);
		scripNexo.setLayout(null);
		backgroundPanel.add(scripNexo);
		setVisible(true);

	}

	public void DetailStaria() {
		staria = new JLabel(new ImageIcon("img/스타리아.png"));
		staria.setBounds(xCar, yCar, widthCar, heightCar);
		staria.setLayout(null);
		backgroundPanel.add(staria);
		setVisible(true);

		scripStaria = new JLabel(new ImageIcon("img/scripStaria.png"));
		scripStaria.setBounds(xScript, yScript, wScript, hScript);
		scripStaria.setLayout(null);
		backgroundPanel.add(scripStaria);
		setVisible(true);

	}

	public void DetailSonata() {
		sonata = new JLabel(new ImageIcon("img/쏘나타.png"));
		sonata.setBounds(xCar, yCar, widthCar, heightCar);
		sonata.setLayout(null);
		backgroundPanel.add(sonata);
		setVisible(true);

		scripSonata = new JLabel(new ImageIcon("img/scripSonata.png"));
		scripSonata.setBounds(xScript, yScript, wScript, hScript);
		scripSonata.setLayout(null);
		backgroundPanel.add(scripSonata);
		setVisible(true);

	}

	public void DetailAvante() {
		avante = new JLabel(new ImageIcon("img/아반떼.png"));
		avante.setBounds(xCar, yCar, widthCar, heightCar);
		avante.setLayout(null);
		backgroundPanel.add(avante);
		setVisible(true);

		scripAvante = new JLabel(new ImageIcon("img/scripAvante.png"));
		scripAvante.setBounds(xScript, yScript, wScript, hScript);
		scripAvante.setLayout(null);
		backgroundPanel.add(scripAvante);
		setVisible(true);

	}

	public void DetailKanibal() {
		kanibal = new JLabel(new ImageIcon("img/카니발.png"));
		kanibal.setBounds(xCar, yCar, widthCar, heightCar);
		kanibal.setLayout(null);
		backgroundPanel.add(kanibal);
		setVisible(true);

		scripKanibal = new JLabel(new ImageIcon("img/scripKanibal.png"));
		scripKanibal.setBounds(xScript, yScript, wScript, hScript);
		scripKanibal.setLayout(null);
		backgroundPanel.add(scripKanibal);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == reservationL) {
		// 예약 창 띄우기
		}
		
	}
}