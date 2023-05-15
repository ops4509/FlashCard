package com.javalec.base;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoBuy;

import com.javalec.dto.DtoBuy;

import com.javalec.util.ShareVar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Buy2 extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblPcs;
	// private JLabel lblPoint;
	private JLabel lblallPrice;
	private JLabel lblBack;
	private JLabel lblName;
	private JLabel lblHello;
	private JLabel lblMyCard;
	private JTextField tfAllPrice;
	private JButton btnBuy;
	private JLabel lbltext;
	public static JTable innertable;

	public String selectedName;
	private int price;
	int wkbSeqno = 0;

	DtoBuy dto;

	public static int csprice2;
	public static String cs_coid2;
	String b_uid2;

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	private final DefaultTableModel outerTable = new DefaultTableModel();
	private JLabel lbllong;

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
		// contentPane.add(getLblPcs());
		// contentPane.add(getLblPrice());
		// contentPane.add(getLblPoint());
		contentPane.add(getLblallPrice());
		contentPane.add(getLblBack());
		contentPane.add(getLblName());
		contentPane.add(getLblHello());
		contentPane.add(getLblMyCard());
		contentPane.add(getLbltext());
		// contentPane.add(getTfpcs());
		// contentPane.add(getTfPrice());
		// contentPane.add(getTextField_2());
		contentPane.add(getTfAllPrice());

		contentPane.add(getBtnBuy());
		// contentPane.add(getBtnAdd());
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
				lblName.setText(ShareVar.u_name + "님!");
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		// contentPane.add(getLblPoint());
		contentPane.add(getLblallPrice());
		contentPane.add(getLblBack());
		contentPane.add(getLblName());
		contentPane.add(getLblHello());
		contentPane.add(getLblMyCard());
		contentPane.add(getLbltext());
		contentPane.add(getTfAllPrice());
		contentPane.add(getBtnBuy());
		contentPane.add(getLbllong());

	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 312, 346, 333);
			scrollPane.setViewportView(getInnertable());
		}
		return scrollPane;
	}

	/*
	 * // 포인트버튼 이미지 ( 구현할지 말지 미지수) private JLabel getLblPoint() { if (lblPoint ==
	 * null) { ImageIcon icon = new ImageIcon("src/com/javalec/images/point.png");
	 * lblPoint = new JLabel(""); lblPoint.setBounds(41, 637, 90, 29);
	 * lblPoint.setIcon(icon); } return lblPoint; }
	 */

	// 총금액 버튼 이미지
	private JLabel getLblallPrice() {
		if (lblallPrice == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/assets/pricetag.png");
			lblallPrice = new JLabel("");
			lblallPrice.setBounds(73, 675, 77, 78);
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

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setBounds(337, 89, 75, 37);
		}
		return lblName;
	}

	// 닉네임 옆 Hello 로
	private JLabel getLblHello() {
		if (lblHello == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/hello.png");
			lblHello = new JLabel("");
			lblHello.setBounds(268, 81, 64, 33);
			lblHello.setIcon(icon);
		}
		return lblHello;
	}

	// 홈으로 돌아가는 메인로고
	private JLabel getLblMyCard() {
		if (lblMyCard == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/assets/LOGO.png");
			lblMyCard = new JLabel("");
			lblMyCard.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					changepage2();

				}
			});
			lblMyCard.setBounds(43, 126, 344, 174);
			lblMyCard.setIcon(icon);
		}
		return lblMyCard;
	}

	// 총 주문금액 노출하는 텍스트
	private JTextField getTfAllPrice() {
		if (tfAllPrice == null) {
			tfAllPrice = new JTextField();
			tfAllPrice.setBounds(206, 699, 169, 54);
			tfAllPrice.setHorizontalAlignment(SwingConstants.CENTER);
			tfAllPrice.setEditable(false);
			tfAllPrice.setColumns(10);
		}
		return tfAllPrice;
	}

	// 구매하기 버튼
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/assets/Buy3.png");
			btnBuy = new JButton("");
			btnBuy.setBounds(94, 765, 240, 54);
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changepage5();

				}
			});
			btnBuy.setIcon(icon);
		}
		return btnBuy;
	}

	// 화면하단 사업자텍스트 노출
	private JLabel getLbltext() {
		if (lbltext == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/text.png");
			lbltext = new JLabel("");
			lbltext.setBounds(34, 830, 346, 48);
			lbltext.setIcon(icon);
		}
		return lbltext;
	}

	// 구메로 들어간 상품 보여주는 테이블
	public JTable getInnertable() {
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

	private JLabel getLbllong() {
		if (lbllong == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/assets/Rectangle.png");
			lbllong = new JLabel("");
			lbllong.setBounds(0, 0, 428, 20);
			lbllong.setIcon(icon);
		}
		return lbllong;
	}

	// -------Function------------------------------------------------------------------------------------------------------------------------
	// outTable 최초 구성기능
	private void tableInit() {
		outerTable.addColumn("제품사진");
		outerTable.addColumn("상품명");
		outerTable.addColumn("금액");
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

	// 실행시 테이블 내용
	private void searchAction() {
		DaoBuy dao = new DaoBuy("c.coname", this.selectedName);
		ArrayList<DtoBuy> dtoList = dao.conditionList();
		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			// tfpcs.setText("1");

			// tfPrice.setText(Integer.toString(dtoList.get(i).getCsprice()));
			tfAllPrice.setText(Integer.toString(dtoList.get(i).getCsprice()));
			this.price = dtoList.get(i).getCsprice();
			ImageIcon icon = new ImageIcon(dtoList.get(i).getCopic());
			Object[] qTxt = { icon, dtoList.get(i).getConame(), Integer.toString(dtoList.get(i).getCsprice()) };
			outerTable.addRow(qTxt);
			cs_coid2 = dtoList.get(i).getCoid();
			csprice2 = dtoList.get(i).getCsprice();
		}

	}

	// 버튼눌렀을때 뒤로가리 페이지 이동하는 기능
	private void changepage() {
		setVisible(false);
		Buy1 buy1 = new Buy1();
		buy1.setVisible(true);

	}

	// 구매버튼을 눌렀을 때 해당 데이터를SQL 데이터 베이스에 입력하면서 구매완료 페이자로 넘어가눈 기능
	private void changepage5() {
		DaoBuy dao = new DaoBuy(csprice2, cs_coid2);
		dao.changepage2();
		setVisible(false);
		Buy4 buy4 = new Buy4();
		buy4.setVisible(true);
		System.out.println(cs_coid2);
	}

	private void changepage2() {
		setVisible(false);
		MainView mainview = new MainView();
		mainview.setVisible(true);
	}

	public void setColor(Color color) {
		contentPane.setBackground(color);
	}

	public void setName(String name) {
		lblName.setText(name);
	}

	// ...
}

// End----------------------------------------------------------------------------------------------------------------------------
