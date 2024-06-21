package ch01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.imageio.stream.CloseableDisposerRecord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.HomePagePanel;

import java.awt.TextField;
import java.awt.Font;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@AllArgsConstructor
@Getter
@Setter
public class ReservationSearch {
	
	
	HomePagePanel mContext;
	private JFrame frame;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setBounds(100, 100, 784, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("예약번호 입력");
		lblNewLabel.setFont(new Font("CookieRunOTF Bold", Font.PLAIN, 24));
		lblNewLabel.setBounds(34, 93, 165, 122);
		frame.getContentPane().add(lblNewLabel);

		final TextField textField = new TextField();
		textField.setBounds(231, 129, 336, 42);
		frame.getContentPane().add(textField);

		JButton btnNewButton = new JButton(img);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = textField.getText();
				int id = Integer.parseInt(text); // id = 예약번호
				// 예약정보창(id){} -> 예약정보창 띄우기
				// 서치원 - 예약정보창 구성중 
			}
		});
		btnNewButton.setBounds(231, 253, 336, 74);
		frame.getContentPane().add(btnNewButton);

	}
	
}
