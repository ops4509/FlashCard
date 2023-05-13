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

public class Defaultframeforfc extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Defaultframeforfc frame = new Defaultframeforfc();
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
	public Defaultframeforfc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 906);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
		contentPane.add(getComboBox_2());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_1_1());
		contentPane.add(getBtnNewButton_1_2());
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
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(40, 124, 80, 30);
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"전체"}));
			comboBox.setToolTipText("과목");
		}
		return comboBox;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(140, 124, 80, 30);
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"전체"}));
			comboBox_1.setToolTipText("타이틀");
		}
		return comboBox_1;
	}
	private JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setBounds(240, 124, 80, 30);
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"전체"}));
			comboBox_2.setToolTipText("콜렉션");
		}
		return comboBox_2;
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
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(40, 780, 90, 50);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("New button");
			btnNewButton_1_1.setBounds(169, 780, 90, 50);
		}
		return btnNewButton_1_1;
	}
	private JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("New button");
			btnNewButton_1_2.setBounds(298, 780, 90, 50);
		}
		return btnNewButton_1_2;
	}
}
