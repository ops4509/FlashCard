package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.daoBuy.DaoBuy;
import com.javalec.dtoBuy.DtoBuy;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTable innertable;

	public String selectedName;
	private int price;

	private final DefaultTableModel outerTable = new DefaultTableModel();

	public Buy2(String selectedName) {
		super();
		this.selectedName = selectedName;

		setBackground(new Color(255, 255, 255));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
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
				tableInit();
				searchAction();
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
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}

	// 수량 버튼 이미지
	private JLabel getLblPcs() {
		if (lblPcs == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/EA.png");
			lblPcs = new JLabel("");
			lblPcs.setBounds(41, 540, 90, 29);
			lblPcs.setIcon(icon);
		}
		return lblPcs;
	}

	// 금액 버튼 이미지
	private JLabel getLblPrice() {
		if (lblPrice == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/Price.png");
			lblPrice = new JLabel("");
			lblPrice.setBounds(41, 591, 90, 29);
			lblPrice.setIcon(icon);

		}
		return lblPrice;
	}

	// 포인트버튼 이미지 ( 구현할지 말지 미지수)
	private JLabel getLblPoint() {
		if (lblPoint == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/point.png");
			lblPoint = new JLabel("");
			lblPoint.setBounds(41, 637, 90, 29);
			lblPoint.setIcon(icon);
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
		lblBack.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				changepage();
			}
		});
		return lblBack;
	}

	private void changepage() {
		setVisible(false);
		Buy1 buy1 = new Buy1();
		buy1.setVisible(true);
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
			tfpcs.setEditable(false);
			tfpcs.setBounds(297, 540, 90, 34);
			tfpcs.setColumns(10);
		}
		return tfpcs;
	}

	// 상품금액 노출하는 텍스트
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/Price.png");
			tfPrice = new JTextField();
			tfPrice.setEditable(false);
			tfPrice.setBounds(257, 586, 130, 34);
			tfPrice.setColumns(10);
			lblPrice.setIcon(icon);
		}
		return tfPrice;
	}

	// 포인트 노출하는 텍스트인데 아직 구현할지 말지 고민중.
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setBounds(259, 632, 130, 34);
			textField_2.setColumns(10);
		}
		return textField_2;
	}

	// 총 주문금액 노출하는 텍스트
	private JTextField getTfAllPrice() {
		if (tfAllPrice == null) {
			tfAllPrice = new JTextField();
			tfAllPrice.setEditable(false);
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
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTotalPrice();
				}
			});
			btnAdd.setBounds(248, 544, 47, 29);
		}
		return btnAdd;
	}

	private void getTotalPrice() {
		int count = Integer.parseInt(tfpcs.getText());
		count++;
		tfpcs.setText(Integer.toString(count));
		int totalprice = this.price * count;
		tfAllPrice.setText(Integer.toString(totalprice));
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

	// 장바구니 목록으로 들어간 상품 보여주는 테이블
	private JTable getInnertable() {
		if (innertable == null) {
			innertable = new JTable() {
				public Class getColumnClass(int column) { // <<<<
					return (column == 0) ? Icon.class : Object.class; // 첫번째 열이면 아이콘 클래스, 아니면 오브젝트 클래스로 지정
				}// 테이블의 각 열마다의 데이터 형을 지정 //<<<<
			};
			innertable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innertable.setModel(outerTable);
			innertable.setRowHeight(150);// 출력할때 글자와 그림의 높이를 맞추기 위해 설정
		}
		return innertable;
	}

	// Function-----------------------------------------------------------------------------------------------------

	// 상품주문페이지 테이블 노출화면
	private void tableInit() {
		outerTable.addColumn("제품사진");
		outerTable.addColumn("금액");
		outerTable.addColumn("수량");
		outerTable.setColumnCount(3);

		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}

		innertable.setAutoResizeMode(innertable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = innertable.getColumnModel().getColumn(vColIndex);
		int width = 200;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 120;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = innertable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);
	}

	private void searchAction() {
		DaoBuy dao = new DaoBuy("c.coname", this.selectedName);
		ArrayList<DtoBuy> dtoList = dao.conditionList();
		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			tfpcs.setText("1");
			tfPrice.setText(Integer.toString(dtoList.get(i).getCsprice()));
			this.price = dtoList.get(i).getCsprice();
			ImageIcon icon = new ImageIcon(dtoList.get(i).getCopic());
			Object[] qTxt = { icon, dtoList.get(i).getConame(), Integer.toString(dtoList.get(i).getCsprice()) };
			outerTable.addRow(qTxt);
		}
	}

} // End
	// --------------------------------------------------------------------------------------------------------
