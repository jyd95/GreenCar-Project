package ch01;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.CarDAO;
import DTO.ReservationPersonInfoDTO;
import lombok.Data;
import main.Login;

@Data

public class LoginPanel extends JFrame {

	// 배경 패널
	private JPanel backgroundPanel;

	// 로고
	private JLabel greeeCarLogo;

	// 이미지
	private ImageIcon signUpBtnImg;
	private ImageIcon duplicaioncheckBtnImg1;
	private ImageIcon duplicaioncheckBtnImg2;
	private ImageIcon duplicaioncheckBtnImg3;

	// 레이블
	private JLabel idLabel;
	private JLabel pwdLabel;
	private JLabel licenseGradeLabel;
	private JLabel phoneNumLabel;
	private JLabel addressLabel;
	private JLabel emailLabel;
	private JLabel possibleLabel;

	// 텍스트 필드
	private JTextField idTextField;
	private JTextField pwdTextField;
	private JTextField phoneNumField;
	private JTextField addressField;
	private JTextField emailField;

	// 버튼
	private JButton signUpBtn;
	private JButton duplicateBtn;

	// 면허 종
	String licenceLevel[] = { "1종", "2종" };

	// 콤보 박수
	private JComboBox comboBox;

	// 중복 체크 카운트
	private int duplicationCount = 0;

	public LoginPanel() {
		initData();
		setInitLayout();
		addEventListener();
	}

	public void initData() {

		// 패널
		backgroundPanel = new JPanel();

		// 로고
		greeeCarLogo = new JLabel(new ImageIcon("img/logo2.png"));

		// id, pwd 라벨
		idLabel = new JLabel("아이디");
		pwdLabel = new JLabel("비밀번호");
		licenseGradeLabel = new JLabel("면허 종류");
		phoneNumLabel = new JLabel("핸드폰 번호");
		addressLabel = new JLabel("주소");
		emailLabel = new JLabel("이메일");
		possibleLabel = new JLabel("중복된 아이디 입니다");

		// 텍스트 필드
		idTextField = new JTextField();
		pwdTextField = new JTextField();
		phoneNumField = new JTextField();
		addressField = new JTextField();
		emailField = new JTextField();

		// 콤보 박스
		comboBox = new JComboBox(licenceLevel);

		// 버튼
		signUpBtnImg = new ImageIcon("img/회원가입.png");
		duplicaioncheckBtnImg1 = new ImageIcon("buttonImage/duplicationcheckBtn1.png");
		duplicaioncheckBtnImg2 = new ImageIcon("buttonImage/duplicationcheckBtn2.png");
		duplicaioncheckBtnImg3 = new ImageIcon("buttonImage/duplicationcheckBtn3.png");
		signUpBtn = new JButton(signUpBtnImg);
		duplicateBtn = new JButton(duplicaioncheckBtnImg1);
	}

	public void setInitLayout() {

		// 프레임 설정
		setTitle("회원가입");
		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		// 백그라운드 패널
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);

		// 로고
		greeeCarLogo.setBounds(230, 10, 120, 130);
		backgroundPanel.add(greeeCarLogo);

		// 라벨
		idLabel.setBounds(100, 100, 200, 200);
		idLabel.setFont(new Font("궁서", Font.BOLD, 20));
		backgroundPanel.add(idLabel);

		pwdLabel.setBounds(100, 200, 200, 200);
		pwdLabel.setFont(new Font("궁서", Font.BOLD, 20));
		backgroundPanel.add(pwdLabel);

		licenseGradeLabel.setBounds(100, 300, 200, 200);
		licenseGradeLabel.setFont(new Font("궁서", Font.BOLD, 20));
		backgroundPanel.add(licenseGradeLabel);

		phoneNumLabel.setBounds(100, 400, 200, 200);
		phoneNumLabel.setFont(new Font("궁서", Font.BOLD, 20));
		backgroundPanel.add(phoneNumLabel);

		addressLabel.setBounds(100, 500, 200, 200);
		addressLabel.setFont(new Font("궁서", Font.BOLD, 20));
		backgroundPanel.add(addressLabel);

		emailLabel.setBounds(100, 600, 200, 200);
		emailLabel.setFont(new Font("궁서", Font.BOLD, 20));
		backgroundPanel.add(emailLabel);

