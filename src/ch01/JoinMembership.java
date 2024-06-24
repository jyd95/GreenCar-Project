package ch01;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinMembership extends JFrame {

	// 배경 패널
	private JPanel backgroundPanel;

	// 로고
	private JLabel greeeCarLogo;

	// 레이블
	private JLabel idLabel;
	private JLabel pwdLabel;
	private JLabel licenseGradeLabel;
	private JLabel phoneNumLabel;
	private JLabel addressLabel;
	private JLabel emailLabel;

	// 텍스트 필드
	private JTextField idTextField;
	private JTextField pwdTextField;
	private JTextField LicenseField;
	private JTextField phoneNumField;
	private JTextField addressField;
	private JTextField emailField;

	// 버튼
	private JButton signUpBtn;

	// 면허 종
	String licenceLevel[] = { "1종", "2종" };

	// 콤보 박수
	private JComboBox comboBox;

	public JoinMembership() {
		initData();
		setInitLayout();
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

		// 텍스트 필드
		idTextField = new JTextField();
		pwdTextField = new JTextField();
		LicenseField = new JTextField();
		phoneNumField = new JTextField();
		addressField = new JTextField();
		emailField = new JTextField();

		// 콤보 박스
		comboBox = new JComboBox(licenceLevel);

		// 버튼
		signUpBtn = new JButton("회원가입");
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
		signUpBtn.setBounds(250, 730, 130, 80);
		backgroundPanel.add(signUpBtn);

		setVisible(true);
	}

	public static void main(String[] args) {
		new JoinMembership();
	}
}
