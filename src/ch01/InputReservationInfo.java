package ch01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CarDAO;
import DAO.RentalCarSystem;
import DTO.ReservationPersonInfoDTO;
import main.HomePagePanel;

public class InputReservationInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JPanel contentPane;
	private ReservationSearch reservationSearch;
	private JFrame frame1;
	private String name;
	private String password;
	private String phoneNum;
	private String address;
	private String email;
	private String licenseGrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputReservationInfo frame = new InputReservationInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InputReservationInfo(String name, String password, String phoneNum, String address, String email,
			String licenseGrade) {
		this.name = name;
		this.password = password;
		this.phoneNum = phoneNum;
		this.address = address;
		this.email = email;
		this.licenseGrade = licenseGrade;
		System.out.println(name);
		System.out.println(password);
		System.out.println(phoneNum);
		System.out.println(address);
		System.out.println(email);
		System.out.println(licenseGrade);
	}

	/**
	 * Create the frame.
	 */
	public InputReservationInfo() {
		final JTextField textField;
		ImageIcon img1 = new ImageIcon("img/LOGIN.png");
		ImageIcon img2 = new ImageIcon("img/회원가입.png");

		String licenceLevel[] = { "1종", "2종" };

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 538);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(227, 143, 361, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(104, 136, 65, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(104, 192, 65, 34);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(227, 199, 361, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("로그인");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 35));
		lblNewLabel_4.setBounds(334, 29, 371, 68);
		contentPane.add(lblNewLabel_4);

		RentalCarSystem rcs = new RentalCarSystem();
		JButton btnNewButton = new JButton(img1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pw = textField_1.getText();
				if (rcs.checkLogin(id, pw)) {
					System.out.println("로그인 성공");
					HomePagePanel hpp = new HomePagePanel();
					hpp.setVisible(true);
					frame1.dispose();
				} else {
					System.out.println("로그인 실패");
					InputReservationInfo iri = new InputReservationInfo();
					iri.setVisible(true);
					setVisible(false);
				}

			}
		});
		JButton btnNewButton_1 = new JButton(img2);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String licenceNum = textField_1.getText();
				LoginPanel lg = new LoginPanel();
				lg.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(446, 259, 206, 55);
		contentPane.add(btnNewButton_1);

		btnNewButton.setBounds(177, 259, 206, 55);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_5 = new JLabel(new ImageIcon("img/logo2.png"));
		lblNewLabel_5.setBounds(691, 94, 206, 184);
		contentPane.add(lblNewLabel_5);
		JLabel background = new JLabel(new ImageIcon("img/reservation.png"));
		background.setBounds(0, 0, 1000, 561);
		contentPane.add(background);

	}
}