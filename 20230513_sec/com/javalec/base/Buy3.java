package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ListSelectionModel;

public class Buy3 extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnDelet;
	private JButton btnBuy;
	private JLabel lblNewLabel;
	private JTable innerTable;
	private JLabel lblMainLogo;
	private JLabel lblhello;
	private JLabel lblback;
	private JLabel lbltext;

	private final DefaultTableModel outerTable = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy3 frame = new Buy3();
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
	public Buy3() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableInit();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getBtnDelet());
		contentPane.add(getBtnBuy());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblMainLogo());
		contentPane.add(getLblhello());
		contentPane.add(getLblback());
		contentPane.add(getLbltext());
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 132, 356, 647);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	// 선택삭제 버튼
	private JButton getBtnDelet() {
		if (btnDelet == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/delet.png");
			btnDelet = new JButton("");
			btnDelet.setBounds(73, 801, 117, 29);
			btnDelet.setIcon(icon);
		}
		return btnDelet;
	}

	// 선택 구매버튼
	private JButton getBtnBuy() {
		if (btnBuy == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/buy.png");
			btnBuy = new JButton("");
			btnBuy.setBounds(227, 801, 117, 29);
			btnBuy.setIcon(icon);
		}
		return btnBuy;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("_________님");
			lblNewLabel.setBounds(309, 104, 81, 16);
		}
		return lblNewLabel;
	}

	// 테이블화면
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		return innerTable;
	}

	// 메인 로고 이미지
	private JLabel getLblMainLogo() {
		if (lblMainLogo == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/MyCardMainLogo.png");
			lblMainLogo = new JLabel("");
			lblMainLogo.setBounds(133, 6, 102, 75);
			lblMainLogo.setIcon(icon);
		}
		return lblMainLogo;
	}

	// hell 이미지
	private JLabel getLblhello() {
		if (lblhello == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/hello.png");
			lblhello = new JLabel("");
			lblhello.setBounds(238, 77, 117, 55);
			lblhello.setIcon(icon);
		}
		return lblhello;
	}

	// 뒤로가기 버튼
	private JLabel getLblback() {
		if (lblback == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/back.png");
			lblback = new JLabel("");
			lblback.setBounds(50, 32, 61, 16);
			lblback.setIcon(icon);
		}
		return lblback;
	}

	// 하단 텍스트
	private JLabel getLbltext() {
		if (lbltext == null) {
			ImageIcon icon = new ImageIcon("src/com/javalec/images/text.png");
			lbltext = new JLabel("");
			lbltext.setBounds(34, 842, 356, 50);
			lbltext.setIcon(icon);
		}
		return lbltext;
	}

	// Function-----------------------------------------------------------------------------------------------------

	private void tableInit() {
		outerTable.addColumn("제품사진");
		outerTable.addColumn("금액");
		outerTable.addColumn("수량");
		outerTable.setColumnCount(3);

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
	}
}
