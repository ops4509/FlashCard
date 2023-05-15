package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Dao_yj;
import com.javalec.dto.Dto_yj;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class MainTutorMypage_Yj extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JTextField tfId;
	private JTextField tfName;
	private JButton bttLogout;
	private JButton bttHome;
	private JLabel lblTutor;
	private JPasswordField tfPw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTutorMypage_Yj frame = new MainTutorMypage_Yj();
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
	public MainTutorMypage_Yj() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getTetorInfo();
			}
		});
		setTitle("My Card Tutor 마이 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBoxMenuItem.disabledBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTfPw());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_1_1_1());
		contentPane.add(getTfId());
		contentPane.add(getTfName());
		contentPane.add(getBttLogout());
		contentPane.add(getBttHome());
		contentPane.add(getLblTutor());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MainTutorMypage_Yj.class.getResource("/imageMypage/myCard.png")));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(60, 60, 135, 70);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(MainTutorMypage_Yj.class.getResource("/imageMypage/id-3 3.png")));
			lblNewLabel_2.setBounds(55, 140, 64, 64);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setIcon(new ImageIcon(MainTutorMypage_Yj.class.getResource("/imageMypage/padlock 3.png")));
			lblNewLabel_2_1.setBounds(55, 203, 64, 64);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("");
			lblNewLabel_2_1_1_1.setIcon(new ImageIcon(MainTutorMypage_Yj.class.getResource("/imageMypage/user 2.png")));
			lblNewLabel_2_1_1_1.setBounds(60, 273, 64, 64);
		}
		return lblNewLabel_2_1_1_1;
	}
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setHorizontalAlignment(SwingConstants.CENTER);
			tfId.setEditable(false);
			tfId.setColumns(10);
			tfId.setBounds(135, 147, 240, 50);
			
			tfId.setBorder(new LineBorder(Color.BLACK));
		}
		return tfId;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEditable(false);
			tfName.setHorizontalAlignment(SwingConstants.CENTER);
			tfName.setColumns(10);
			tfName.setBounds(135, 280, 240, 50);
			
			tfName.setBorder(new LineBorder(Color.BLACK));
		}
		return tfName;
	}
	private JButton getBttLogout() {
		if (bttLogout == null) {
			bttLogout = new JButton("");
			bttLogout.setIcon(new ImageIcon(MainTutorMypage_Yj.class.getResource("/imageMypage/logoutButton.png")));
			bttLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 tutorLogoutAction();
				}
			});
			bttLogout.setBounds(40, 805, 160, 56);
		}
		return bttLogout;
	}
	private JButton getBttHome() {
		if (bttHome == null) {
			bttHome = new JButton("");
			bttHome.setIcon(new ImageIcon(MainTutorMypage_Yj.class.getResource("/imageMypage/home.png")));
			bttHome.setBounds(217, 805, 160, 56);
		}
		return bttHome;
	}
	
	private JLabel getLblTutor() {
		if (lblTutor == null) {
			lblTutor = new JLabel("");
			lblTutor.setBounds(251, 111, 135, 29);
		}
		return lblTutor;
	}
	
	//tutor 정보 불러오
	
	private void getTetorInfo() {
		Dao_yj dao = new Dao_yj(MainLogin_Yj.u_id);
		ArrayList<Dto_yj> dtoList = dao.getTetorInfo();
		        tfId.setText(dtoList.get(0).getU_id());
		        tfPw.setEchoChar('*');
		        tfPw.setText(dtoList.get(0).getU_pw());
		        tfName.setText(dtoList.get(0).getU_name());
		        
		        lblTutor.setText(dtoList.get(0).getU_pw() + "선생님의 My page");
		}
	
	// tutor 로그아웃
	
	private void tutorLogoutAction() {
	    String id = tfId.getText().trim();

	    Dao_yj dao_yj = new Dao_yj();

	    boolean result = dao_yj.tutorLogoutAction(id);

	    if (result) {
	        JOptionPane.showMessageDialog(this, id + "님 로그아웃 하셨습니다.", "로그아웃", JOptionPane.INFORMATION_MESSAGE);

	        MainLogin_Yj mainLogin_Yj = new MainLogin_Yj();
	        mainLogin_Yj.setVisible(true);

	        dispose();
	    }
	}
	private JPasswordField getTfPw() {
		if (tfPw == null) {
			tfPw = new JPasswordField();
			tfPw.setBounds(135, 210, 240, 50);
		}
		return tfPw;
	}
}
