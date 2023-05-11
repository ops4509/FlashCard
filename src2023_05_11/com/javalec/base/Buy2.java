package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Buy2 extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblPcs;
	private JLabel lblPrice;
	private JLabel lblPoint;
	private JLabel lblallPrice;
	private JLabel lblBack;
	private JLabel lblNewLabel_3;
	private JLabel lblHello;
	private JLabel lblMyCard;
	private JTextField tfpcs;
	private JTextField tfPrice;
	private JTextField textField_2;
	private JTextField tfAllPrice;
	private JButton btnBag;
	private JButton btnBuy;
	private JButton btnAdd;
	private JLabel lbltext;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy2 frame = new Buy2();
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
	public Buy2() {
		setBackground(new Color(255, 255, 255));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblPcs());
		contentPane.add(getLblPrice());
		contentPane.add(getLblPoint());
		contentPane.add(getLblallPrice());
		contentPane.add(getLblBack());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getLblHello());
		contentPane.add(getLblMyCard());
		contentPane.add(getLbltext());
		contentPane.add(getTfpcs());
		contentPane.add(getTfPrice());
		contentPane.add(getTextField_2());
		contentPane.add(getTfAllPrice());
		contentPane.add(getBtnBag());
		contentPane.add(getBtnBuy());
		contentPane.add(getBtnAdd());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(41, 154, 346, 322);
		}
		return scrollPane;
	}
	// 수량 버튼 이미지
	private JLabel getLblPcs() {
		if (lblPcs == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/EA.png");
			lblPcs = new JLabel("");
			lblPcs.setBounds(41, 536, 90, 29);
			lblPcs.setIcon(icon);
		}
		return lblPcs;
	}
	// 금액 버튼 이미지 
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/Price.png");
			lblPrice = new JLabel("");
			lblPrice.setBounds(41, 577, 90, 29);
			lblPrice.setIcon(icon);
			
		}
		return lblPrice;
	}
	// 포인트버튼 이미지 ( 구현할지 말지 미지수)
	private JLabel getLblPoint() {
		if (lblPoint == null) {
			lblPoint = new JLabel("New label");
			lblPoint.setBounds(41, 637, 61, 16);
		}
		return lblPoint;
	}
	// 총금액 버튼 이미지 
	private JLabel getLblallPrice() {
		if (lblallPrice == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/allPrice.png");
			lblallPrice = new JLabel("");
			lblallPrice.setBounds(41, 693, 90, 29);
			lblallPrice.setIcon(icon);
		}
		return lblallPrice;
	}
	// 뒤로가기 버튼 
	private JLabel getLblBack() {
		if (lblBack == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/back.png");
			lblBack = new JLabel("");
			lblBack.setBounds(41, 41, 61, 16);
			lblBack.setIcon(icon);
		}
		return lblBack;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("______님 ");
			lblNewLabel_3.setBounds(333, 103, 61, 16);
		}
		return lblNewLabel_3;
	}
	// 닉네임 옆 Hello 로
	private JLabel getLblHello() {
		if (lblHello == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/hello.png");
			lblHello = new JLabel("");
			lblHello.setBounds(259, 77, 113, 54);
			lblHello.setIcon(icon);
		}
		return lblHello;
	}
	// 홈으로 돌아가는 메인로고 
	private JLabel getLblMyCard() {
		if (lblMyCard == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/MyCardMainLogo.png");
			lblMyCard = new JLabel("");
			lblMyCard.setBounds(157, 8, 107, 49);
			lblMyCard.setIcon(icon);
		}
		return lblMyCard;
	}
	// 주문수량 노출하는 텍스트 
	private JTextField getTfpcs() {
		if (tfpcs == null) {
			tfpcs = new JTextField();
			tfpcs.setBounds(297, 531, 90, 34);
			tfpcs.setColumns(10);
		}
		return tfpcs;
	}
	//  상품금액 노출하는 텍스트 
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/Price.png");
			tfPrice = new JTextField();
			tfPrice.setBounds(259, 577, 130, 34);
			tfPrice.setColumns(10);
			lblPrice.setIcon(icon);
		}
		return tfPrice;
	}
	// 포인트 노출하는 텍스트인데 아직 구현할지 말지 고민중.
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(259, 632, 130, 34);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	// 총 주문금액 노출하는 텍스트
	private JTextField getTfAllPrice() {
		if (tfAllPrice == null) {
			tfAllPrice = new JTextField();
			tfAllPrice.setBounds(222, 688, 169, 34);
			tfAllPrice.setColumns(10);
		}
		return tfAllPrice;
	}
	// 장바구니 버튼 
	private JButton getBtnBag() {
		if (btnBag == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/bag.png");
			btnBag = new JButton("");
			btnBag.setBounds(83, 803, 117, 29);
			btnBag.setIcon(icon);
		}
		return btnBag;
	}
	// 구매하기 버튼 
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/buy.png");
			btnBuy = new JButton("");
			btnBuy.setBounds(218, 803, 117, 29);
			btnBuy.setIcon(icon);
		}
		return btnBuy;
	}
	// 주문수량 더하는 버튼 
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("+");
			btnAdd.setBounds(246, 531, 47, 29);
		}
		return btnAdd;
	}
	// 화면하단 사업자텍스트 노출 
	private JLabel getLbltext() {
		if (lbltext == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/text.png");
			lbltext = new JLabel("");
			lbltext.setBounds(41, 844, 346, 48);
			lbltext.setIcon(icon);
		}
		return lbltext;
	}
} // End --------------------------------------------------------------------------------------------------------
