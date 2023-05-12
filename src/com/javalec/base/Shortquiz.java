package com.javalec.base;

import java.awt.Color;
import java.util.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.DaoMake_OKH;
import com.javalec.dao.Daomake2_OKH;
import com.javalec.dto.DtoMake_OKH;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.SwingConstants;

public class Shortquiz extends JFrame {

	private JPanel contentPane;
	private JLabel lblLoginname;
	private JLabel lblHello;
	private JButton btnBack;
	private JButton btnHome;
	private JLabel lblshortquizquestion;
	private JLabel lblGenre;
	private JLabel lblTitle;
	private JLabel lblContents;
	private JButton btnOption1;
	private JButton btnOption2;
	private JButton btnOption3;
	private JButton btnOption4;
	private JLabel lblOption1;
	private JLabel lblOption2;
	private JLabel lblOption3;
	private JLabel lblOption4;

	public static String selectedAnswer;
	public static String selectedContent;
	public static String selectedGenre;
	public static String selectedTitle;
	public static int score =0;
	public static int selectedid;
	public static int qseq = 0;
	public static String firstoption;
	public static String secondoption;
	public static String thirdoption;
	public static String fourthoption;
	public static String[] options = new String[4];


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shortquiz frame = new Shortquiz();
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
	public Shortquiz() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				makequiz();

			}
		});
		setTitle("단답형 퀴즈");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLoginname());
		contentPane.add(getLblHello());
		contentPane.add(getBtnBack());
		contentPane.add(getBtnHome());
		contentPane.add(getLblGenre());
		contentPane.add(getLblTitle());
		contentPane.add(getLblContents());
		contentPane.add(getLblshortquizquestion());
		contentPane.add(getLblOption1());
		contentPane.add(getBtnOption1());
		contentPane.add(getLblOption2());
		contentPane.add(getBtnOption2());
		contentPane.add(getLblOption3());
		contentPane.add(getBtnOption3());
		contentPane.add(getLblOption4());
		contentPane.add(getBtnOption4());
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

	private JLabel getLblshortquizquestion() {
		if (lblshortquizquestion == null) {
			lblshortquizquestion = new JLabel("");
			lblshortquizquestion.setBackground(UIManager.getColor("Button.background"));
			lblshortquizquestion
					.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/shortquizquestion.png")));
			lblshortquizquestion.setBounds(40, 160, 345, 146);
		}
		return lblshortquizquestion;
	}

	private JLabel getLblGenre() {
		if (lblGenre == null) {
			lblGenre = new JLabel();
			lblGenre.setBounds(74, 200, 61, 16);
		}
		return lblGenre;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel();
			lblTitle.setBounds(186, 200, 61, 16);
		}
		return lblTitle;
	}

	private JLabel getLblContents() {
		if (lblContents == null) {
			lblContents = new JLabel();
			lblContents.setHorizontalAlignment(SwingConstants.CENTER);
			lblContents.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblContents.setBounds(42, 234, 345, 64);
		}
		return lblContents;
	}

	private JButton getBtnOption1() {
		if (btnOption1 == null) {
			btnOption1 = new JButton();
			btnOption1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Daomake2_OKH daoMake_OKH = new Daomake2_OKH(lblContents.getText(), lblOption1.getText());
					if (daoMake_OKH.checkAnswer() == true) {
						CheckCorrect checkCorrect = new CheckCorrect();
						checkCorrect.setVisible(true);
					} else {
						CheckIncorrect checkIncorrect = new CheckIncorrect();
						checkIncorrect.setVisible(true);
					}
				}
			});
			btnOption1.setBackground(new Color(0, 0, 0, 0));
			btnOption1.setBorderPainted(false);
			btnOption1.setFocusPainted(false);
			btnOption1.setContentAreaFilled(false);
			btnOption1.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnOption1.setBounds(40, 397, 345, 85);
		}
		return btnOption1;
	}

	private JButton getBtnOption2() {
		if (btnOption2 == null) {
			btnOption2 = new JButton();
			btnOption2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Daomake2_OKH daoMake_OKH = new Daomake2_OKH(lblContents.getText(), lblOption2.getText());
					if (daoMake_OKH.checkAnswer() == true) {
						CheckCorrect checkCorrect = new CheckCorrect();
						checkCorrect.setVisible(true);
					} else {
						CheckIncorrect checkIncorrect = new CheckIncorrect();
						checkIncorrect.setVisible(true);
					}
				}
			});
			btnOption2.setBackground(new Color(0, 0, 0, 0));
			btnOption2.setBorderPainted(false);
			btnOption2.setFocusPainted(false);
			btnOption2.setContentAreaFilled(false);
			btnOption2.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnOption2.setBounds(40, 515, 345, 85);
		}
		return btnOption2;
	}

	private JButton getBtnOption3() {
		if (btnOption3 == null) {
			btnOption3 = new JButton();
			btnOption3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Daomake2_OKH daoMake_OKH = new Daomake2_OKH(lblContents.getText(), lblOption3.getText());
					if (daoMake_OKH.checkAnswer() == true) {
						CheckCorrect checkCorrect = new CheckCorrect();
						checkCorrect.setVisible(true);
					} else {
						CheckIncorrect checkIncorrect = new CheckIncorrect();
						checkIncorrect.setVisible(true);
					}
				}
			});
			btnOption3.setBackground(new Color(0, 0, 0, 0));
			btnOption3.setBorderPainted(false);
			btnOption3.setFocusPainted(false);
			btnOption3.setContentAreaFilled(false);
			btnOption3.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnOption3.setBounds(40, 633, 345, 85);
		}
		return btnOption3;
	}

	private JButton getBtnOption4() {
		if (btnOption4 == null) {
			btnOption4 = new JButton();
			btnOption4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Daomake2_OKH daoMake_OKH = new Daomake2_OKH(lblContents.getText(), lblOption4.getText());
					if (daoMake_OKH.checkAnswer() == true) {
						CheckCorrect checkCorrect = new CheckCorrect();
						checkCorrect.setVisible(true);
					} else {
						CheckIncorrect checkIncorrect = new CheckIncorrect();
						checkIncorrect.setVisible(true);
					}
				}
			});
			btnOption4.setBackground(new Color(0, 0, 0, 0));
			btnOption4.setBorderPainted(false);
			btnOption4.setFocusPainted(false);
			btnOption4.setContentAreaFilled(false);
			btnOption4.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnOption4.setBounds(40, 751, 345, 85);
		}
		return btnOption4;
	}

	private JLabel getLblOption1() {
		if (lblOption1 == null) {
			lblOption1 = new JLabel();
			lblOption1.setHorizontalAlignment(SwingConstants.CENTER);
			lblOption1.setBounds(40, 397, 345, 85);
		}
		return lblOption1;
	}

	private JLabel getLblOption2() {
		if (lblOption2 == null) {
			lblOption2 = new JLabel();
			lblOption2.setHorizontalAlignment(SwingConstants.CENTER);
			lblOption2.setBounds(40, 515, 345, 85);
		}
		return lblOption2;
	}

	private JLabel getLblOption3() {
		if (lblOption3 == null) {
			lblOption3 = new JLabel();
			lblOption3.setHorizontalAlignment(SwingConstants.CENTER);
			lblOption3.setBounds(40, 633, 345, 85);
		}
		return lblOption3;
	}

	private JLabel getLblOption4() {
		if (lblOption4 == null) {
			lblOption4 = new JLabel();
			lblOption4.setHorizontalAlignment(SwingConstants.CENTER);
			lblOption4.setBounds(41, 751, 345, 85);
		}
		return lblOption4;
	}

	// function

	// quiz에 쓰일 배열 만들어서 가져와서 재배열하기
	public void makequiz() {
		DaoMake_OKH daoMake_OKH = new DaoMake_OKH(QuizSelect.selectedcoid);
		ArrayList<DtoMake_OKH> dtoMake_OKH = daoMake_OKH.getQuestAns();

		// 랜덤하게 content 선택

//		int randomContentIndex = (int) (Math.random() * dtoMake_OKH.size());
		// randomContentIndex 을 qseq으로 바꿔야한다.

		selectedAnswer = dtoMake_OKH.get(qseq).getManswer();
		selectedContent = dtoMake_OKH.get(qseq).getMcontents();
		selectedGenre = dtoMake_OKH.get(qseq).getMgenre();
		selectedTitle = dtoMake_OKH.get(qseq).getMtitle();
		selectedid = dtoMake_OKH.get(qseq).getMid();

		// 랜덤하게 3개의 다른 hidden 선택
		Set<Integer> selectedHiddenIndices = new HashSet<>();
		while (selectedHiddenIndices.size() < 3) {
			int randomHiddenIndex = (int) (Math.random() * dtoMake_OKH.size());
			if (randomHiddenIndex != qseq) {
				selectedHiddenIndices.add(randomHiddenIndex);
			}
		}

		// 선택된 3개의 hidden과 맞는 hidden으로 이루어진 배열 생성
		String[] options = new String[4];
		int i = 0;
		for (int hiddenIndex : selectedHiddenIndices) {
			options[i++] = dtoMake_OKH.get(hiddenIndex).getManswer();
		}
		options[i] = dtoMake_OKH.get(qseq).getManswer();

		// options 배열은 맞는 hidden이 마지막 인덱스에 있습니다.
		// 랜덤으로 섞어줍니다.
		firstoption = Arrays.asList(options).get(0);
		secondoption = Arrays.asList(options).get(1);
		thirdoption = Arrays.asList(options).get(2);
		fourthoption = Arrays.asList(options).get(3);

		lblContents.setText(selectedContent);
		lblGenre.setText(selectedGenre);
		lblTitle.setText(selectedTitle);
		lblOption1.setText(firstoption);
		lblOption2.setText(secondoption);
		lblOption3.setText(thirdoption);
		lblOption4.setText(fourthoption);

	}
	
	public void clear() {
		
		lblContents.setText("");
		lblGenre.setText("");
		lblTitle.setText("");
		lblOption1.setText("");
		lblOption2.setText("");
		lblOption3.setText("");
		lblOption4.setText("");
	}

}
