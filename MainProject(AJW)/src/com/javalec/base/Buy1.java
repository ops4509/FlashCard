package com.javalec.base;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Buy1 extends JFrame {

	private JPanel contentPane;
	private JScrollPane innerTable;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy1 frame = new Buy1();
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
	public Buy1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getInnerTable());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_1_1());
	}

	
	// 상품목록 구성하는 테이블 ( 이미지 넣는 곳 )
	private JScrollPane getInnerTable() {
		if (innerTable == null) {
			innerTable = new JScrollPane();
			innerTable.setBounds(34, 132, 356, 647);
		}
		return innerTable;
	}
	// 화살표 이미지 넣어야 하는 곳 ( 뒤로가기 버튼 )
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("화살표");
			lblNewLabel.setBounds(48, 79, 61, 16);
		}
		return lblNewLabel;
	}
	// 회원명 노출하는 Text filed 
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(260, 74, 130, 48);
			textField.setColumns(10);
		}
		return textField;
	}
	//  Hello 이미지 들어간는 곳 ( 라벨이랑 같이 글씨도 노출할 수 있는지 체크할 것 
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Hello ");
			lblNewLabel_1.setBounds(223, 79, 37, 16);
		}
		return lblNewLabel_1;
	}
	// 메인로고누르면 홈으로 돌아가는 이미지 넣는 
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("메인로고 홈버튼");
			lblNewLabel_1_1.setBounds(167, 27, 87, 16);
		}
		return lblNewLabel_1_1;
	}
	
	
	
	// Function-------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // End------------------------------------------------------------------------------------------------------------------------------
