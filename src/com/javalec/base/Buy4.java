package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class Buy4 extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblhello;
	private JLabel lblMainLogo;
	private JLabel lblokLogo;
	private JLabel lbltext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy4 frame = new Buy4();
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
	public Buy4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblhello());
		contentPane.add(getLblMainLogo());
		contentPane.add(getLblokLogo());
		contentPane.add(getLbltext());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(36, 139, 356, 188);
		}
		return scrollPane;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("______님");
			lblNewLabel.setBounds(331, 33, 61, 16);
		}
		return lblNewLabel;
	}

	// hello 로고
	private JLabel getLblhello() {
		if (lblhello == null) {
			lblhello = new JLabel("");
			lblhello.setBounds(265, 33, 61, 16);
		}
		return lblhello;
	}

	// 메인로고 이미지
	private JLabel getLblMainLogo() {
		if (lblMainLogo == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/MyCardMainLogo.png");
			lblMainLogo = new JLabel("");
			lblMainLogo.setBounds(132, 6, 139, 75);
			lblMainLogo.setIcon(icon);
		}
		return lblMainLogo;
	}

	// 구매 완료 이미지
	private JLabel getLblokLogo() {
		if (lblokLogo == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/ok.png");
			lblokLogo = new JLabel("");
			lblokLogo.setBounds(62, 387, 290, 113);
			lblokLogo.setIcon(icon);
		}
		return lblokLogo;
	}

	private JLabel getLbltext() {
		if (lbltext == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/text.png");
			lbltext = new JLabel("");
			lbltext.setBounds(36, 839, 356, 53);
			lbltext.setIcon(icon);
		}
		return lbltext;
	}

	// Function-----------------------------------------------------------------------------------------------------

}
