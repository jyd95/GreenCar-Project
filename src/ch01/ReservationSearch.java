package ch01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.HomePagePanel;

@AllArgsConstructor
@Getter
@Setter
public class ReservationSearch {
	
	
	HomePagePanel mContext;
	private JFrame frame;
	private JTextField nameTextField;
	private JTextField idTextField;
	private JLabel logoLabel;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ReservationSearch();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationSearch window = new ReservationSearch();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ReservationSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon img = new ImageIcon("buttonImage/예약조회 및 변경하기.png");
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(72, 209, 204));
		frame.setTitle("예약 조회");
		frame.getContentPane().setFont(new Font("굴림", Font.PLAIN, 15));
		frame.setBounds(600, 250, 550, 400);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));
		logoLabel.setBounds(30, 0, 105, 200);
		logoLabel.setLayout(null);
		frame.add(logoLabel);

		JLabel lblNewLabel = new JLabel("예약번호 입력 : ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(170, 10, 165, 122);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("   이름 입력    : ");
		lblNewLabel1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel1.setBounds(170, 80, 165, 122);
		frame.getContentPane().add(lblNewLabel1);

		idTextField = new JTextField();
		idTextField.setBounds(330, 50, 150, 42);
		frame.getContentPane().add(idTextField);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(330,120,150,42);
		frame.getContentPane().add(nameTextField);

		JButton btnNewButton = new JButton(img);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String text = idTextField.getText();
				int id = Integer.parseInt(text); // id = 예약번호
				String name = nameTextField.getText();
				// 예약정보창(id){} -> 예약정보창 띄우기
				try {
					ReservationUpdatePage rup = new ReservationUpdatePage(id,name);
					rup.setVisible(true);
					frame.setVisible(false);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "이름과 예약번호가 일치하지 않습니다.", "알림", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		btnNewButton.setBounds(100, 220, 336, 74);
		frame.getContentPane().add(btnNewButton);
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("img/updatebackground.jpg"));
		lblNewLabel_1.setBounds(0, 0, 784, 461);
		frame.getContentPane().add(lblNewLabel_1);
		
//		JLabel background = new JLabel(new ImageIcon("img/예약조회.png"));
//		background.setBounds(0, 0, 1000, 600);
//		frame.getContentPane().add(background);
	}
	
}
