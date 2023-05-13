package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMypage_Yj extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblNewLabel_2_1_1_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMypage_Yj frame = new MainMypage_Yj();
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
	public MainMypage_Yj() {
		setTitle("My Cald 마이 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getLblNewLabel_2_1_1_1());
		contentPane.add(getLblNewLabel_2_1_1_2());
		contentPane.add(getTextField_4());
		contentPane.add(getTextField_5());
		contentPane.add(getTextField_6());
		contentPane.add(getTextField_7());
		contentPane.add(getTextField_8());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_1_1());
		contentPane.add(getTextField_2_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getTextField_3_1());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_1_1());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("image in");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(240, 53, 135, 70);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("image in");
			lblNewLabel_2.setBounds(55, 140, 64, 64);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("image in");
			lblNewLabel_2_1.setBounds(55, 203, 64, 64);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("image in");
			lblNewLabel_2_1_1.setBounds(55, 343, 64, 64);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("image in");
			lblNewLabel_2_1_1_1.setBounds(55, 273, 64, 64);
		}
		return lblNewLabel_2_1_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_2() {
		if (lblNewLabel_2_1_1_2 == null) {
			lblNewLabel_2_1_1_2 = new JLabel("image in");
			lblNewLabel_2_1_1_2.setBounds(55, 413, 64, 64);
		}
		return lblNewLabel_2_1_1_2;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(135, 350, 70, 50);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(220, 350, 70, 50);
		}
		return textField_5;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(305, 350, 70, 50);
		}
		return textField_6;
	}
	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(136, 420, 70, 50);
		}
		return textField_7;
	}
	private JTextField getTextField_8() {
		if (textField_8 == null) {
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(262, 420, 110, 50);
		}
		return textField_8;
	}
	private JTextField getTextField_2() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(135, 147, 240, 50);
		}
		return textField;
	}
	private JTextField getTextField_1_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(135, 210, 240, 50);
		}
		return textField_1;
	}
	private JTextField getTextField_2_1() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(135, 280, 240, 50);
		}
		return textField_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("총 결제금액");
			btnNewButton.setBounds(45, 515, 110, 56);
		}
		return btnNewButton;
	}
	private JTextField getTextField_3_1() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(185, 515, 188, 50);
		}
		return textField_3;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("로그 아웃");
			btnNewButton_1.setBounds(40, 805, 160, 56);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("변경 완료");
			btnNewButton_1_1.setBounds(217, 805, 160, 56);
		}
		return btnNewButton_1_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainView main = new MainView();
					main.setVisible(true);
					dispose();
				}
			});
			lblNewLabel_1.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/com/javalec/assets/Back.png")));
			lblNewLabel_1.setBounds(55, 75, 48, 48);
		}
		return lblNewLabel_1;
	}
}
