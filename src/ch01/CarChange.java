package ch01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CarChange {

	private JFrame frame;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarChange window = new CarChange();
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
	public CarChange() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ImageIcon img = new ImageIcon("buttonImage/차량 변경하기.png");
		


		frame = new JFrame();
		frame.setBounds(0,0,800,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("변경 가능한 차량");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("CookieRunOTF Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(308, 67, 172, 199);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton(img);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 차량 변경 쿼리 executeupdate()
				// 
				
			}
		});
		btnNewButton.setBounds(265, 550, 257, 80);
		frame.getContentPane().add(btnNewButton);
		JLabel image = new JLabel(new ImageIcon("img/단풍이미지.png"));
		image.setBounds(0, 0, 800, 800);
		frame.getContentPane().add(image);
		
		JList list = new JList();
		list.setBounds(259, 290, 257, 215);
		frame.getContentPane().add(list);
		
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
