package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.DaoBuy_OKH;
import com.javalec.dao.DaoUser_OKH;
import com.javalec.dao.Dao_yj;
import com.javalec.dto.DtoUser_OKH;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class MypageUser extends JFrame {

	private JPanel contentPane;
	private JLabel lblMypage;
	private JLabel lblID;
	private JLabel lblPW;
	private JLabel lblName;
	private JLabel lblPhone;
	private JLabel lblNewLabel;
	private JButton btnPayment;
	private JTextField tfID;
	private JTextField tfPW;
	private JTextField tfName;
	private JTextField tfPhoneF;
	private JTextField tfPhoneM;
	private JTextField tfPhoneB;
	private JTextField tfEmailF;
	private JLabel lblAt;
	private JTextField tfEmailB;
	private JLabel lblPrice;
	private JButton btnLogout;
	private JButton btnUpdate;
	private JLabel lblUser;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MypageUser frame = new MypageUser();
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
	public MypageUser() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				getUserinfo();
			}
		});
		setTitle("마이페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblMypage());
		contentPane.add(getLblID());
		contentPane.add(getLblPW());
		contentPane.add(getLblName());
		contentPane.add(getLblPhone());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnPayment());
		contentPane.add(getTfID());
		contentPane.add(getTfPW());
		contentPane.add(getTfName());
		contentPane.add(getTfPhoneF());
		contentPane.add(getTfPhoneM());
		contentPane.add(getTfPhoneB());
		contentPane.add(getTfEmailF());
		contentPane.add(getLblAt());
		contentPane.add(getTfEmailB());
		contentPane.add(getLblPrice());
		contentPane.add(getBtnLogout());
		contentPane.add(getBtnUpdate());
		contentPane.add(getLblUser());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
	}

	private JLabel getLblMypage() {
		if (lblMypage == null) {
			lblMypage = new JLabel("");
			lblMypage.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/myCard.png")));
			lblMypage.setBounds(60, 59, 135, 70);
		}
		return lblMypage;
	}

	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("");
			lblID.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/id-3 3.png")));
			lblID.setBounds(55, 140, 64, 64);
		}
		return lblID;
	}

	private JLabel getLblPW() {
		if (lblPW == null) {
			lblPW = new JLabel("");
			lblPW.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/padlock 3.png")));
			lblPW.setBounds(55, 203, 64, 64);
		}
		return lblPW;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/user 2.png")));
			lblName.setBounds(60, 273, 64, 64);
		}
		return lblName;
	}

	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("");
			lblPhone.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/phone-call 2.png")));
			lblPhone.setBounds(55, 343, 64, 64);
		}
		return lblPhone;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel();
			lblNewLabel.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/envelope 2.png")));
			lblNewLabel.setBounds(55, 413, 64, 64);
		}
		return lblNewLabel;
	}

	private JButton getBtnPayment() {
		if (btnPayment == null) {
			btnPayment = new JButton();
			btnPayment.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/price.png")));
			btnPayment.setBounds(45, 515, 110, 56);
		}
		return btnPayment;
	}

	private JTextField getTfID() {
		if (tfID == null) {
			tfID = new JTextField();
			tfID.setEnabled(false);
			tfID.setEditable(false);
			tfID.setBounds(135, 147, 240, 50);
			tfID.setColumns(10);
		}
		return tfID;
	}

	private JTextField getTfPW() {
		if (tfPW == null) {
			tfPW = new JTextField();
			tfPW.setColumns(10);
			tfPW.setBounds(135, 210, 240, 50);
		}
		return tfPW;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setEnabled(false);
			tfName.setEditable(false);
			tfName.setColumns(10);
			tfName.setBounds(135, 280, 240, 50);
		}
		return tfName;
	}

	private JTextField getTfPhoneF() {
		if (tfPhoneF == null) {
			tfPhoneF = new JTextField();
			tfPhoneF.setColumns(10);
			tfPhoneF.setBounds(135, 350, 70, 50);
		}
		return tfPhoneF;
	}

	private JTextField getTfPhoneM() {
		if (tfPhoneM == null) {
			tfPhoneM = new JTextField();
			tfPhoneM.setColumns(10);
			tfPhoneM.setBounds(220, 350, 70, 50);
		}
		return tfPhoneM;
	}

	private JTextField getTfPhoneB() {
		if (tfPhoneB == null) {
			tfPhoneB = new JTextField();
			tfPhoneB.setColumns(10);
			tfPhoneB.setBounds(305, 350, 70, 50);
		}
		return tfPhoneB;
	}

	private JTextField getTfEmailF() {
		if (tfEmailF == null) {
			tfEmailF = new JTextField();
			tfEmailF.setBounds(136, 420, 110, 50);
			tfEmailF.setColumns(10);
		}
		return tfEmailF;
	}

	private JLabel getLblAt() {
		if (lblAt == null) {
			lblAt = new JLabel("");
			lblAt.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/@.png")));
			lblAt.setBounds(250, 435, 32, 32);
		}
		return lblAt;
	}

	private JTextField getTfEmailB() {
		if (tfEmailB == null) {
			tfEmailB = new JTextField();
			tfEmailB.setColumns(10);
			tfEmailB.setBounds(290, 420, 85, 50);
		}
		return tfEmailB;
	}

	private JLabel getLblPrice() {
		if (lblPrice == null) {
			lblPrice = new JLabel();
			lblPrice.setBounds(185, 515, 188, 50);
		}
		return lblPrice;
	}

	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logout();
					MainLogin_Yj mainLogin_Yj = new MainLogin_Yj();
					mainLogin_Yj.setVisible(true);
					dispose();
				}
			});
			btnLogout.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/logoutButton.png")));
			btnLogout.setBounds(40, 805, 160, 56);
		}
		return btnLogout;
	}

	private JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton("");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					updateAction();
					MainView mainview = new MainView();
					mainview.setVisible(true);
					dispose();
				}
			});
			btnUpdate.setIcon(new ImageIcon(MypageUser.class.getResource("/com/javalec/assets/chgButton.png")));
			btnUpdate.setBounds(217, 805, 160, 56);
		}
		return btnUpdate;
	}

	private JLabel getLblUser() {
		if (lblUser == null) {
			lblUser = new JLabel("");
			lblUser.setBounds(262, 111, 120, 29);
		}
		return lblUser;
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("-");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(185, 367, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("-");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setBounds(266, 367, 61, 16);
		}
		return lblNewLabel_1_1;
	}

	// function

	// 마이페이지 기본정보 가져오기.
	private void getUserinfo() {
		DaoUser_OKH dao = new DaoUser_OKH(ShareVar.u_id);
		ArrayList<DtoUser_OKH> dtoList = dao.selectUserinfo();

		tfID.setText(dtoList.get(0).getUid());
		tfPW.setText(dtoList.get(0).getUpw());
		tfName.setText(dtoList.get(0).getUname());
		tfPhoneF.setText(dtoList.get(0).getUphonef());
		tfPhoneM.setText(dtoList.get(0).getUphonem());
		tfPhoneB.setText(dtoList.get(0).getUphoneb());
		tfEmailF.setText(dtoList.get(0).getUemailf());
		tfEmailB.setText(dtoList.get(0).getUemailb());

		lblUser.setText(dtoList.get(0).getUname() + "님의 My page");

		DaoBuy_OKH daobuy = new DaoBuy_OKH();
		int price = daobuy.selectPrice();
		lblPrice.setText(Integer.toString(price)+"\t 원 입니다.");

	}

	// 마이페이지 정보 수정

	private void updateAction() {
		String id = tfID.getText();
		String pw = tfPW.getText();
		String name = tfName.getText();
		String phon1 = tfPhoneF.getText();
		String phon2 = tfPhoneM.getText();
		String phon3 = tfPhoneB.getText();
		String email1 = tfEmailF.getText();
		String email2 = tfEmailB.getText();

		DaoUser_OKH dao = new DaoUser_OKH(id, pw, name, (phon1 + "-" + phon2 + "-" + phon3), (email1 + "@" + email2));
		dao.updateAction();

		JOptionPane.showMessageDialog(this, "정보 수정!\n" + tfName.getText() + "님의 정보가 수정 되었습니다.!", "마이페이지 정보 수정 완료!",
				JOptionPane.INFORMATION_MESSAGE);

	}

	// User logout

	private void logout() {
		DaoUser_OKH dao = new DaoUser_OKH();
		dao.logoutAction();
	}

	
}
