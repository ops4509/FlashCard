package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JLabel lbSearch;
	private JLabel lbMyCol;
	private JLabel lbPurchase;
	private JLabel lbQuiz;
	private JLabel lbMyPage;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("메인 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLbSearch());
		contentPane.add(getLbMyCol());
		contentPane.add(getLbPurchase());
		contentPane.add(getLbQuiz());
		contentPane.add(getLbMyPage());
		contentPane.add(getLblNewLabel_2());
	}
	private JLabel getLbSearch() {
		if (lbSearch == null) {
			lbSearch = new JLabel("New label");
			lbSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Mycard_01main mycard = new Mycard_01main();
					mycard.setVisible(true);
					setVisible(false);
				}
			});
			lbSearch.setIcon(new ImageIcon(MainView.class.getResource("/com/javalec/assets/Group 45.png")));
			lbSearch.setBounds(40, 160, 348, 104);
		}
		return lbSearch;
	}
	private JLabel getLbMyCol() {
		if (lbMyCol == null) {
			lbMyCol = new JLabel("New label");
			lbMyCol.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ViewCollectionMain view = new ViewCollectionMain();
					view.setVisible(true);
					setVisible(false);
				}
			});
			lbMyCol.setIcon(new ImageIcon(MainView.class.getResource("/com/javalec/assets/Group 46.png")));
			lbMyCol.setBounds(40, 290, 348, 104);
		}
		return lbMyCol;
	}
	private JLabel getLbPurchase() {
		if (lbPurchase == null) {
			lbPurchase = new JLabel("New label");
			lbPurchase.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Buy1 buy = new Buy1();
					buy.setVisible(true);
					setVisible(false);
				}
			});
			lbPurchase.setIcon(new ImageIcon(MainView.class.getResource("/com/javalec/assets/Group 47.png")));
			lbPurchase.setBounds(40, 420, 348, 104);
		}
		return lbPurchase;
	}
	private JLabel getLbQuiz() {
		if (lbQuiz == null) {
			lbQuiz = new JLabel("New label");
			lbQuiz.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					QuizSelect quiz = new QuizSelect();
					quiz.setVisible(true);
					setVisible(false);
				}
			});
			lbQuiz.setIcon(new ImageIcon(MainView.class.getResource("/com/javalec/assets/Group 48.png")));
			lbQuiz.setBounds(40, 550, 345, 104);
		}
		return lbQuiz;
	}
	private JLabel getLbMyPage() {
		if (lbMyPage == null) {
			lbMyPage = new JLabel("New label");
			lbMyPage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MypageUser mypageUser = new MypageUser();
					mypageUser.setVisible(true);
					setVisible(false);
				}
			});
			lbMyPage.setIcon(new ImageIcon(MainView.class.getResource("/com/javalec/assets/Group 49.png")));
			lbMyPage.setBounds(40, 680, 345, 104);
		}
		return lbMyPage;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(MainView.class.getResource("/com/javalec/assets/MainMycard.png")));
			lblNewLabel_2.setBounds(111, 35, 204, 97);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MainView.class.getResource("/com/javalec/assets/Ubiquity.png")));
			lblNewLabel.setBounds(5, 855, 428, 30);
		}
		return lblNewLabel;
	}
}
