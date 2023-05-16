package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.javalec.dao.DaoScore_OKH;
import com.javalec.util.ShareVar;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Warningquiz extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnReset;
	Shortquiz shortquiz = new Shortquiz();
	private JButton btnOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warningquiz dialog = new Warningquiz();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Warningquiz() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("계속 풀어보시겠습니까?");
		setBounds(159, 448, 310, 230);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getBtnOK());
		getContentPane().add(getBtnReset());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(Warningquiz.class.getResource("/com/javalec/assets/red phone.png")));
			lblNewLabel.setBounds(140, 24, 30, 30);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이전에 풀던 문제가 있습니다.");
			lblNewLabel_1.setForeground(new Color(179, 38, 30));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(24, 70, 262, 32);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("계속 풀어보시겠습니까?");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(25, 115, 262, 20);
		}
		return lblNewLabel_2;
	}

	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("초기화");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Shortquiz.qseq = 0;
					Shortquiz.score =0;
					Shortquiz shortquiz = new Shortquiz();
					shortquiz.setVisible(true);
					QuizSelect quizSelect = new QuizSelect();
					quizSelect.setVisible(false);
					dispose();
				}
			});
			btnReset.setBackground(Color.WHITE);
			btnReset.setBounds(165, 150, 120, 40);
		}
		return btnReset;
	}

	private JButton getBtnOK() {
		if (btnOK == null) {
			btnOK = new JButton("네");
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Shortquiz shortquiz = new Shortquiz();
					shortquiz.setVisible(true);
					QuizSelect quizSelect = new QuizSelect();
					quizSelect.setVisible(false);
					dispose();
				}
			});
			btnOK.setBackground(Color.WHITE);
			btnOK.setBounds(25, 150, 120, 40);
		}
		return btnOK;
	}
}
