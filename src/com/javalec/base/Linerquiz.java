package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Linerquiz extends JFrame {

	private JPanel contentPane;
	private JLabel lblLoginname;
	private JLabel lblHello;
	private JButton btnBack;
	private JButton btnHome;
	private JButton btnQuestion1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Linerquiz frame = new Linerquiz();
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
	public Linerquiz() {
		setTitle("선긋기게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLoginname());
		contentPane.add(getLblHello());
		contentPane.add(getBtnBack());
		contentPane.add(getBtnHome());
		contentPane.add(getBtnQuestion1());
	}
	
	

	private JLabel getLblHello() {
		if (lblHello == null) {
			lblHello = new JLabel("");
			lblHello.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/hello.png")));
			lblHello.setBounds(241, 82, 65, 34);
		}
		return lblHello;
	}

	private JLabel getLblLoginname() {
		if (lblLoginname == null) {
			lblLoginname = new JLabel("안재원님!");
			lblLoginname.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblLoginname.setBounds(311, 89, 75, 38);
		}
		return lblLoginname;
	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnHome.setBackground(new Color(0, 0, 0, 0));
			btnHome.setBorderPainted(false);
			btnHome.setFocusPainted(false);
			btnHome.setContentAreaFilled(false);
			btnHome.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/101 Logo.png")));
			btnHome.setBounds(167, 27, 101, 48);
		}
		return btnHome;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuizSelect quizSelect = new QuizSelect();
					quizSelect.setVisible(true);
					dispose();
					
				}
			});
			btnBack.setBackground(new Color(0, 0, 0, 0));
			btnBack.setBorderPainted(false);
			btnBack.setFocusPainted(false);
			btnBack.setContentAreaFilled(false);
			btnBack.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/Back.png")));
			btnBack.setBounds(48, 79, 48, 48);
		}
		return btnBack;
	}
	private JButton getBtnQuestion1() {
		if (btnQuestion1 == null) {
			btnQuestion1 = new JButton("");
			btnQuestion1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnQuestion1.setIcon(new ImageIcon(Linerquiz.class.getResource("/com/javalec/assets/smallquizzbutton.png")));
			btnQuestion1.setBounds(54, 177, 142, 58);
		}
		return btnQuestion1;
	}
}
