package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;

public class Mycard_04update extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mycard_04update frame = new Mycard_04update();
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
	public Mycard_04update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 906);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getBtnNewButton_1_2());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_3());
		contentPane.add(getTextField_4());
		contentPane.add(getTextField_5());
		contentPane.add(getTextField_6());
		contentPane.add(getTextField_7());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비워둘 창로고 들어가야함\\\\글씨는 하단에 붙였음.\n");
			lblNewLabel.setBounds(0, 0, 428, 70);
			lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNewLabel.setForeground(new Color(147, 32, 146));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBackground(new Color(147, 32, 146));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("_______ 님");
			lblNewLabel_1.setBounds(308, 82, 80, 20);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("뒤로가기버튼.       ");
			btnNewButton.setBounds(40, 82, 117, 20);
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("하단 메시지 위해 비우는 창 (위로 붙였음)");
			lblNewLabel_2.setBounds(0, 838, 428, 40);
			lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("확   인");
			btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
			btnNewButton_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton_1_2.setBounds(40, 768, 348, 62);
		}
		return btnNewButton_1_2;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("장르");
			textField.setBounds(40, 176, 70, 40);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setText("타이틀");
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setColumns(10);
			textField_1.setBounds(40, 126, 70, 40);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(135, 126, 253, 40);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(135, 176, 253, 40);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setText("카드의 앞면을 입력해주세요. ");
			textField_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_4.setBounds(40, 260, 348, 40);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setText("카드의 뒷면을 입력해 주세요.");
			textField_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_5.setColumns(10);
			textField_5.setBounds(40, 520, 348, 40);
		}
		return textField_5;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setBounds(40, 305, 348, 180);
			textField_6.setColumns(10);
		}
		return textField_6;
	}
	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(40, 565, 348, 180);
		}
		return textField_7;
	}
	
	
	
	
	
	
	
	
}//엔드게임.
