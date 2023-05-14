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

public class CheckCorrect extends JDialog {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckCorrect dialog = new CheckCorrect();
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

	public CheckCorrect() {
		setTitle("정답!");
		setBounds(59, 348, 310, 230);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getBtnNewButton());

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(140, 24, 30, 30);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel
					.setIcon(new ImageIcon(CheckCorrect.class.getResource("/com/javalec/assets/Green handphone.png")));
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("정답입니다!");
			lblNewLabel_1.setBounds(24, 70, 262, 32);
			lblNewLabel_1.setForeground(new Color(30, 179, 87));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("정답은  :\t" + Shortquiz.selectedAnswer + "\t입니다.");
			lblNewLabel_2.setBounds(24, 115, 262, 20);
		}
		return lblNewLabel_2;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("다음 문제 넘어가기");
			btnNewButton.setBounds(140, 150, 142, 40);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Shortquiz shortquiz = new Shortquiz();
					shortquiz.setVisible(false);
					insertScore();
					if (Shortquiz.qseq < QuizSelect.cocount - 1) {
						Shortquiz.qseq++;
						Shortquiz.score++;
						shortquiz.setqseq();
						shortquiz.makequiz();
						shortquiz.setVisible(true);
					} else {
						Shortquiz.score++;
						Shortquiz.qseq = 0;
//						shortquiz.setVisible(false);
						QuizResult quizResult = new QuizResult();
						quizResult.setVisible(true);

					}
					dispose();
				}
			});
			btnNewButton.setBackground(Color.WHITE);
		}
		return btnNewButton;
	}

	// function
	// insert score
	public void insertScore() {
		String inputuid = ShareVar.u_id;
		String inputcoid = QuizSelect.selectedcoid;
		int inputmid = Shortquiz.selectedid;
		DaoScore_OKH daoScore_OKH = new DaoScore_OKH(inputuid, inputcoid, inputmid);

		daoScore_OKH.insertScoreCorrect();
	}

}
