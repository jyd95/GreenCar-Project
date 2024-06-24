package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import DAO.CarDAO;
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

	public DateChange2(String rentDate, String returnDate) {
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		initDate();
		setInitLayout();
		addEventListener();
	}

//	public DateChange2() {
//		initDate();
//		setInitLayout();
//		addEventListener();
//	}

	public void initDate() {
		backgroundPanel = new BackgroundPanel();
		dateChoiceBtn = new JButton(new ImageIcon("buttonImage/대여일 선택하기.png")); // 날짜 선택 이미지로 변경 예정
		updateDateBtn = new JButton(new ImageIcon("buttonImage/대여기간 변경하기.png"));
		title = new JTextField("대여기간 변경");
		logoLabel = new JLabel(new ImageIcon("img/logo2.png"));

	}

	public void setInitLayout() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

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

		setVisible(true);
	}

	public void addEventListener() {
		dateChoiceBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new datechangeSwingCalendar4(DateChange2.this);

				// 달력 열고 선택한 값 받아서 CarDAO.changeDate(null, null,
				// ReservationUpdatePage.getReceivedid());

				// null에 Date 값넣기
			}
		});

		updateDateBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "선택하신 날짜로 변경하시겠습니까 ?", "알림",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					int result2 = JOptionPane.showConfirmDialog(null, "변경되었습니다.", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
					if (result2 == JOptionPane.YES_OPTION) {
						Date rentDate1 = Date.valueOf(rentDate);
						Date returnDate1 = Date.valueOf(returnDate);
						System.out.println("dasaasddsadsadsa" + rentDate1);
						try {
							CarDAO.changeDate(rentDate1, returnDate1, ReservationUpdatePage.getReceivedid());
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						setVisible(false);
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
