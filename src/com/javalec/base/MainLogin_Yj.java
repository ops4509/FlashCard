package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Dao_yj;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;


public class MainLogin_Yj extends JFrame {

	private JPanel contentPane;
	private JCheckBox chTutor;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JButton btnLogin;
	private JButton btnJoin;
	private JTextField tfId;
	private JPasswordField tfPassword;
	private JTextField tfId2;
	private JPasswordField tfPassword1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLogin_Yj frame = new MainLogin_Yj();
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
	public MainLogin_Yj() {
		setTitle("My Cald 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getChTutor());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getBtnLogin());
		contentPane.add(getBtnJoin());
		contentPane.add(getTfId2());
		contentPane.add(getTfPassword1());
		
	
	        
	}
	private JCheckBox getChTutor() {
		if (chTutor == null) {
			chTutor = new JCheckBox("");
			chTutor.setBounds(346, 56, 30, 30);
		}
		return chTutor;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Tutor");
			lblNewLabel.setBounds(311, 64, 34, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("image in");
			lblNewLabel_1.setBounds(60, 173, 310, 280);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("image in");
			lblNewLabel_1_1.setBounds(40, 473, 347, 158);
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("image in");
			lblNewLabel_2.setBounds(55, 640, 64, 64);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("image in");
			lblNewLabel_2_1.setBounds(55, 715, 64, 64);
		}
		return lblNewLabel_2_1;
	}
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("로그인");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LoginAction();
				}
			});
			btnLogin.setBounds(53, 799, 160, 56);
		}
		return btnLogin;
	}
	private JButton getBtnJoin() {
		if (btnJoin == null) {
			btnJoin = new JButton("회원가입");
			btnJoin.setBounds(226, 799, 160, 56);
		}
		return btnJoin;
	}
	
	private JTextField getTfId2() {
		if (tfId2 == null) {
			tfId2 = new JTextField();
			tfId2.setBounds(133, 647, 240, 50);
			tfId2.setColumns(10);
        }
		
        return tfId2;
	}
	
	private JPasswordField getTfPassword1() {
		if (tfPassword1 == null) {
			tfPassword1 = new JPasswordField();
			tfPassword1.setBounds(133, 729, 240, 50);
		}
		return tfPassword1;
	}
	
	// ----------- Functions
	
	public void LoginAction() {
		
		// 관리자 로그인
		
		
		if(chTutor.isSelected()) {
			
			String id;
			String ps = "";
			char b[] = tfPassword1.getPassword();
			
			
			for(int i = 0; i < b.length; i++) {
				ps = ps + b[i];
			}
			id = tfId2.getText().trim();
		
			
			Dao_yj dao_yj = new Dao_yj(id, ps);
			
		
		
			boolean result = dao_yj.tutorAction();
			
			if(result) {
				JOptionPane.showMessageDialog(this, tfId2.getText() + "관리자님 환영합니다.", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호를 잘못 입력했습니다. \n입력하신 내용을 확인 후 다시 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
			}
			
			
		
			
		}
		
		
		// 일반 로그인
		

		String id;
		String ps = "";
		char[] b = tfPassword1.getPassword();
		
		for(int i = 0; i < b.length; i++) {
			ps = ps + b[i];
		}
		id = tfId2.getText().trim();

	
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
		
		Date date = new Date();
		
		String str = formatter.format(date);
		Dao_yj dao_yj = new Dao_yj(id, ps, str);
		
		boolean result = dao_yj.loginAction();

		
		if(result) {
			
			
			JOptionPane.showMessageDialog(this, tfId2.getText() + "님 환영합니", "로그인 성공", JOptionPane.INFORMATION_MESSAGE);
			
			MainView view = new MainView();
			
			view.setVisible(true);
			
			setVisible(false); // 로그인 성공시 로그인창을 닫는다. //(코멘트) 로그인 데이터 값을 입력받기 위해 dispose대신 setVisible 사용.

		}else {
			JOptionPane.showMessageDialog(this,  "아이디 또는 비밀번호를 잘못 입력했습니다. \n입력하신 내용을 확인 후 다시 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
		}

		
		dao_yj.loginAction();
		
	}
	
	
			
	
} // End