		possibleLabel.setBounds(220, 135, 200, 200);
		possibleLabel.setFont(new Font("궁서", Font.BOLD, 12));
		possibleLabel.setForeground(new Color(255, 0, 0));
		backgroundPanel.add(possibleLabel);
		possibleLabel.setVisible(false);

		// JText필드

		idTextField.setBounds(220, 175, 180, 50);
		backgroundPanel.add(idTextField);

		pwdTextField.setBounds(220, 270, 180, 50);
		backgroundPanel.add(pwdTextField);

		phoneNumField.setBounds(220, 470, 180, 50);
		backgroundPanel.add(phoneNumField);

		addressField.setBounds(220, 570, 180, 50);
		backgroundPanel.add(addressField);

		emailField.setBounds(220, 670, 180, 50);
		backgroundPanel.add(emailField);

		// 콤보박스
		comboBox.setBounds(220, 386, 116, 23);
		comboBox.setBackground(Color.white);
		backgroundPanel.add(comboBox);

		// 버튼
		signUpBtn.setBounds(170, 730, 280, 80);
		signUpBtn.setBorder(null);
		signUpBtn.setContentAreaFilled(false);

		duplicateBtn.setBounds(380, 175, 180, 60);
		duplicateBtn.setBorder(null);
		duplicateBtn.setContentAreaFilled(false);

		backgroundPanel.add(duplicateBtn);
		backgroundPanel.add(signUpBtn);

		setVisible(true);
	}

	// 회원가입 버튼
	private void addEventListener() {
		signUpBtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				// 회원가입 아이디 예외 처리
				if (idTextField.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null, "아이디를 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);

					// 비밀번호 예외 처리
				} else if (pwdTextField.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null, "패스워드를 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);

					// 폰번호 예외처리
				} else if (phoneNumField.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null, "전화번호를 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);

					// 주소 예외 처리
				} else if (addressField.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null, "주소를 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);

					// 이메일 예외 처리
				} else if (emailField.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null, "이메일을 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);

					// 중복버튼 체크
				} else if (duplicationCount == 0) {
					JOptionPane.showConfirmDialog(null, "중복체크를 해주세요", "알림", JOptionPane.DEFAULT_OPTION,
							JOptionPane.PLAIN_MESSAGE);
				} else
					try {

						// 유저네임이 같은지 체크하는 DAO
						if (!CarDAO.isUsernameExists(idTextField.getText())) {
							try {
								ReservationPersonInfoDTO dto = CarDAO.insertPerson(idTextField.getText(),
										pwdTextField.getText(), phoneNumField.getText(), addressField.getText(),
										emailField.getText(), comboBox.getSelectedItem().toString());
								JOptionPane.showConfirmDialog(null, "회원가입 완료", "알림", JOptionPane.DEFAULT_OPTION,
										JOptionPane.PLAIN_MESSAGE);
								setVisible(false);
							} catch (SQLException s) {
								s.printStackTrace();
							}

							// 아니면 중복이 뜸
						} else {
							JOptionPane.showConfirmDialog(null, "아이디가 중복입니다!", "알림", JOptionPane.DEFAULT_OPTION,
									JOptionPane.PLAIN_MESSAGE);
						}
					} catch (HeadlessException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});

		// 중복체크 버튼
		duplicateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					// 중복체크 DAO
					if (CarDAO.isUsernameExists(idTextField.getText())) {
						JOptionPane.showConfirmDialog(null, "중복된 아이디 입니다.", "알림", JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE);
						possibleLabel.setVisible(true);
						possibleLabel.setText("중복된 아이디 입니다");
						duplicateBtn.setIcon(duplicaioncheckBtnImg3);
						duplicationCount = 1;

						// 아이디 필드가 비어있을시
					} else if (idTextField.getText().isEmpty()) {
						JOptionPane.showConfirmDialog(null, "아이디를 입력해주세요", "알림", JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE);
					} else {

						// 아이디가 중복이 아닐시
						JOptionPane.showConfirmDialog(null, "사용 가능한 아이디 입니다.", "알림", JOptionPane.DEFAULT_OPTION,
								JOptionPane.PLAIN_MESSAGE);
						possibleLabel.setVisible(true);
						possibleLabel.setText("사용 가능한 아이디 입니다");
						duplicateBtn.setIcon(duplicaioncheckBtnImg2);
						duplicationCount = 1;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

}