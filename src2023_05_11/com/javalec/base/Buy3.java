package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;

public class Buy3 extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnDelet;
	private JButton btnBuy;
	private JLabel lblNewLabel;
	private JButton btnNewButton_2;
	private JTable innerTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy3 frame = new Buy3();
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
	public Buy3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnDelet());
		contentPane.add(getBtnBuy());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnNewButton_2());
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 132, 356, 647);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JButton getBtnDelet() {
		if (btnDelet == null) {
			btnDelet = new JButton("New button");
			btnDelet.setBounds(73, 801, 117, 29);
		}
		return btnDelet;
	}
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			btnBuy = new JButton("New button");
			btnBuy.setBounds(227, 801, 117, 29);
		}
		return btnBuy;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("_________님");
			lblNewLabel.setBounds(309, 32, 81, 16);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("New button");
			btnNewButton_2.setBounds(34, 27, 117, 29);
		}
		return btnNewButton_2;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
		}
		return innerTable;
	}
}
