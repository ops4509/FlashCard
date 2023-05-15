package com.javalec.base;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoBuy;
import com.javalec.dto.DtoBuy;
import com.javalec.util.ShareVar;

import java.awt.Color;

public class Buy1 extends JFrame {

	private final DefaultTableModel outerTable = new DefaultTableModel();

	private JPanel contentPane;
	private JLabel lblback;
	private JLabel lblhello;
	private JLabel lblmainLogo;
	private JLabel lblName;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnsearch;
	private JLabel lbltext;
	private JScrollPane scrollPane;
	private JTable innerTable;
	private JLabel lbllong;

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
		setBackground(new Color(238, 238, 238));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
				searchAction();
				lblName.setText(ShareVar.u_name+"님!");

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(254, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblback());
		contentPane.add(getLblmainLogo());
		contentPane.add(getLblName());
		contentPane.add(getLblhello());
		contentPane.add(getLbltext());
		contentPane.add(getComboBox());
		contentPane.add(getTextField());
		contentPane.add(getBtnsearch());
		contentPane.add(getScrollPane());
		contentPane.add(getLbllong());
	}

	// 화살표 이미지 넣어야 하는 곳 ( 뒤로가기 버튼 )
	private JLabel getLblback() {
		if (lblback == null) {
			lblback = new JLabel("");
			lblback.setBounds(46, 48, 61, 16);
		}
		return lblback;
	}

	// Hello 이미지 들어간는 곳 ( 라벨이랑 같이 글씨도 노출할 수 있는지 체크할 것
	private JLabel getLblhello() {
		if (lblhello == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/hello.png");
			lblhello = new JLabel("");
			lblhello.setBounds(268, 79, 64, 33);
			lblhello.setIcon(icon);
		}
		return lblhello;
	}

	// 메인로고누르면 홈으로 돌아가는 이미지 넣는
	private JLabel getLblmainLogo() {
		if (lblmainLogo == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/assets/LOGO.png");
			lblmainLogo = new JLabel("");
			lblmainLogo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					changepage3();

				}
			});
			lblmainLogo.setBounds(46, 121, 342, 158);
			lblmainLogo.setIcon(icon);
		}
		return lblmainLogo;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("");
			lblName.setBounds(337, 89, 75, 37);
		}
		return lblName;
	}

	// 상품검색 할수있게 해주는 콤보박스
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(34, 291, 87, 27);
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "상품명", "금액" }));
		}
		return comboBox;
	}// 검색어를 입력할 수 있는 텍스트필드

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(120, 288, 195, 30);
			textField.setColumns(10);
		}
		return textField;
	}

	// 검색버튼
	private JButton getBtnsearch() {
		if (btnsearch == null) {

			btnsearch = new JButton("검색");
			btnsearch.setBounds(321, 294, 69, 20);

			btnsearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			btnsearch.setSelected(true);
		}
		return btnsearch;
	}

	// 화면 하단 사업자텍스트
	private JLabel getLbltext() {
		if (lbltext == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/text.png");
			lbltext = new JLabel("");
			lbltext.setBounds(34, 830, 346, 48);
			lbltext.setIcon(icon);
		}
		return lbltext;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(32, 330, 356, 477);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
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

	// 상품목록 페이지 ( 상품목록애서 선택한 데이터를 가지고 2번 구매페이지로 넘어가는 것 )
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable() {
				public Class getColumnClass(int column) { // <<<<
					return (column == 1) ? Icon.class : Object.class; // 첫번째 열이면 아이콘 클래스, 아니면 오브젝트 클래스로 지정
				}// 테이블의 각 열마다의 데이터 형을 지정 //<<<<
			};
			innerTable.setModel(outerTable);
			innerTable.setRowHeight(150);// 출력할때 글자와 그림의 높이를 맞추기 위해 설정

			innerTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					if (me.getClickCount() == 1) {
						JTable target = (JTable) me.getSource();
						int row = target.getSelectedRow();
						changepage(innerTable.getValueAt(row, 2).toString());
						int column = target.getSelectedColumn();
						JPanel contentPane = new JPanel();
						contentPane.setBackground(Color.WHITE); 

					}
				}
			});

		}
		return innerTable;
	}
	// --Function-------------------------------------------------------------------

	// 콤보박스 검색할 수 있게 해주는 기능
	private void screenPartition() {
		int i = comboBox.getSelectedIndex();
		String conditionQueryColumn = "";
		switch (i) {
		case 0:
			conditionQueryColumn = "c.coname";
			break;
		case 1:
			conditionQueryColumn = "co.csprice";
			break;
		default:
			break;
		}
		tableInit();
		conditionQueryAction(conditionQueryColumn);
	}

	// 콤보박스 검색 후 데이터베이스에서 찾은다음 노출해주는 기능
	private void conditionQueryAction(String conditionQueryColumn) {
		DaoBuy dao = new DaoBuy(conditionQueryColumn, textField.getText());
		ArrayList<DtoBuy> dtoList = dao.conditionList();
		int listCount = dtoList.size();

		for (int i = 0; i < listCount; i++) {
			ImageIcon icon = new ImageIcon(dtoList.get(i).getCopic());
			Object[] qTxt = { dtoList.get(i).getCoid(), icon, dtoList.get(i).getConame(),
					Integer.toString(dtoList.get(i).getCsprice()) };
			outerTable.addRow(qTxt);
		}
	}

	// 다음페이지로 이동
	private void changepage(String selectedName) {
		setVisible(false);
		Buy2 buy2 = new Buy2(selectedName);
		lblName.setText(ShareVar.u_name+"님!");
		buy2.setColor(Color.WHITE);
	    buy2.setName(ShareVar.u_name+"님!");
		//	JPanel contentPane = new JPanel();
	//	contentPane.setBackground(Color.WHITE); 
		buy2.setVisible(true);
	}

	// 메인로고 클릭시 홈으로 돌아갈수 있는 기능 ( 아직 메인 페이지 구축전이라서 매소드만 만들어
	private void changepage3() {
		setVisible(false);
		MainView mainview = new MainView();
		mainview.setVisible(true);
	}

	// 최초 테이블 outTable 구성
	private void tableInit() {
		outerTable.addColumn("튜터ID");
		outerTable.addColumn("카드사진");
		outerTable.addColumn("상품명");
		outerTable.addColumn("금액");
		outerTable.setColumnCount(4);

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

		vColIndex = 3;
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
			ImageIcon icon = new ImageIcon(dtoList.get(i).getCopic());
			Object[] qTxt = { dtoList.get(i).getCoid(), icon, dtoList.get(i).getConame(),
					Integer.toString(dtoList.get(i).getCsprice()) };
			outerTable.addRow(qTxt);

		}

	}
}

// --End----------------------------------------------------------------------------------------