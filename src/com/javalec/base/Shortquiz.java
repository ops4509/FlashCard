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
	private JButton btnAnswer1;
	private JButton btnAnswer2;
	private JButton btnAnswer3;
	private JButton btnAnswer4;

	private String selectedContent;
	private String selectedGenre;
	private String selectedTitle;
	private String[] options = new String[4];
	private int randomContentIndex;

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
		contentPane.add(getBtnAnswer1());
		contentPane.add(getBtnAnswer2());
		contentPane.add(getBtnAnswer3());
		contentPane.add(getBtnAnswer4());
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
			lblGenre = new JLabel(getSelectedgenre());
			lblGenre.setBounds(74, 200, 61, 16);
		}
		return lblGenre;
	}

	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel(getSelectedTitle());
			lblTitle.setBounds(186, 200, 61, 16);
		}
		return lblTitle;
	}

	private JLabel getLblContents() {
		if (lblContents == null) {
			lblContents = new JLabel(getSelectedContents());
			lblContents.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblContents.setBounds(156, 234, 61, 16);
		}
		return lblContents;
	}

	private JButton getBtnAnswer1() {
		if (btnAnswer1 == null) {
			btnAnswer1 = new JButton(getfirstblank());
			System.out.println(getfirstblank()+1234);
			System.out.println();
			btnAnswer1.setBackground(new Color(0, 0, 0, 0));
			btnAnswer1.setBorderPainted(false);
			btnAnswer1.setFocusPainted(false);
			btnAnswer1.setContentAreaFilled(false);
			btnAnswer1.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnAnswer1.setBounds(40, 397, 345, 85);
		}
		return btnAnswer1;
	}

	private JButton getBtnAnswer2() {
		if (btnAnswer2 == null) {
			btnAnswer2 = new JButton(getsecondblank());
			btnAnswer2.setBackground(new Color(0, 0, 0, 0));
			btnAnswer2.setBorderPainted(false);
			btnAnswer2.setFocusPainted(false);
			btnAnswer2.setContentAreaFilled(false);
			btnAnswer2.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnAnswer2.setBounds(40, 515, 345, 85);
		}
		return btnAnswer2;
	}

	private JButton getBtnAnswer3() {
		if (btnAnswer3 == null) {
			btnAnswer3 = new JButton(getthirdblank());
			btnAnswer3.setBackground(new Color(0, 0, 0, 0));
			btnAnswer3.setBorderPainted(false);
			btnAnswer3.setFocusPainted(false);
			btnAnswer3.setContentAreaFilled(false);
			btnAnswer3.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnAnswer3.setBounds(40, 633, 345, 85);
		}
		return btnAnswer3;
	}

	private JButton getBtnAnswer4() {
		if (btnAnswer4 == null) {
			btnAnswer4 = new JButton(getfourthblank());
			btnAnswer4.setBackground(new Color(0, 0, 0, 0));
			btnAnswer4.setBorderPainted(false);
			btnAnswer4.setFocusPainted(false);
			btnAnswer4.setContentAreaFilled(false);
			btnAnswer4.setIcon(new ImageIcon(Shortquiz.class.getResource("/com/javalec/assets/Basic dialog.png")));
			btnAnswer4.setBounds(40, 751, 345, 85);
		}
		return btnAnswer4;
	}

	// function

	// quiz에 쓰일 배열 만들어서 가져와서 재배열하기
	public void makequiz() {
		DaoMake_OKH daoMake_OKH = new DaoMake_OKH(QuizSelect.selectedcoid);
		ArrayList<DtoMake_OKH> dtoMake_OKH = daoMake_OKH.getQuestAns();

		// 랜덤하게 content 선택

		int randomContentIndex = (int) (Math.random() * dtoMake_OKH.size());

		selectedContent = dtoMake_OKH.get(randomContentIndex).getMcontents();
		selectedGenre = dtoMake_OKH.get(randomContentIndex).getMgenre();
		selectedTitle = dtoMake_OKH.get(randomContentIndex).getMtitle();

		// 랜덤하게 3개의 다른 hidden 선택
		Set<Integer> selectedHiddenIndices = new HashSet<>();
		while (selectedHiddenIndices.size() < 3) {
			int randomHiddenIndex = (int) (Math.random() * dtoMake_OKH.size());
			if (randomHiddenIndex != randomContentIndex) {
				selectedHiddenIndices.add(randomHiddenIndex);
			}
		}

		// 선택된 3개의 hidden과 맞는 hidden으로 이루어진 배열 생성
		String[] options = new String[4];
		int i = 0;
		for (int hiddenIndex : selectedHiddenIndices) {
			options[i++] = dtoMake_OKH.get(hiddenIndex).getManswer();
		}
		options[i] = dtoMake_OKH.get(randomContentIndex).getManswer();

		// options 배열은 맞는 hidden이 마지막 인덱스에 있습니다.
		// 랜덤으로 섞어줍니다.
		Collections.shuffle(Arrays.asList(options));
		System.out.println(Arrays.asList(options));

	}

	// quiz의 content 부르기.
	public String getSelectedContents() {
		makequiz();
		return selectedContent;
	}

	public String getSelectedgenre() {
		makequiz();
		return selectedGenre;
	}

	public String getSelectedTitle() {
		makequiz();
		return selectedTitle;
	}

	public String getfirstblank() {
		makequiz();
		System.out.println(Arrays.asList(options).get(0)+1234321);
		return Arrays.asList(options).get(0);
	}

	public String getsecondblank() {
		makequiz();
		return Arrays.asList(options).get(1);
	}

	public String getthirdblank() {
		makequiz();
		return Arrays.asList(options).get(2);
	}

	public String getfourthblank() {
		makequiz();
		return Arrays.asList(options).get(3);
	}

}
