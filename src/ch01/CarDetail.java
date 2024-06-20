package ch01;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarDetail extends JFrame {

	JPanel backgroundPanel = new JPanel();

	// 라벨
	private JLabel k3;
	private JLabel k5;
	private JLabel model3;
	private JLabel nexo;
	private JLabel staria;
	private JLabel sonata;
	private JLabel avante;
	private JLabel kanibal;

	// 라벨 이미지 크기
	private int xLabel = 60;
	private int yLabel = 230;
	private int widthLabel = 200;
	private int heightLabel = 200;

	// 새 창 프레임
	public CarDetail() {
		setBounds(0, 0, 800, 800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setInitLayout();
		setLocationRelativeTo(null);

	}

	// backgroundPanel
	public void setInitLayout() {
		backgroundPanel.setSize(getWidth(), getHeight());
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLayout(null);
		add(backgroundPanel);
	}

	// 새 창에 뜨는 이미지
	public void DetailK3() {
		k3 = new JLabel(new ImageIcon("img/k3.png"));
		k3.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		k3.setLayout(null);
		backgroundPanel.add(k3);
		setVisible(true);

	}

	public void DetailK5() {
		k5 = new JLabel(new ImageIcon("img/k5.png"));
		k5.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		k5.setLayout(null);
		backgroundPanel.add(k5);
		setVisible(true);

	}

	public void DetailModel3() {
		model3 = new JLabel(new ImageIcon("img/MODEL3.png"));
		model3.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		model3.setLayout(null);
		backgroundPanel.add(model3);
		setVisible(true);

	}

	public void DetailNexo() {
		nexo = new JLabel(new ImageIcon("img/넥쏘.png"));
		nexo.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		nexo.setLayout(null);
		backgroundPanel.add(nexo);
		setVisible(true);

	}

	public void DetailStaria() {
		staria = new JLabel(new ImageIcon("img/스타리아.png"));
		staria.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		staria.setLayout(null);
		backgroundPanel.add(staria);
		setVisible(true);

	}

	public void DetailSonata() {
		sonata = new JLabel(new ImageIcon("img/쏘나타2.png"));
		sonata.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		sonata.setLayout(null);
		backgroundPanel.add(sonata);
		setVisible(true);

	}

	public void DetailAvante() {
		avante = new JLabel(new ImageIcon("img/아반떼.png"));
		avante.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		avante.setLayout(null);
		backgroundPanel.add(avante);
		setVisible(true);

	}

	public void DetailKanibal() {
		kanibal = new JLabel(new ImageIcon("img/카니발2.png"));
		kanibal.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		kanibal.setLayout(null);
		backgroundPanel.add(kanibal);
		setVisible(true);

	}

	private class BackgroundPanel extends JPanel {
		private JPanel backgroundPanel;

		public BackgroundPanel() {
			backgroundPanel = new JPanel();
		}
	}

}
