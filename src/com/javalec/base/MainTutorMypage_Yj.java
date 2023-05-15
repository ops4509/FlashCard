package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.DaoBuy;
import com.javalec.dao.DaoTutor_OKH;
import com.javalec.dao.Dao_yj;
import com.javalec.dto.DtoBuy;
import com.javalec.dto.DtoTutor_OKH;
import com.javalec.dto.Dto_yj;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

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
	private JLabel lblNewLabel_2_1_1_1_1;
	private JTextField tfSpeciality;
	private JScrollPane scrollPane;
	private JTable innerTable;

	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lblCol;
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
				tableInit();
				searchAction();
			}
		});
		setTitle("My Card Tutor 마이 페이지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblCol());
		contentPane.add(getLblNewLabel_2_1_1_1_1());
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
		contentPane.add(getTfSpeciality());
		contentPane.add(getScrollPane());
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
		Dao_yj dao = new Dao_yj(ShareVar.u_id);
		ArrayList<DtoTutor_OKH> dtoList = dao.getTetorInfo();
		        tfId.setText(dtoList.get(0).getTid());
		        tfPw.setEchoChar('*');
		        tfPw.setText(dtoList.get(0).getTpw());
		        tfName.setText(dtoList.get(0).getTname());
		        tfSpeciality.setText(dtoList.get(0).getTspeciality());
		        
		        lblTutor.setText(dtoList.get(0).getTpw() + "선생님의 My page");
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
			tfPw.setBackground(new Color(225, 225, 225));
			tfPw.setBounds(135, 210, 240, 50);
		}
		return tfPw;
	}
	private JLabel getLblNewLabel_2_1_1_1_1() {
		if (lblNewLabel_2_1_1_1_1 == null) {
			lblNewLabel_2_1_1_1_1 = new JLabel("");
			lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(MainTutorMypage_Yj.class.getResource("/com/javalec/assets/memo.png")));
			lblNewLabel_2_1_1_1_1.setBounds(65, 347, 38, 64);
		}
		return lblNewLabel_2_1_1_1_1;
	}
	private JTextField getTfSpeciality() {
		if (tfSpeciality == null) {
			tfSpeciality = new JTextField();
			tfSpeciality.setHorizontalAlignment(SwingConstants.CENTER);
			tfSpeciality.setEditable(false);
			tfSpeciality.setColumns(10);
			tfSpeciality.setBorder(new LineBorder(Color.BLACK));
			tfSpeciality.setBounds(135, 350, 240, 50);
		}
		return tfSpeciality;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 463, 333, 275);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	// function
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable() {
				public Class getColumnClass(int column) { // <<<<
					return (column == 1) ? Icon.class : Object.class; // 첫번째 열이면 아이콘 클래스, 아니면 오브젝트 클래스로 지정
				}// 테이블의 각 열마다의 데이터 형을 지정 //<<<<
			};
			innerTable.setModel(outerTable);
			innerTable.setRowHeight(150);// 출력할때 글자와 그림의 높이를 맞추기 위해 설정
		}
		return innerTable;
	}
	// 최초 테이블 outTable 구성
	private void tableInit() {
		outerTable.addColumn("튜터ID");
		outerTable.addColumn("카드사진");
		outerTable.addColumn("상품명");	

		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(vColIndex);
		int width = 110;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);

	}
	// 실행시 보여지는 내용
		private void searchAction() {
			DaoBuy dao = new DaoBuy();
			ArrayList<DtoBuy> dtoList = dao.searchList();
			int listCount = dtoList.size();
			
			for (int i = 0; i < listCount; i++) {
				String subStr = dtoList.get(i).getCoid().substring(0,8);
				System.out.println(subStr);
				if(subStr.equals(ShareVar.u_id)) {
					ImageIcon icon = new ImageIcon(dtoList.get(i).getCopic());
					Object[] qTxt = { dtoList.get(i).getCoid(), icon, dtoList.get(i).getConame()};
					outerTable.addRow(qTxt);
				}
			}
		}
	// end
	private JLabel getLblCol() {
		if (lblCol == null) {
			lblCol = new JLabel("튜터가 제작한 컬렉션");
			lblCol.setBackground(new Color(189, 179, 207));
			lblCol.setFont(new Font("LG Smart UI SemiBold", Font.PLAIN, 23));
			lblCol.setHorizontalAlignment(SwingConstants.CENTER);
			lblCol.setBounds(40, 432, 333, 30);
		}
		return lblCol;
	}
}
