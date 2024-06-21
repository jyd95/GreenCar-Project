package ch01;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class InputReservationInfoNext {
	private String name;
	private String licenceNum;
	private String liceneceLevel;
	private String phoneNumber;
	private JFrame frame;
	private boolean payment = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputReservationInfoNext window = new InputReservationInfoNext();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InputReservationInfoNext() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final String afterpay = "현장 결제 : 대여시간 5분 전부터 현장 결제 후 차량 불출이 가능합니다.";
		final String prepay = "우선 결제 : 무통장 입금 계좌 = 농협 352-2474888-07-01 예금주 서치원";
		ImageIcon img1 = new ImageIcon("buttonImage/예약 확정하기.png");
		String whenPay[] = {"현장 결제 : 대여시간 5분 전부터 현장 결제 후 차량 불출이 가능합니다.","우선 결제 : 무통장 입금 계좌 = 농협 352-2474888-07-01 예금주 서치원"};
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 840, 408);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		final JList list = new JList(whenPay);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedValue().toString().equals(prepay)) {
					 
				}else {
					
				}
			}
		});
		list.setFont(new Font("굴림", Font.PLAIN, 18));
		list.setBounds(195, 62, 596, 58);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("결제 방법 선택");
		lblNewLabel.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(32, 62, 151, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton(img1);
		btnNewButton.setBounds(295, 159, 280, 67);
		frame.getContentPane().add(btnNewButton);
		
		JLabel image = new JLabel(new ImageIcon("img/페이.png"));
		image.setBounds(0, 0, 824, 369);
		frame.getContentPane().add(image);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ReservationUpdatePage rup = new ReservationUpdatePage();
				rup.setVisible(true);
				frame.setVisible(false);
			}
		});
	}

}
