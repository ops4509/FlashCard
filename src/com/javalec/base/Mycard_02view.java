package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Dao_mycard;
import com.javalec.dto.Dto_card;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Mycard_02view extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btn_update;
	private JButton btn_delete;
	private JButton btn_confirm;
	private JTextField tf_Collection;
	private JTextField tf_Title;
	private JTextField tf_Genre;
	private JTextField tf_Contents;
	private JTextField tf_Answer;

	
	public static String viewCid ;  //Mycard_01Main에서 가져온 카드 아이디 기억할 변
	String user_SampleID = ShareVar.UserSampleId; //로그인한 유저의 ID를 SV에서 불러오기 
	String user_SampleName = ShareVar.UserSampleName;  //로그인한 유저의 이름을 SV에서 불러오기 
	
	
	public static String view_title ;
	public static String view_genre;
	public static String view_contents;
	public static String view_answer;
	


	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mycard_02view frame = new Mycard_02view();
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
	public Mycard_02view() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// viewCid = main01.select_ci;    // --- 위 필드쪽에서 재정의 함.
				viewCid = Mycard_01main.select_ci;
				screenpartition();
				System.out.println("새로운창 넘어가고 카드 아이디 : " +viewCid);
				printCard();
			
			
			}
			@Override
			public void windowActivated(WindowEvent e) {
				screenpartition();
				printCard();
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 906);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnNewButton());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getBtn_update());
		contentPane.add(getBtn_delete());
		contentPane.add(getBtn_confirm());
		contentPane.add(getTf_Collection());
		contentPane.add(getTf_Title());
		contentPane.add(getTf_Genre());
		contentPane.add(getTf_Contents());
		contentPane.add(getTf_Answer());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("<html>비워둘 창로고 들어가야함<br>글씨는 하단에 붙였음.</html>\n");
			lblNewLabel.setBounds(0, 0, 428, 70);
			lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNewLabel.setForeground(new Color(147, 32, 146));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBackground(new Color(147, 32, 146));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel(user_SampleName + "  님");
			lblNewLabel_1.setBounds(308, 82, 80, 20);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("뒤로가기버튼.       ");
			btnNewButton.setBounds(40, 82, 117, 20);
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Mycard_01main.main01.setVisible(true);
					dispose();
				
				}
			});
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("하단 메시지 위해 비우는 창 (위로 붙였음)");
			lblNewLabel_2.setBounds(0, 838, 428, 40);
			lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_2;
	}
	private JButton getBtn_update() {
		if (btn_update == null) {
			btn_update = new JButton("수정하기");
			btn_update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Mycard_01main.updateMain.setVisible(true);
					dispose();
				
				}
			});
			btn_update.setBounds(40, 780, 90, 50);
		}
		return btn_update;
	}
	private JButton getBtn_delete() {
		if (btn_delete == null) {
			btn_delete = new JButton("삭제하기");
			btn_delete.setBounds(169, 780, 90, 50);
		}
		return btn_delete;
	}
	private JButton getBtn_confirm() {
		if (btn_confirm == null) {
			btn_confirm = new JButton("확인");
			btn_confirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					Mycard_01main.main01.setVisible(true);
					dispose();
				
				}
			});
			btn_confirm.setBounds(298, 780, 90, 50);
		}
		return btn_confirm;
	}
	private JTextField getTf_Collection() {
		if (tf_Collection == null) {
			tf_Collection = new JTextField();
			tf_Collection.setText("콜렉션명");
			tf_Collection.setBounds(40, 124, 110, 30);
			tf_Collection.setColumns(10);
		}
		return tf_Collection;
	}
	private JTextField getTf_Title() {
		if (tf_Title == null) {
			tf_Title = new JTextField();
			tf_Title.setText("타이틀명");
			tf_Title.setColumns(10);
			tf_Title.setBounds(174, 124, 110, 30);
		}
		return tf_Title;
	}
	private JTextField getTf_Genre() {
		if (tf_Genre == null) {
			tf_Genre = new JTextField();
			tf_Genre.setText("과목(장르)");
			tf_Genre.setColumns(10);
			tf_Genre.setBounds(308, 124, 80, 30);
		}
		return tf_Genre;
	}
	private JTextField getTf_Contents() {
		if (tf_Contents == null) {
			tf_Contents = new JTextField();
			tf_Contents.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			tf_Contents.setText("나를 죽이지 못하는 고통은");
			tf_Contents.setHorizontalAlignment(SwingConstants.CENTER);
			tf_Contents.setBounds(40, 180, 348, 343);
			tf_Contents.setColumns(10);
		}
		return tf_Contents;
	}
	private JTextField getTf_Answer() {
		if (tf_Answer == null) {
			tf_Answer = new JTextField();
			tf_Answer.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			tf_Answer.setText("나를 성장시킬 뿐이다.");
			tf_Answer.setHorizontalAlignment(SwingConstants.CENTER);
			tf_Answer.setBounds(40, 595, 348, 111);
			tf_Answer.setColumns(10);
		}
		return tf_Answer;
	}
	
	
	
	
	
	
	// 받아오고 넘겨주는 데이터 순서는 contents / answer / (collection) / title / genre / cid 

	
	// -------------------------function --------------------------
	private void printCard() {
		String favor = viewCid.substring(0,2);

			Dao_mycard dao = new Dao_mycard();
			ArrayList<Dto_card> dtoList = dao.getUcView(viewCid);
			//int listCount = dtoList.size();
			System.out.println("넘어온 콘텐츠 내용"+dtoList.get(0).getCcontents());
			System.out.println(dtoList.get(0).getCcontents());
			
			
			tf_Contents.setText(dtoList.get(0).getCcontents());
			tf_Answer.setText(dtoList.get(0).getCanswer());
			tf_Collection.setText(dtoList.get(0).getCollection());
			tf_Title.setText(dtoList.get(0).getCtitle());
			tf_Genre.setText(dtoList.get(0).getCgenre());
			
			view_title = dtoList.get(0).getCtitle();
			view_genre = dtoList.get(0).getCgenre();
			view_contents = dtoList.get(0).getCcontents();
			view_answer = dtoList.get(0).getCanswer();
		
	}
	
	
	private void screenpartition () {
		
		if(viewCid.substring(0,2).equals("CC")) {
			btn_update.setEnabled(false);
			btn_delete.setEnabled(false);
			
			
		}else if (viewCid.substring(0,2).equals("UC")) {
			btn_update.setEnabled(true);
			btn_delete.setEnabled(true);
			
		}
		
	}
	

}//02페이지의 엔드게임나
