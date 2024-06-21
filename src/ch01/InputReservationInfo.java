package ch01;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputReservationInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel contentPane;
	private ReservationSearch reservationSearch;
	private JFrame frame1;
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

	/**
	 * Create the frame.
	 */
	public InputReservationInfo() {
		final JTextField textField;
		ImageIcon img1 = new ImageIcon("buttonImage/결제하기.png");
		
		String licenceLevel[] = {"1종","2종"};
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(215, 119, 361, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 119, 97, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("운전면허증 번호");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(35, 162, 147, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("운전면허증 종류");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(35, 206, 147, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(35, 250, 147, 34);
		contentPane.add(lblNewLabel_3);
		
		final JComboBox comboBox = new JComboBox(licenceLevel);
		comboBox.setBounds(215, 212, 116, 23);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(215, 166, 361, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(215, 250, 361, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("비회원으로 예약하기");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 35));
		lblNewLabel_4.setBounds(215, 28, 371, 68);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton(img1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputReservationInfoNext irin = new InputReservationInfoNext();
				irin.main(null);
				setVisible(false);
			}
		});
		
		btnNewButton.setBounds(265, 321, 244, 55);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel(new ImageIcon("img/logo2.png"));
		lblNewLabel_5.setBounds(691, 94, 206, 184);
		contentPane.add(lblNewLabel_5);
		JLabel background = new JLabel(new ImageIcon("img/reservation.png"));
		background.setBounds(0, 0, 1000, 600);
		contentPane.add(background);
		
		
	}
}
