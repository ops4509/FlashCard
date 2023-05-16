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
	public static int score = 0;
	public static int selectedid;
	public static int qseq = 0;
	public static String firstoption;
	public static String secondoption;
	public static String thirdoption;
	public static String fourthoption;
	public static String[] options = new String[4];
	private JLabel lblNewLabel;
	private JLabel lblScore;
	private JLabel lblCount;
	private JLabel lblScore_1;

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
				System.out.println("문제시작 : qseq "+Shortquiz.qseq+"cocount"+QuizSelect.cocount+"score"+Shortquiz.score);
			}
		});
		setTitle("단답형 퀴즈");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		contentPane.add(getLblScore());
		contentPane.add(getLblCount());
		contentPane.add(getLblScore_1());
		contentPane.add(getLblNewLabel());
	}

	private JLabel getLblHello() {
		if (lblHello == null) {
			lblHello = new JLabel("");
			lblHello.setBounds(241, 82, 65, 34);
			lblHello.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/hello.png")));
		}
		return lblHello;
	}

	private JLabel getLblLoginname() {
		if (lblLoginname == null) {
			lblLoginname = new JLabel(ShareVar.u_name + "님!");
			lblLoginname.setBounds(311, 89, 75, 38);
			lblLoginname.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		}
		return lblLoginname;
	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("");
			btnHome.setBounds(167, 27, 101, 48);
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//	합치면 넣어야할것.
					MainView main = new MainView();
					main.setVisible(true);
//					init();
					dispose();
				}
			});
			btnHome.setBackground(new Color(0, 0, 0, 0));
			btnHome.setBorderPainted(false);
			btnHome.setFocusPainted(false);
			btnHome.setContentAreaFilled(false);
			btnHome.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/101 Logo.png")));
		}
		return btnHome;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.setBounds(48, 79, 48, 48);
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuizSelect quizSelect = new QuizSelect();
					quizSelect.setVisible(true);
//					init();
					dispose();

				}
			});
			btnBack.setBackground(new Color(0, 0, 0, 0));
			btnBack.setBorderPainted(false);
			btnBack.setFocusPainted(false);
			btnBack.setContentAreaFilled(false);
			btnBack.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/Back.png")));
		}
		return btnBack;
	}

	private JLabel getLblshortquizquestion() {
		if (lblshortquizquestion == null) {
			lblshortquizquestion = new JLabel("");
			lblshortquizquestion.setBounds(40, 200, 345, 146);
			lblshortquizquestion.setBackground(UIManager.getColor("Button.background"));
			lblshortquizquestion
					.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/shortquizquestion.png")));
		}
		return lblshortquizquestion;
	}

	private JLabel getLblGenre() {
		if (lblGenre == null) {
			lblGenre = new JLabel();
			lblGenre.setBounds(40, 200, 135, 60);
			lblGenre.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblGenre;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel();
			lblTitle.setBounds(170, 200, 200, 60);
			lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblTitle;
	}

	private JLabel getLblContents() {
		if (lblContents == null) {
			lblContents = new JLabel();
			lblContents.setBounds(42, 260, 345, 85);
			lblContents.setHorizontalAlignment(SwingConstants.CENTER);
			lblContents.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		}
		return lblContents;
	}

	private JButton getBtnOption1() {
		if (btnOption1 == null) {
			btnOption1 = new JButton();
			btnOption1.setBounds(40, 397, 345, 85);
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
		}
		return btnOption1;
	}

	private JButton getBtnOption2() {
		if (btnOption2 == null) {
			btnOption2 = new JButton();
			btnOption2.setBounds(40, 515, 345, 85);
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
		}
		return btnOption2;
	}

	private JButton getBtnOption3() {
		if (btnOption3 == null) {
			btnOption3 = new JButton();
			btnOption3.setBounds(40, 633, 345, 85);
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
		}
		return btnOption3;
	}

	private JButton getBtnOption4() {
		if (btnOption4 == null) {
			btnOption4 = new JButton();
			btnOption4.setBounds(40, 751, 345, 85);
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
		}
		return btnOption4;
	}

	private JLabel getLblOption1() {
		if (lblOption1 == null) {
			lblOption1 = new JLabel();
			lblOption1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblOption1.setBounds(40, 397, 345, 85);
			lblOption1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblOption1;
	}

	private JLabel getLblOption2() {
		if (lblOption2 == null) {
			lblOption2 = new JLabel();
			lblOption2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblOption2.setBounds(40, 515, 345, 85);
			lblOption2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblOption2;
	}

	private JLabel getLblOption3() {
		if (lblOption3 == null) {
			lblOption3 = new JLabel();
			lblOption3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblOption3.setBounds(40, 633, 345, 85);
			lblOption3.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblOption3;
	}

	private JLabel getLblOption4() {
		if (lblOption4 == null) {
			lblOption4 = new JLabel();
			lblOption4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblOption4.setBounds(41, 751, 345, 85);
			lblOption4.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblOption4;
	}
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(235, 150, 150, 30);
			lblNewLabel.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/scoreBox.png")));
		}
		return lblNewLabel;
	}
	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel(Integer.toString(qseq+1));
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setBounds(235, 150, 70, 30);
		}
		return lblScore;
	}
	private JLabel getLblCount() {
		if (lblCount == null) {
			DaoMake_OKH daoMake_OKH = new DaoMake_OKH(QuizSelect.selectedcoid);
			ArrayList<DtoMake_OKH> dtogenre = daoMake_OKH.getgenrecount();
			lblCount = new JLabel(Integer.toString(dtogenre.get(0).getCocount()));
			lblCount.setHorizontalAlignment(SwingConstants.CENTER);
			lblCount.setBounds(315, 150, 70, 30);
		}
		return lblCount;
	}
	private JLabel getLblScore_1() {
		if (lblScore_1 == null) {
			lblScore_1 = new JLabel("/");
			lblScore_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore_1.setBounds(280, 150, 70, 30);
		}
		return lblScore_1;
	}

	// function

	// quiz에 쓰일 배열 만들어서 가져와서 재배열하기
	public void makequiz() {
		DaoMake_OKH daoMake_OKH = new DaoMake_OKH(QuizSelect.selectedcoid);
		if (QuizSelect.selectmode == 0) {
			ArrayList<DtoMake_OKH> dtoMake_OKH = daoMake_OKH.getQuestAns();
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

			// options 배열은 맞는 hidden이 마지막 인덱스에 있습니다.
			// 랜덤으로 섞어줍니다.
		} else {
			ArrayList<DtoMake_OKH> dtoMake_OKH = daoMake_OKH.getCorrectionNote();
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

	public void setqseq() {
		lblScore.setText(Integer.toString(qseq+1)); 
	}
	



}
