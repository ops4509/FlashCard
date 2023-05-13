package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class QuizResult extends JFrame {

	private JPanel contentPane;
	private JLabel lblLoginname;
	private JLabel lblHello;
	private JButton btnHome;
	private JButton btnBack;
	private JLabel lblBackUpper;
	private JLabel lblBackLower;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblReview;
	private JButton btnRetry;
	private JButton btnHome2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizResult frame = new QuizResult();
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
	public QuizResult() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				scoreReview();
			}
		});
		setTitle("퀴즈 결과");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLoginname());
		contentPane.add(getLblHello());
		contentPane.add(getBtnHome());
		contentPane.add(getBtnBack());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblBackUpper());
		contentPane.add(getLblReview());
		contentPane.add(getLblBackLower());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblNewLabel_3_1());
		contentPane.add(getBtnRetry());
		contentPane.add(getBtnHome2());
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
			lblLoginname = new JLabel(ShareVar.u_name + "님!");
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

	private JLabel getLblBackUpper() {
		if (lblBackUpper == null) {
			lblBackUpper = new JLabel("");
			lblBackUpper
					.setIcon(new ImageIcon(QuizResult.class.getResource("/com/javalec/assets/shortquizquestion.png")));
			lblBackUpper.setBounds(40, 160, 350, 140);
		}
		return lblBackUpper;
	}

	private JLabel getLblBackLower() {
		if (lblBackLower == null) {
			lblBackLower = new JLabel("");
			lblBackLower
					.setIcon(new ImageIcon(QuizResult.class.getResource("/com/javalec/assets/shortquizquestion.png")));
			lblBackLower.setBounds(40, 340, 350, 140);
		}
		return lblBackLower;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("정답 확인");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(40, 160, 350, 70);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel(Integer.toString(Shortquiz.score)  +" / "+Integer.toString(QuizSelect.cocount) );
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(40, 230, 350, 70);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblReview() {
		if (lblReview == null) {
			lblReview = new JLabel("노력하세요");
			lblReview.setFont(new Font("Lucida Grande", Font.BOLD, 25));
			lblReview.setHorizontalAlignment(SwingConstants.CENTER);
			lblReview.setBounds(40, 377, 350, 70);
		}
		return lblReview;
	}

	private JButton getBtnRetry() {
		if (btnRetry == null) {
			btnRetry = new JButton("");
			btnRetry.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuizSelect quizSelect = new QuizSelect();
					quizSelect.setVisible(true);
					dispose();

				}
			});
			btnRetry.setIcon(new ImageIcon(QuizResult.class.getResource("/com/javalec/assets/bigbutton.png")));
			btnRetry.setBorderPainted(false);
			btnRetry.setFocusPainted(false);
			btnRetry.setContentAreaFilled(false);
			btnRetry.setBounds(40, 540, 350, 155);
		}
		return btnRetry;
	}

	private JButton getBtnHome2() {
		if (btnHome2 == null) {
			btnHome2 = new JButton("");
			btnHome2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			btnHome2.setIcon(new ImageIcon(QuizResult.class.getResource("/com/javalec/assets/bigbutton.png")));
			btnHome2.setBorderPainted(false);
			btnHome2.setFocusPainted(false);
			btnHome2.setContentAreaFilled(false);
			btnHome2.setBounds(40, 720, 350, 155);
		}
		return btnHome2;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("다시 풀어보기");
			lblNewLabel_3.setForeground(Color.BLACK);
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 41));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(40, 540, 350, 155);
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("메인으로 돌아가기");
			lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3_1.setForeground(Color.BLACK);
			lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.BOLD, 33));
			lblNewLabel_3_1.setBounds(40, 720, 350, 155);
		}
		return lblNewLabel_3_1;
	}

	// function

	//  score review 불러오기
	private void scoreReview() {
		int scorepercent = Shortquiz.score * 100 / QuizSelect.cocount;
		switch(scorepercent / 10) {
		    case 10:
		    	lblReview.setText("만점입니다.");
		    	break;
		    case 9:
		    	lblReview.setText("훌룡합니다.");
		        break;
		    case 8:
		    	lblReview.setText("잘했습니다.");
		        break;
		    case 7:
		    	lblReview.setText("아깝습니다.");
		        break;
		    default:
		    	lblReview.setText("공부하세요.");
		        break;
		}
		
	}

}
