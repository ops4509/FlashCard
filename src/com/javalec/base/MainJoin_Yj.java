package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Dao_yj;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MainJoin_Yj extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblNewLabel_2_1_1_2;
	private JButton btnNewButton;
	private JButton bttJoin;
	private  JTextField tfId;
	private JTextField tfPw;
	private JButton bttCheck;
	private JTextField tfPwCheck;
	private JTextField tfName;
	private JTextField tfPhone1;
	private JTextField tfPhone2;
	private JTextField tfPhone3;
	private JTextField tfEmail1;
	private JTextField tfEmail2;
	private JLabel lblNewLabel_1;
	int dupToken = 0;
	int chkToken = 0;
	String idTemp = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJoin_Yj frame = new MainJoin_Yj();
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
	public MainJoin_Yj() {
		setBackground(SystemColor.activeCaption);
		setTitle("My Card 회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getLblNewLabel_2_1_1_1());
		contentPane.add(getLblNewLabel_2_1_1_2());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBttJoin());
		contentPane.add(getTfId());
		contentPane.add(getTfPw());
		contentPane.add(getBttCheck());
		contentPane.add(getTfPwCheck());
		contentPane.add(getTfName());
		contentPane.add(getTfPhone1());
		contentPane.add(getTfPhone2());
		contentPane.add(getTfPhone3());
		contentPane.add(getTfEmail1());
		contentPane.add(getTfEmail2());
		contentPane.add(getLblNewLabel_1());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/myCard.png")));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(60, 59, 135, 70);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/id-3 2.png")));
			lblNewLabel_2.setBounds(56, 140, 64, 64);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/padlock 2.png")));
			lblNewLabel_2_1.setBounds(56, 216, 64, 64);
		}
		return lblNewLabel_2_1;
	}

	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("");
			lblNewLabel_2_1_1.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/phone-call 1.png")));
			lblNewLabel_2_1_1.setBounds(56, 418, 64, 64);
		}
		return lblNewLabel_2_1_1;
	}

	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("");
			lblNewLabel_2_1_1_1.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/user 1.png")));
			lblNewLabel_2_1_1_1.setBounds(56, 336, 64, 64);
		}
		return lblNewLabel_2_1_1_1;
	}

	private JLabel getLblNewLabel_2_1_1_2() {
		if (lblNewLabel_2_1_1_2 == null) {
			lblNewLabel_2_1_1_2 = new JLabel("");
			lblNewLabel_2_1_1_2.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/envelope 1.png")));
			lblNewLabel_2_1_1_2.setBounds(56, 483, 64, 64);
		}
		return lblNewLabel_2_1_1_2;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/canButton.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(40, 805, 160, 56);
		}
		return btnNewButton;
	}

	private JButton getBttJoin() {
		if (bttJoin == null) {
			bttJoin = new JButton("");
			bttJoin.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/regButton.png")));
			bttJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (!idTemp.equals(tfId.getText())) {
						dupToken = 0;
					}

					if (dupToken == 1) {
						joinAction();
					} else if (dupToken == 0) {
						idChkAction();
					} else if (!tfPw.equals(tfPwCheck)) {
						pwChkAction();
					} else {
						notjoinAction();
					}
				}
			});
			bttJoin.setBounds(217, 805, 160, 56);
		}
		return bttJoin;
	}

	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField("  ID를 입력하세요. ");
			tfId.setHorizontalAlignment(SwingConstants.CENTER);
			tfId.setForeground(Color.LIGHT_GRAY);
			tfId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfId.setColumns(10);
			tfId.setBounds(138, 145, 160, 50);
			FocusListener listener = new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (tfId.getText().equals("  ID를 입력하세요. ")) {
						tfId.setText("");
						tfId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfId.setForeground(Color.BLACK);
						tfId.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (tfId.getText().equals("")) {
						tfId.setText("  ID를 입력하세요. ");
						tfId.setHorizontalAlignment(SwingConstants.CENTER);
						tfId.setForeground(Color.LIGHT_GRAY);
						tfId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
					}
				}
			};
			tfId.addFocusListener(listener);

			tfId.setBorder(new LineBorder(Color.BLACK));
		}
		return tfId;
	}

	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField("  비밀번호를 입력하세요. ");
			tfPw.setHorizontalAlignment(SwingConstants.CENTER);
			tfPw.setForeground(Color.LIGHT_GRAY);
			tfPw.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfPw.setColumns(10);
			tfPw.setBounds(137, 214, 240, 50);
			FocusListener listener = new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (tfPw.getText().equals("  비밀번호를 입력하세요. ")) {
						tfPw.setText("");
						tfPw.setForeground(Color.BLACK);
						tfPw.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfPw.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (tfPw.getText().equals("")) {
						tfPw.setText("  비밀번호를 입력하세요. ");
						tfPw.setHorizontalAlignment(SwingConstants.CENTER);
						tfPw.setForeground(Color.LIGHT_GRAY);
						tfPw.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
					}
				}
			};
			tfPw.addFocusListener(listener);

			tfPw.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPw;
	}

	private JButton getBttCheck() {
		if (bttCheck == null) {
			bttCheck = new JButton();
			bttCheck.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/chkButton.png")));
			bttCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					idTemp = tfId.getText();
					doubleCheckAction();
				}
			});

			bttCheck.setBounds(308, 140, 70, 60);
		}
		return bttCheck;
	}

	private JTextField getTfPwCheck() {
		if (tfPwCheck == null) {
			tfPwCheck = new JTextField("  비밀번호를 다시 입력하세요. ");
			tfPwCheck.setHorizontalAlignment(SwingConstants.CENTER);
			tfPwCheck.setForeground(Color.LIGHT_GRAY);
			tfPwCheck.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfPwCheck.setColumns(10);
			tfPwCheck.setBounds(137, 270, 240, 50);
			FocusListener listener = new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (tfPwCheck.getText().equals("  비밀번호를 다시 입력하세요. ")) {
						tfPwCheck.setText("");
						tfPwCheck.setForeground(Color.BLACK);
						tfPwCheck.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfPwCheck.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (tfPwCheck.getText().equals("")) {
						tfPwCheck.setText("  비밀번호를 다시 입력하세요. ");
						tfPwCheck.setForeground(Color.LIGHT_GRAY);
						tfPwCheck.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfPwCheck.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}
			};
			tfPwCheck.addFocusListener(listener);

			tfPwCheck.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPwCheck;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField("  이름를 입력하세요. ");
			tfName.setHorizontalAlignment(SwingConstants.CENTER);
			tfName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfName.setForeground(Color.LIGHT_GRAY);
			FocusListener listener = new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (tfName.getText().equals("  이름를 입력하세요. ")) {
						tfName.setText("");
						tfName.setForeground(Color.BLACK);
						tfName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfName.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (tfName.getText().equals("")) {
						tfName.setText("  이름를 입력하세요. ");
						tfName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfName.setForeground(Color.LIGHT_GRAY);
						tfName.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}
			};
			tfName.addFocusListener(listener);
			tfName.setColumns(10);
			tfName.setBounds(138, 343, 240, 50);

			tfName.setBorder(new LineBorder(Color.BLACK));
		}
		return tfName;
	}

	private JTextField getTfPhone1() {
		if (tfPhone1 == null) {
			tfPhone1 = new JTextField("010");
			tfPhone1.setForeground(Color.LIGHT_GRAY);
			tfPhone1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfPhone1.setHorizontalAlignment(SwingConstants.CENTER);

			FocusListener listener = new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (tfPhone1.getText().equals("010")) {
						tfPhone1.setText("");
						tfPhone1.setForeground(Color.BLACK);
						tfPhone1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfPhone1.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (tfPhone1.getText().equals("")) {
						tfPhone1.setText("010");
						tfPhone1.setForeground(Color.LIGHT_GRAY);
						tfPhone1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
						tfPhone1.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}
			};
			tfPhone1.addFocusListener(listener);
			tfPhone1.setColumns(10);
			tfPhone1.setBounds(138, 425, 70, 50);
			tfPhone1.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPhone1;
	}

	private JTextField getTfPhone2() {
		if (tfPhone2 == null) {
			tfPhone2 = new JTextField();
			tfPhone2.setColumns(10);
			tfPhone2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			tfPhone2.setHorizontalAlignment(SwingConstants.CENTER);
			tfPhone2.setBounds(223, 425, 70, 50);

			tfPhone2.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPhone2;
	}

	private JTextField getTfPhone3() {
		if (tfPhone3 == null) {
			tfPhone3 = new JTextField();
			tfPhone3.setColumns(10);
			tfPhone3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));	
			tfPhone3.setHorizontalAlignment(SwingConstants.CENTER);

			tfPhone3.setBounds(308, 425, 70, 50);

			tfPhone3.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPhone3;
	}

	private JTextField getTfEmail1() {
		if (tfEmail1 == null) {
			tfEmail1 = new JTextField("Emial ID");
			tfEmail1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			tfEmail1.setHorizontalAlignment(SwingConstants.CENTER);
			FocusListener listener = new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (tfEmail1.getText().equals("Emial ID")) {
						tfEmail1.setText("");
						tfEmail1.setForeground(Color.BLACK);
						tfEmail1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
						tfEmail1.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (tfEmail1.getText().equals("")) {
						tfEmail1.setText("Emial ID");
						tfEmail1.setForeground(Color.LIGHT_GRAY);
						tfEmail1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
						tfEmail1.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}
			};
			tfEmail1.addFocusListener(listener);
			tfEmail1.setForeground(Color.LIGHT_GRAY);
			tfEmail1.setColumns(10);
			tfEmail1.setBounds(138, 490, 80, 50);

			tfEmail1.setBorder(new LineBorder(Color.BLACK));
		}
		return tfEmail1;
	}

	private JTextField getTfEmail2() {
		if (tfEmail2 == null) {
			tfEmail2 = new JTextField("Email 도메인");
			tfEmail2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			tfEmail2.setHorizontalAlignment(SwingConstants.CENTER);
			FocusListener listener = new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (tfEmail2.getText().equals("Email 도메인")) {
						tfEmail2.setText("");
						tfEmail2.setForeground(Color.BLACK);
						tfEmail2.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (tfEmail2.getText().equals("")) {
						tfEmail2.setText("Email 도메인");
						tfEmail2.setForeground(Color.LIGHT_GRAY);
						tfEmail2.setHorizontalAlignment(SwingConstants.CENTER);
					}
				}
			};
			tfEmail2.addFocusListener(listener);
			tfEmail2.setForeground(Color.LIGHT_GRAY);
			tfEmail2.setColumns(10);
			tfEmail2.setBounds(268, 490, 110, 50);

			tfEmail2.setBorder(new LineBorder(Color.BLACK));
		}
		return tfEmail2;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(MainJoin_Yj.class.getResource("/com/javalec/assets/@.png")));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(226, 499, 32, 32);
		}
		return lblNewLabel_1;
	}

	// 회원가입

	public void joinAction() {

		String id;
		String pw;
		String name;
		String phone1;
		String phone2;
		String phone3;
		String email1;
		String email2;

		Date date = new Date();

		if (tfPw.getText().trim().equals(tfPwCheck.getText().trim())) {

			id = tfId.getText().trim();
			pw = tfPw.getText().trim();
			name = tfName.getText().trim();
			phone1 = tfPhone1.getText().trim();
			phone2 = tfPhone2.getText().trim();
			phone3 = tfPhone3.getText().trim();
			email1 = tfEmail1.getText().trim();
			email2 = tfEmail2.getText().trim();
			

			Dao_yj dao_yj = new Dao_yj(id, pw, name, (email1 + "@" + email2), (phone1 + "-" + phone2 + "-" + phone3));

			JOptionPane.showMessageDialog(this, "가입을 성공했습니다.", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);

			dispose(); // 회원가입 성공시 회원가입 창을 닫음

			dao_yj.insertAction();
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "실패", JOptionPane.ERROR_MESSAGE);
		}

	}

// 아이디 중복 확인

	public void doubleCheckAction() {
		String id;
		id = tfId.getText().trim();

		Dao_yj dao_yj = new Dao_yj(id);

		boolean isDuplicate = dao_yj.doubleCheckAction();

		if (isDuplicate) {
			JOptionPane.showMessageDialog(null, tfId.getText() + "는 사용 가능한 아이디입니다.", "성공",
					JOptionPane.INFORMATION_MESSAGE);
			dupToken = 1;
		} else {
			JOptionPane.showMessageDialog(null, tfId.getText() + "는 이미 사용 중인 아이디입니다. \n다시 입력해주세요.", "아이디 중복",
					JOptionPane.ERROR_MESSAGE);
			dupToken = 0;
		}

	}

	public void notjoinAction() {
		JOptionPane.showMessageDialog(null, "정보를 올바르게 입력해 주세요.", "정보 오류", JOptionPane.INFORMATION_MESSAGE);
	}

	public void idChkAction() {
		JOptionPane.showMessageDialog(null, "중복 확인을 해주세요.", "정보 오류", JOptionPane.INFORMATION_MESSAGE);
	}

	public void pwChkAction() {
		JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다.", "정보 오류", JOptionPane.INFORMATION_MESSAGE);
	}

} // end