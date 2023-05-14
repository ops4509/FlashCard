package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javalec.dao.Dao_mycard;
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

public class Mycard_03insert extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btn_Insert;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tf_Title;
	private JTextField tf_Genre;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField tf_Contents;
	private JTextField tf_Answer;


	public static String selectedcardid_insert ;
	String user_SampleID = ShareVar.UserSampleId; //로그인한 유저의 ID를 SV에서 불러오기 
	String user_SampleName = ShareVar.UserSampleName;  //로그인한 유저의 이름을 SV에서 불러오기 
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mycard_03insert frame = new Mycard_03insert();
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
	public Mycard_03insert() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				selectedcardid_insert = Mycard_01main.main01.select_ci;
			
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
		contentPane.add(getBtn_Insert());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getTf_Title());
		contentPane.add(getTf_Genre());
		contentPane.add(getTextField_4());
		contentPane.add(getTextField_5());
		contentPane.add(getTf_Contents());
		contentPane.add(getTf_Answer());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("비워둘 창로고 들어가야함\\\\글씨는 하단에 붙였음.\n");
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
			lblNewLabel_1 = new JLabel(user_SampleName +"  님");
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
	private JButton getBtn_Insert() {
		if (btn_Insert == null) {
			btn_Insert = new JButton("확   인");
			btn_Insert.setBackground(Color.LIGHT_GRAY);
			btn_Insert.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			btn_Insert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				insertAction();
				
				
				}
			});
			btn_Insert.setBounds(40, 768, 348, 62);
		}
		return btn_Insert;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setText("장르");
			textField.setBounds(40, 176, 70, 40);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setText("타이틀");
			textField_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_1.setColumns(10);
			textField_1.setBounds(40, 126, 70, 40);
		}
		return textField_1;
	}
	private JTextField getTf_Title() {
		if (tf_Title == null) {
			tf_Title = new JTextField();
			tf_Title.setBounds(135, 126, 253, 40);
			tf_Title.setColumns(10);
		}
		return tf_Title;
	}
	private JTextField getTf_Genre() {
		if (tf_Genre == null) {
			tf_Genre = new JTextField();
			tf_Genre.setColumns(10);
			tf_Genre.setBounds(135, 176, 253, 40);
		}
		return tf_Genre;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setText("카드의 앞면을 입력해주세요. ");
			textField_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_4.setBounds(40, 260, 348, 40);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setText("카드의 뒷면을 입력해 주세요.");
			textField_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_5.setColumns(10);
			textField_5.setBounds(40, 520, 348, 40);
		}
		return textField_5;
	}
	private JTextField getTf_Contents() {
		if (tf_Contents == null) {
			tf_Contents = new JTextField();
			tf_Contents.setBounds(40, 305, 348, 180);
			tf_Contents.setColumns(10);
		}
		return tf_Contents;
	}
	private JTextField getTf_Answer() {
		if (tf_Answer == null) {
			tf_Answer = new JTextField();
			tf_Answer.setColumns(10);
			tf_Answer.setBounds(40, 565, 348, 180);
		}
		return tf_Answer;
	}
	
	
	
	
	private void insertAction() {
		Dao_mycard dao = new Dao_mycard();
		String title = tf_Title.getText();
		String genre = tf_Genre.getText();
		String contents = tf_Contents.getText();
		String answer = tf_Answer.getText();
		
		
		
		
		
		dao.usercardInsert(title,genre,contents,answer);
		
		
	}
	
	
	
	
	
}//엔드게임.
