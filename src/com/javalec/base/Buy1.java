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

import com.javalec.daoBuy.DaoBuy;
import com.javalec.dtoBuy.DtoBuy;

public class Buy1 extends JFrame {

	private final DefaultTableModel outerTable = new DefaultTableModel();

	private JPanel contentPane;
	private JLabel lblback;
	private JLabel lblhello;
	private JLabel lblmainLogo;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnsearch;
	private JLabel lbltext;
	private JScrollPane scrollPane;
	private JTable innerTable;

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
		contentPane.add(getLblback());
		contentPane.add(getLblhello());
		contentPane.add(getLblmainLogo());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLbltext());
		contentPane.add(getComboBox());
		contentPane.add(getTextField());
		contentPane.add(getBtnsearch());
		contentPane.add(getScrollPane());
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
			lblhello.setBounds(213, 58, 102, 48);
			lblhello.setIcon(icon);
		}
		return lblhello;
	}

	// 메인로고누르면 홈으로 돌아가는 이미지 넣는
	private JLabel getLblmainLogo() {
		if (lblmainLogo == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/MyCardMainLogo.png");
			lblmainLogo = new JLabel("");
			lblmainLogo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					MainView main = new MainView();
					main.setVisible(true);
					dispose();
				}
			});
			lblmainLogo.setBounds(155, 16, 111, 48);
			lblmainLogo.setIcon(icon);
		}
		return lblmainLogo;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("______님");
			lblNewLabel_2.setBounds(327, 58, 61, 16);
		}
		return lblNewLabel_2;
	}

	// 상품검색 할수있게 해주는 콤보박스
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(34, 102, 87, 27);
			comboBox.setModel(new DefaultComboBoxModel(new String[] { "상품명", "금액" }));
		}
		return comboBox;
	}// 검색어를 입력할 수 있는 텍스트필드

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(120, 99, 195, 30);
			textField.setColumns(10);
		}
		return textField;
	}

	// 검색버튼
	private JButton getBtnsearch() {
		if (btnsearch == null) {

			btnsearch = new JButton("검색");
			btnsearch.setBounds(321, 105, 69, 20);

			btnsearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
				}
			});
			btnsearch.setSelected(true);
		}
		return btnsearch;
	}

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
			scrollPane.setBounds(34, 154, 356, 647);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	// 상품목록 페이지
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
					if (me.getClickCount() == 2) {
						JTable target = (JTable) me.getSource();
						int row = target.getSelectedRow();
						int column =target.getSelectedColumn();
						changepage(innerTable.getValueAt(row, 2).toString());

					}
				}
			});

		}
		return innerTable;
	}
	// --Function
	// -------------------------------------------------------------------

	// 다음페이지로 이동
	private void changepage(String selectedName) {

		setVisible(false);
		Buy2 buy2 = new Buy2(selectedName);
		buy2.setVisible(true);
	}

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
		int width = 30;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = innerTable.getColumnModel().getColumn(vColIndex);
		width = 80;
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