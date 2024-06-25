package ch01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.CarDAO;

public class CarChange {

	private static String selectedCarname = null;
	private static String startDate = null;
	private static String endDate = null;

	private JFrame frame;
	private JButton btnNewButton;
	private JButton k3;
	private JButton k5;
	private JButton model3;
	private JButton nexo;
	private JButton staria;
	private JButton sonata;
	private JButton avante;
	private JButton kanibal;
	CarDAO cardao;

	private String carid;

	// 로고
	private JLabel logoLabel;
	private JLabel headerLabel;

	// 차 목록 배열

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public CarChange(String endDate, String startDate, String selectedCarname) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.selectedCarname = selectedCarname;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() {

		ImageIcon img = new ImageIcon("img/changeCar.png");

		frame = new JFrame();
		frame.setBounds(0, 0, 1000, 1000);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));
		logoLabel.setBounds(30, 0, 105, 200);
		logoLabel.setLayout(null);
		frame.add(logoLabel);

		headerLabel = new JLabel("차량 변경");
		headerLabel.setBounds(400, 40, 300, 100);
		headerLabel.setLayout(null);
		headerLabel.setFont(new Font("궁서", Font.BOLD, 40));
		frame.add(headerLabel);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(308, 67, 172, 199);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setVisible(true);
		try {
			CarDAO.possibleCarChange(endDate, startDate, selectedCarname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// todos!

		// String query = " select cm.carname from carmanagement as cm join
		// reservation as re on re.carid = cm.carid where (re.start_date > ? or
		// re.end_date < ?) and cm.carname != ? ";

		// 해당 쿼리로 jdbc 작성 후 차량변경 클래스 carchange 에 해당 날짜에
		// 예약이 가능한 차 carname 값 받아와서
		// 불리언 차량res 값을 true로 변경해 주는 기능 구현

		JTextField choiceCar = new JTextField("선택된 차량 : ");
		choiceCar.setBounds(340, 700, 135, 50);
		choiceCar.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		choiceCar.setEditable(false);
		choiceCar.setForeground(Color.BLACK);
		choiceCar.setBackground(new Color(0, 0, 0, 0));
		choiceCar.setFont(new Font("굴림", Font.BOLD, 20));
		frame.getContentPane().add(choiceCar);

		JTextField choiceCarValue = new JTextField();
		choiceCarValue.setBounds(470, 700, 130, 50);
		choiceCarValue.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
		choiceCarValue.setEditable(false);
		choiceCarValue.setForeground(Color.BLACK);
		choiceCarValue.setOpaque(false); // 배경 투명 설정
//		choiceCarValue.setBackground(new Color(0, 0, 0, 0));
		choiceCarValue.setFont(new Font("굴림", Font.BOLD, 20));
		frame.getContentPane().add(choiceCarValue);

		k3 = new JButton(new ImageIcon("img/k3.png"));
		k3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("K3");
				frame.repaint();
				carid = "47호4827";
			}
		});
		k5 = new JButton(new ImageIcon("img/k5.png"));
		k5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("K5");
				frame.repaint();
				carid = "49허3814";
			}
		});
		model3 = new JButton(new ImageIcon("img/model3.png"));
		model3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("모델3");
				frame.repaint();
				carid = "52하3362";
			}
		});
		nexo = new JButton(new ImageIcon("img/넥쏘.png"));
		nexo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("넥쏘");
				frame.repaint();
				carid = "53호6642";
			}
		});
		staria = new JButton(new ImageIcon("img/스타리아.png"));
		staria.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("스타렉스");
				frame.repaint();
				carid = "51하3942";
			}
		});
		sonata = new JButton(new ImageIcon("img/쏘나타.png"));
		sonata.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("소나타");
				frame.repaint();
				carid = "46하8247";
			}
		});
		avante = new JButton(new ImageIcon("img/아반떼.png"));
		avante.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("아반떼");
				frame.repaint();
				carid = "48허2748";
			}
		});
		kanibal = new JButton(new ImageIcon("img/카니발.png"));
		kanibal.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choiceCarValue.setText("카니발");
				frame.repaint();
				carid = "50호3827";
			}
		});
		k3.setBounds(60, 180, 200, 200);
		k3.setLayout(null);
		frame.add(k3);

		k5.setBounds(280, 180, 200, 200);
		k5.setLayout(null);
		frame.add(k5);

		model3.setBounds(500, 180, 200, 200);
		model3.setLayout(null);
		frame.add(model3);

		nexo.setBounds(720, 180, 200, 200);
		nexo.setLayout(null);
		frame.add(nexo);

		staria.setBounds(60, 440, 200, 200);
		staria.setLayout(null);
		frame.add(staria);

		sonata.setBounds(280, 440, 200, 200);
		sonata.setLayout(null);
		frame.add(sonata);

		avante.setBounds(500, 440, 200, 200);
		avante.setLayout(null);
		frame.add(avante);

		kanibal.setBounds(720, 440, 200, 200);
		kanibal.setLayout(null);
		frame.add(kanibal);

		k3.setBorder(null);
		k5.setBorder(null);
		model3.setBorder(null);
		nexo.setBorder(null);
		staria.setBorder(null);
		sonata.setBorder(null);
		avante.setBorder(null);
		kanibal.setBorder(null);

		k3.setContentAreaFilled(false);
		k5.setContentAreaFilled(false);
		model3.setContentAreaFilled(false);
		nexo.setContentAreaFilled(false);
		staria.setContentAreaFilled(false);
		sonata.setContentAreaFilled(false);
		avante.setContentAreaFilled(false);
		kanibal.setContentAreaFilled(false);

		btnNewButton = new JButton(img);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (choiceCarValue.getText().equals(ReservationUpdatePage.carNameTextField().getText())) {
					JOptionPane.showConfirmDialog(null, "이미 선택된 차량입니다.", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
				} else if (choiceCarValue.getText().equals("")) {
					JOptionPane.showConfirmDialog(null, "차량이 선택되지 않았습니다.", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
				} else if (ReservationUpdatePage.getLicenseGrade().getText().equals("2종")) {
					if (choiceCarValue.getText().equals("스타렉스") || choiceCarValue.getText().equals("카니발")) {
						JOptionPane.showConfirmDialog(null, "해당 차량은 1종면허가 필요합니다.", "알림", JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE);
					} else {
						int result = JOptionPane.showConfirmDialog(null, choiceCarValue.getText() + "로 변경하시겠습니까 ?",
								"알림", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) {
							try {
								CarDAO.changeCar(carid, ReservationUpdatePage.getReceivedid());
								int result2 = JOptionPane.showConfirmDialog(null, "변경되었습니다.", "알림",
										JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
								if (result2 == JOptionPane.YES_OPTION) {
									frame.setVisible(false);
									new ReservationUpdatePage();
									CarDAO.reservationNumSelec(ReservationUpdatePage.getReceivedid(),
											ReservationUpdatePage.getReceivedname());
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						} else {
						}
					}
//				} else if (ReservationUpdatePage.getLicenseGrade().getText().equals("1종")) {
				} else {
					int result = JOptionPane.showConfirmDialog(null, choiceCarValue.getText() + "로 변경하시겠습니까 ?", "알림",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						try {
							CarDAO.changeCar(carid, ReservationUpdatePage.getReceivedid());
							int result2 = JOptionPane.showConfirmDialog(null, "변경되었습니다.", "알림",
									JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
							if (result2 == JOptionPane.YES_OPTION) {
								frame.setVisible(false);
								new ReservationUpdatePage();
								CarDAO.reservationNumSelec(ReservationUpdatePage.getReceivedid(),
										ReservationUpdatePage.getReceivedname());
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
					}
				}
			}
		});
		btnNewButton.setBounds(300, 750, 383, 95);
		frame.getContentPane().add(btnNewButton);
		JLabel image = new JLabel(new ImageIcon("img/updatebackground.jpg"));
		image.setBounds(0, 0, 1000, 1000);
		frame.getContentPane().add(image);

		JList list = new JList();
		list.setBounds(259, 290, 257, 215);
		frame.getContentPane().add(list);

//		btnNewButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ReservationUpdatePage rup = new ReservationUpdatePage();
//				rup.setVisible(true);
//				frame.setVisible(false);
//			}
//		});
	}
}
