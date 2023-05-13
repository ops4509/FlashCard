package com.javalec.base;

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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

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
	private JTextField tfId;
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
		setTitle("My Cald 회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
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
			lblNewLabel = new JLabel("image in");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(60, 59, 135, 70);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("image in");
			lblNewLabel_2.setBounds(56, 140, 64, 64);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("image in");
			lblNewLabel_2_1.setBounds(56, 203, 64, 64);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("image in");
			lblNewLabel_2_1_1.setBounds(56, 418, 64, 64);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("image in");
			lblNewLabel_2_1_1_1.setBounds(56, 336, 64, 64);
		}
		return lblNewLabel_2_1_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_2() {
		if (lblNewLabel_2_1_1_2 == null) {
			lblNewLabel_2_1_1_2 = new JLabel("image in");
			lblNewLabel_2_1_1_2.setBounds(56, 483, 64, 64);
		}
		return lblNewLabel_2_1_1_2;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("가입취소");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setBounds(40, 805, 160, 56);
		}
		return btnNewButton;
	}
	private JButton getBttJoin() {
		if (bttJoin == null) {
			bttJoin = new JButton("가입완료");
			bttJoin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				joinAction();
				}
			});
			bttJoin.setBounds(217, 805, 160, 56);
		}
		return bttJoin;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(138, 145, 160, 50);
		}
		return tfId;
	}
	private JTextField getTfPw() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setColumns(10);
			tfPw.setBounds(138, 222, 240, 50);
		}
		return tfPw;
	}
	private JButton getBttCheck() {
		if (bttCheck == null) {
			bttCheck = new JButton("중복확인");
			bttCheck.setBounds(308, 143, 70, 50);
		}
		return bttCheck;
	}
	private JTextField getTfPwCheck() {
		if (tfPwCheck == null) {
			tfPwCheck = new JTextField();
			tfPwCheck.setColumns(10);
			tfPwCheck.setBounds(138, 278, 240, 50);
		}
		return tfPwCheck;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(138, 343, 240, 50);
		}
		return tfName;
	}
	private JTextField getTfPhone1() {
		if (tfPhone1 == null) {
			tfPhone1 = new JTextField();
			tfPhone1.setEditable(false);
			tfPhone1.setHorizontalAlignment(SwingConstants.CENTER);
			tfPhone1.setText("010");
			tfPhone1.setColumns(10);
			tfPhone1.setBounds(138, 425, 70, 50);
		}
		return tfPhone1;
	}
	private JTextField getTfPhone2() {
		if (tfPhone2 == null) {
			tfPhone2 = new JTextField();
			tfPhone2.setColumns(10);
			tfPhone2.setBounds(223, 425, 70, 50);
		}
		return tfPhone2;
	}
	private JTextField getTfPhone3() {
		if (tfPhone3 == null) {
			tfPhone3 = new JTextField();
			tfPhone3.setColumns(10);
			tfPhone3.setBounds(308, 425, 70, 50);
		}
		return tfPhone3;
	}
	private JTextField getTfEmail1() {
		if (tfEmail1 == null) {
			tfEmail1 = new JTextField();
			tfEmail1.setColumns(10);
			tfEmail1.setBounds(138, 490, 80, 50);
		}
		return tfEmail1;
	}
	private JTextField getTfEmail2() {
		if (tfEmail2 == null) {
			tfEmail2 = new JTextField();
			tfEmail2.setColumns(10);
			tfEmail2.setBounds(268, 490, 110, 50);
		}
		return tfEmail2;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("@");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(222, 490, 40, 50);
		}
		return lblNewLabel_1;
	}
	
public void joinAction() {
		
		String id;
		String ps;
		String address;
		String name;
		String phone1;
		String phone2;
		String phone3;
		String email1;
		String email2;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
		
		Date date = new Date();
		
		if(tfPw.getText().trim().equals(tfPwCheck.getText().trim())) {
			
			id = tfId.getText().trim();
			ps = tfPw.getText().trim();
			phone1 = tfPhone1.getText().trim();
			phone2 = tfPhone2.getText().trim();
			phone3 = tfPhone3.getText().trim();
			name = tfName.getText().trim();
			email1 = tfEmail1.getText().trim();
			email2 = tfEmail2.getText().trim();
			String str = formatter.format(date);
			
			Dao_yj dao_yj = new Dao_yj(id, ps, name, (email1 + "@" + email2), (phone1 + "-" + phone2 + "-" + phone3), str);
			
			JOptionPane.showMessageDialog(this,"가입을 성공했습니다.", "회원가입 성공", JOptionPane.INFORMATION_MESSAGE);
			
			dispose(); // 회원가입 성공시 회원가입 창을 닫음
			
			dao_yj.insertAction();
		}
		else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "실패", JOptionPane.INFORMATION_MESSAGE);
		}
	
	}

/*
public void doubleCheckAction() {
	
    String id;
    id = tfId.getText().trim();
    
    Dao_yj dao_yj = new Dao_yj(id);

    boolean isDuplicate = dao_yj.doubleCheckAction();
    
    if (isDuplicate) {
    	 JOptionPane.showMessageDialog(null,tfId.getText() + "는 사용 가능한 아이디입니다.", "성공", JOptionPane.INFORMATION_MESSAGE);
    	 dupToken = 1;
    } else {
    	JOptionPane.showMessageDialog(null,tfId.getText() + "는 이미 사용 중인 아이디입니다. \n다시 입력해주세", "아이디 중복", JOptionPane.ERROR_MESSAGE);
    	dupToken = 0;
    }
    */
	
	}


