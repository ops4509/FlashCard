package com.javalec.base;

import java.awt.EventQueue;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.text.StyledDocument;

import com.javalec.dao.ViewCollectionCardsDao_KMJ;
import com.javalec.dao.ViewCollectionMainDao_KMJ;
import com.javalec.dto.ViewCollectionCardsDto_KMJ;
import com.javalec.dto.ViewCollectionMainDto_KMJ;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JSplitPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;

public class ViewCollectionCards extends JFrame {

	private JPanel contentPane;
	private JLabel lbMc;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lbCard;
	private JLabel lbTxt;
	private JLabel lbLeft;
	private JLabel lblNewLabel_4_1;
	private JLabel lbRight;
	int index = 0;
	int maxIndex = 0;
	int token = 0;
	int rToken = 0;
	private JLabel lbShuffle;
	int randIndex = 0;

	// private ImageIcon icon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCollectionCards frame = new ViewCollectionCards();
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

	public ViewCollectionCards() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lbLeft.setVisible(false);
				if (ViewCollectionMain.payStatus == 0) {
					freeSearch();
				} else {
					paySearch();
				}
			}
		});
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbTxt());

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 428, 20);
		contentPane.add(panel);
		contentPane.add(getLbMc());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLbCard());
		contentPane.add(getLbLeft());
		contentPane.add(getLblNewLabel_4_1());
		contentPane.add(getLbRight());
		contentPane.add(getLbShuffle());
	}

	private JLabel getLbMc() {
		if (lbMc == null) {
			lbMc = new JLabel("");
			lbMc.setIcon(new ImageIcon(ViewCollectionMain.class.getResource("/com/javalec/assets/101 Logo.png")));
			lbMc.setBounds(167, 27, 101, 48);
		}
		return lbMc;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ViewCollectionMain main = new ViewCollectionMain();
					main.setVisible(true);
					dispose();

				}
			});
			lblNewLabel.setIcon(new ImageIcon(ViewCollectionMain.class.getResource("/com/javalec/assets/Back.png")));
			lblNewLabel.setBounds(48, 79, 48, 48);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("님!");
			lblNewLabel_1.setFont(new Font("LG Smart UI Bold", Font.PLAIN, 16));
			lblNewLabel_1.setIcon(new ImageIcon(ViewCollectionMain.class.getResource("/com/javalec/assets/hello.png")));
			lblNewLabel_1.setBounds(268, 79, 145, 48);
		}
		return lblNewLabel_1;
	}

	private JLabel getLbCard() {
		if (lbCard == null) {
			lbCard = new JLabel("");
			lbCard.setIcon(
					new ImageIcon(ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 22.png")));
			lbCard.setBackground(new Color(255, 255, 255));
			lbCard.setBounds(40, 155, 348, 450);
		}
		return lbCard;
	}

	private JLabel getLbTxt() {
		if (lbTxt == null) {
			lbTxt = new JLabel("Loading...");
			lbTxt.setFont(new Font("LG Smart UI Bold", Font.PLAIN, 60));
			lbTxt.setHorizontalAlignment(SwingConstants.CENTER);
			lbTxt.setBounds(48, 344, 333, 65);
		}
		return lbTxt;
	}

	private JLabel getLbLeft() {
		if (lbLeft == null) {
			lbLeft = new JLabel("");
			lbLeft.setIcon(
					new ImageIcon(ViewCollectionCards.class.getResource("/com/javalec/assets/skip_previous.png")));
			lbLeft.setBounds(60, 711, 64, 64);
		}
		return lbLeft;
	}

	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("");
			lblNewLabel_4_1.setBounds(80, 691, 64, 64);
		}
		return lblNewLabel_4_1;
	}

	private JLabel getLbRight() {
		if (lbRight == null) {
			lbRight = new JLabel("");
			lbRight.setIcon(new ImageIcon(ViewCollectionCards.class.getResource("/com/javalec/assets/skip_next.png")));
			lbRight.setBounds(298, 711, 64, 64);
		}
		return lbRight;
	}

	// function
	private void freeSearch() {

		ViewCollectionCardsDao_KMJ dao = new ViewCollectionCardsDao_KMJ();

		ArrayList<ViewCollectionCardsDto_KMJ> dto = dao.userCard();

		int randNum[] = new int[dto.size()];
		Random rand = new Random();

		maxIndex = dto.size();
		// 초기값 설정
		lbTxt.setText(dto.get(index).getCcontents());

		// 오른쪽 버튼 클릭시 index증가, 카드가 맨마지막일 경우 버튼 비활성화, 첫번째 카드에서 클릭시 왼쪽버튼 활성화
		lbRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rToken == 0) {
					if (index < maxIndex - 1) {
						lbLeft.setVisible(true);
						index++;
						lbTxt.setText(dto.get(index).getCcontents());
					}
					if (index == maxIndex - 1) {
						lbRight.setVisible(false);
					}
				} else if (rToken == 1) {
					if (randIndex < maxIndex - 1) {
						lbLeft.setVisible(true);
						randIndex++;
						lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
					}
					if (randIndex == maxIndex - 1) {
						lbRight.setVisible(false);
					}
				}
			}
		});

		// 왼쪽 클릭시 index줄이기, 카드가 맨처음일 경우 버튼 비활성화, 마지막 카드에서 클릭시 오른쪽버튼 활성화
		lbLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rToken == 0) {
					if (index >= 0) {
						lbRight.setVisible(true);
						index--;
						lbTxt.setText(dto.get(index).getCcontents());
					}
					if (index == 0) {
						lbLeft.setVisible(false);
					}
				} else if (rToken == 1) {
					if (randIndex >= 0) {
						lbRight.setVisible(true);
						randIndex--;
						lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
					}
					if (randIndex == 0) {
						lbLeft.setVisible(false);
					}
				}

			}
		});

		// 카드 뒤집기 구현
		lbCard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (rToken == 0) {
					if (token == 1) {
						token = 0;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 22.png")));
						lbTxt.setText(dto.get(index).getCcontents());
					} else if (token == 0) {
						token = 1;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 21.png")));
						lbTxt.setText(dto.get(index).getCanswer());
					}
				} else if (rToken == 1) {
					if (token == 1) {
						token = 0;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 22.png")));
						lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
					} else if (token == 0) {
						token = 1;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 21.png")));
						lbTxt.setText(dto.get(randNum[randIndex]).getCanswer());
					}
				}
			}
		});

		// 카드섞기 버튼
		lbShuffle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = 0;
				randIndex = 0;
				lbLeft.setVisible(false);
				lbRight.setVisible(true);
				rToken = 1;

				for (int i = 0; i < randNum.length; i++) {
					randNum[i] = rand.nextInt(dto.size());
					for (int j = 0; j < i; j++) {
						if (randNum[i] == randNum[j]) {
							i--;
						}
					}
				}
				// 카드섞기 애니메이션 구현
				ActionListener taskPerformer = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								// 카드 섞는동안 카드 뒤집기 비활성화
								lbCard.setOpaque(false);

								lbTxt.setText(dto.get(randIndex++).getCcontents());
								if (randIndex == dto.size() - 1) {
									randIndex = 0;
									lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
									((Timer) evt.getSource()).stop();
								}
							}
						});
					}
				};
				new Timer(50, taskPerformer).start();

				// 다시 활성화
				lbCard.setOpaque(true);

			}
		});

	}

	//
	private void paySearch() {

		ViewCollectionCardsDao_KMJ dao = new ViewCollectionCardsDao_KMJ();

		ArrayList<ViewCollectionCardsDto_KMJ> dto = dao.payCard();

		int randNum[] = new int[dto.size()];
		Random rand = new Random();

		maxIndex = dto.size();

		// 초기값 설정
		lbTxt.setText(dto.get(index).getCcontents());

		// 오른쪽 버튼 클릭시 index증가, 카드가 맨마지막일 경우 버튼 비활성화, 첫번째 카드에서 클릭시 왼쪽버튼 활성화
		lbRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rToken == 0) {
					if (index < maxIndex - 1) {
						lbLeft.setVisible(true);
						index++;
						lbTxt.setText(dto.get(index).getCcontents());
					}
					if (index == maxIndex - 1) {
						lbRight.setVisible(false);
					}
				} else if (rToken == 1) {
					if (randIndex < maxIndex - 1) {
						lbLeft.setVisible(true);
						randIndex++;
						lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
					}
					if (randIndex == maxIndex - 1) {
						lbRight.setVisible(false);
					}
				}
			}
		});

		// 왼쪽 클릭시 index줄이기, 카드가 맨처음일 경우 버튼 비활성화, 마지막 카드에서 클릭시 오른쪽버튼 활성화
		lbLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rToken == 0) {
					if (index >= 0) {
						lbRight.setVisible(true);
						index--;
						lbTxt.setText(dto.get(index).getCcontents());
					}
					if (index == 0) {
						lbLeft.setVisible(false);
					}
				} else if (rToken == 1) {
					if (randIndex >= 0) {
						lbRight.setVisible(true);
						randIndex--;
						lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
					}
					if (randIndex == 0) {
						lbLeft.setVisible(false);
					}
				}

			}
		});

		// 카드 뒤집기 구현
		lbCard.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (rToken == 0) {
					if (token == 1) {
						token = 0;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 22.png")));
						lbTxt.setText(dto.get(index).getCcontents());
					} else if (token == 0) {
						token = 1;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 21.png")));
						lbTxt.setText(dto.get(index).getCanswer());
					}
				} else if (rToken == 1) {
					if (token == 1) {
						token = 0;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 22.png")));
						lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
					} else if (token == 0) {
						token = 1;
						lbCard.setIcon(new ImageIcon(
								ViewCollectionCards.class.getResource("/com/javalec/assets/Rectangle 21.png")));
						lbTxt.setText(dto.get(randNum[randIndex]).getCanswer());
					}
				}
			}
		});

		// 카드섞기 버튼
		lbShuffle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = 0;
				randIndex = 0;
				lbLeft.setVisible(false);
				lbRight.setVisible(true);
				rToken = 1;

				for (int i = 0; i < randNum.length; i++) {
					randNum[i] = rand.nextInt(dto.size());
					for (int j = 0; j < i; j++) {
						if (randNum[i] == randNum[j]) {
							i--;
						}
					}
				}
				// 카드섞기 애니메이션 구현
				ActionListener taskPerformer = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								// 카드 섞는동안 카드 뒤집기 비활성화
								lbCard.setOpaque(false);

								lbTxt.setText(dto.get(randIndex++).getCcontents());
								if (randIndex == dto.size() - 1) {
									randIndex = 0;
									lbTxt.setText(dto.get(randNum[randIndex]).getCcontents());
									((Timer) evt.getSource()).stop();
								}
							}
						});
					}
				};
				new Timer(50, taskPerformer).start();

				// 다시 활성화
				lbCard.setOpaque(true);

			}
		});
	}

	private JLabel getLbShuffle() {
		if (lbShuffle == null) {
			lbShuffle = new JLabel("");
			lbShuffle.setIcon(new ImageIcon(ViewCollectionCards.class.getResource("/com/javalec/assets/shuffled.png")));
			lbShuffle.setBounds(170, 706, 74, 74);
		}
		return lbShuffle;
	}
}
