
package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Dao_yj;
import com.javalec.dto.Dto_yj;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class MainMypage_Yj extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblNewLabel_2_1_1_2;
	private JTextField tfPhon1;
	private JTextField tfEmail1;
	private JTextField tfPhon3;
	private JTextField tfPhon2;
	private JTextField tfEmail2;
	private JTextField tfId;
	private JTextField tfPw;
	private JTextField tfName;
	private JButton btnPayment;
	private JTextField tfPayment;
	private JButton bttLogout;
	private JButton bttUpdate;
	int dupToken = 0;
	private JLabel lblNewLabel_1;
	private JLabel lbluser;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMypage_Yj frame = new MainMypage_Yj();
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
	public MainMypage_Yj() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				getUserInfo();
				
			}
		});
		setTitle("My Card 마이 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBoxMenuItem.disabledBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_2_1());
		contentPane.add(getLblNewLabel_2_1_1());
		contentPane.add(getLblNewLabel_2_1_1_1());
		contentPane.add(getLblNewLabel_2_1_1_2());
		contentPane.add(getTfPhon1());
		contentPane.add(getTfEmail1());
		contentPane.add(getTfPhon3());
		contentPane.add(getTfPhon2());
		contentPane.add(getTfEmail2());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_1_1());
		contentPane.add(getTextField_2_1());
		contentPane.add(getBtnPayment());
		contentPane.add(getTextField_3_1());
		contentPane.add(getBttLogout());
		contentPane.add(getBttUpdate());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLbluser());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/myCard.png")));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(60, 59, 135, 70);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/id-3 3.png")));
			lblNewLabel_2.setBounds(55, 140, 64, 64);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/padlock 3.png")));
			lblNewLabel_2_1.setBounds(55, 203, 64, 64);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("");
			lblNewLabel_2_1_1.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/phone-call 2.png")));
			lblNewLabel_2_1_1.setBounds(55, 343, 64, 64);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_1() {
		if (lblNewLabel_2_1_1_1 == null) {
			lblNewLabel_2_1_1_1 = new JLabel("");
			lblNewLabel_2_1_1_1.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/user 2.png")));
			lblNewLabel_2_1_1_1.setBounds(55, 273, 64, 64);
		}
		return lblNewLabel_2_1_1_1;
	}
	private JLabel getLblNewLabel_2_1_1_2() {
		if (lblNewLabel_2_1_1_2 == null) {
			lblNewLabel_2_1_1_2 = new JLabel("");
			lblNewLabel_2_1_1_2.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/envelope 2.png")));
			lblNewLabel_2_1_1_2.setBounds(55, 413, 64, 64);
		}
		return lblNewLabel_2_1_1_2;
	}
	private JTextField getTfPhon1() {
		if (tfPhon1 == null) {
			tfPhon1 = new JTextField();
			tfPhon1.setHorizontalAlignment(SwingConstants.CENTER);
			tfPhon1.setText("010");
			tfPhon1.setColumns(10);
			tfPhon1.setBounds(135, 350, 70, 50);
			
			tfPhon1.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPhon1;
	}
	private JTextField getTfEmail1() {
		if (tfEmail1 == null) {
			tfEmail1 = new JTextField();
			tfEmail1.setHorizontalAlignment(SwingConstants.CENTER);
			tfEmail1.setColumns(10);
			tfEmail1.setBounds(136, 420, 70, 50);
			
			tfEmail1.setBorder(new LineBorder(Color.BLACK));
		}
		return tfEmail1;
	}
	private JTextField getTfPhon3() {
		if (tfPhon3 == null) {
			tfPhon3 = new JTextField();
			tfPhon3.setHorizontalAlignment(SwingConstants.CENTER);
			tfPhon3.setColumns(10);
			tfPhon3.setBounds(305, 350, 70, 50);
			
			tfPhon3.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPhon3;
	}
	private JTextField getTfPhon2() {
		if (tfPhon2 == null) {
			tfPhon2 = new JTextField();
			tfPhon2.setHorizontalAlignment(SwingConstants.CENTER);
			tfPhon2.setColumns(10);
			tfPhon2.setBounds(220, 350, 70, 50);
			
			tfPhon2.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPhon2;
	}
	private JTextField getTfEmail2() {
		if (tfEmail2 == null) {
			tfEmail2 = new JTextField();
			tfEmail2.setHorizontalAlignment(SwingConstants.CENTER);
			tfEmail2.setColumns(10);
			tfEmail2.setBounds(262, 420, 110, 50);
			
			tfEmail2.setBorder(new LineBorder(Color.BLACK));
		}
		return tfEmail2;
	}
	private JTextField getTextField_2() {
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
	private JTextField getTextField_1_1() {
		if (tfPw == null) {
			tfPw = new JTextField();
			tfPw.setHorizontalAlignment(SwingConstants.CENTER);
			tfPw.setColumns(10);
			tfPw.setBounds(135, 210, 240, 50);
			
			tfPw.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPw;
	}
	private JTextField getTextField_2_1() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setHorizontalAlignment(SwingConstants.CENTER);
			tfName.setColumns(10);
			tfName.setBounds(135, 280, 240, 50);
			
			tfName.setBorder(new LineBorder(Color.BLACK));
		}
		return tfName;
	}
	private JButton getBtnPayment() {
		if (btnPayment == null) {
			btnPayment = new JButton("");
			btnPayment.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/price.png")));
			btnPayment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paymentAction();
				}
			});
			btnPayment.setBounds(45, 515, 110, 56);
		}
		return btnPayment;
	}
	private JTextField getTextField_3_1() {
		if (tfPayment == null) {
			tfPayment = new JTextField();
			tfPayment.setEditable(false);
			tfPayment.setHorizontalAlignment(SwingConstants.CENTER);
			tfPayment.setColumns(10);
			tfPayment.setBounds(185, 515, 188, 50);
			
			tfPayment.setBorder(new LineBorder(Color.BLACK));
		}
		return tfPayment;
	}
	private JButton getBttLogout() {
		if (bttLogout == null) {
			bttLogout = new JButton("");
			bttLogout.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/logoutButton.png")));
			bttLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logoutAction();
				}
			});
			bttLogout.setBounds(40, 805, 160, 56);
		}
		return bttLogout;
	}
	private JButton getBttUpdate() {
		if (bttUpdate == null) {
			bttUpdate = new JButton("");
			bttUpdate.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/chgButton.png")));
			bttUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					updateAction();
					
				}
			});
			bttUpdate.setBounds(217, 805, 160, 56);
		}
		return bttUpdate;
	}
	
	// 마이페이지 기본정보 불러오기
	
	
	private void getUserInfo() {
		Dao_yj dao = new Dao_yj(ShareVar.u_id);
		ArrayList<Dto_yj> dtoList = dao.userMypage();
		
	//	 if (!dtoList.isEmpty()) { 
		        tfId.setText(dtoList.get(0).getU_id());
		      //  tfPw.setText(dtoList.get(0).getU_pw());
		        tfName.setText(dtoList.get(0).getU_name());
		        tfPhon2.setText(dtoList.get(0).getU_phone()); 
		        tfPhon3.setText(dtoList.get(0).getU_phone());
		        tfEmail1.setText(dtoList.get(0).getU_email());
		        tfEmail2.setText(dtoList.get(0).getU_email());
		        
		        lbluser.setText(dtoList.get(0).getU_name() + "님의 My page");
		         
	//	 	}
		} 
	
	
	// 마이페이지 정보 수정
	
	private void updateAction() {
		String id = tfId.getText();
		String pw = tfPw.getText();
		String name = tfName.getText();
		String phon1 = tfPhon1.getText();
		String phon2 = tfPhon2.getText(); 
		String phon3 = tfPhon3.getText();
		String email1 = tfEmail1.getText();
		String email2 = tfEmail2.getText();
		
		Dao_yj dao_yj = new Dao_yj(id, pw, name, (email1 + "@" + email2), (phon1 + "-" + phon2 + "-" + phon3));
		boolean result = dao_yj.updateAction(); 
		
		if(result) {
			JOptionPane.showMessageDialog(this, "정보 수정!\n" + tfId.getText() + "님의 정보가 수정 되었습니다.!", "주소록 정보", JOptionPane.INFORMATION_MESSAGE);
		
		}

		
	}
	
// 로그아웃
	
	private void logoutAction() {
	    String id = tfId.getText().trim();

	    Dao_yj dao_yj = new Dao_yj();

	    boolean result = dao_yj.logoutAction(id);

	    if (result) {
	        JOptionPane.showMessageDialog(this, id + "님 로그아웃 하셨습니다.", "로그아웃", JOptionPane.INFORMATION_MESSAGE);

	        MainLogin_Yj mainLogin_Yj = new MainLogin_Yj();
	        mainLogin_Yj.setVisible(true);

	        dispose();
	    }
	}
	
// 결제 금액
	
	private void paymentAction() {
	    Dao_yj dao = new Dao_yj(ShareVar.u_id);
	    ArrayList<Dto_yj> dtoList = dao.paymentAction();

	    if (!dtoList.isEmpty()) {
	        tfPayment.setText(dtoList.get(0).getPayment());
	    }
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(MainMypage_Yj.class.getResource("/imageMypage/@.png")));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(218, 429, 32, 32);
		}
		return lblNewLabel_1;
	}
	private JLabel getLbluser() {
		if (lbluser == null) {
			lbluser = new JLabel("");
			lbluser.setBounds(262, 111, 120, 29);
		}
		return lbluser;
	}
} // End