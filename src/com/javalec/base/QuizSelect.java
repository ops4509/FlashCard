package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoCollection_OKH;
import com.javalec.dao.DaoMake_OKH;
import com.javalec.dao.DaoTutor_OKH;
import com.javalec.dto.DtoCollection_OKH;
import com.javalec.dto.DtoMake_OKH;
import com.javalec.dto.DtoTutor_OKH;
import com.javalec.util.ShareVar;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class QuizSelect extends JFrame {

	private JPanel contentPane;
	private JLabel lblHello;
	private JLabel lblLoginname;
	private JButton btnHome;
	private JButton btnBack;
	private JButton btnCorrectionNote;
	private JButton btnLinerquiz;
	private JButton btnSelectionquiz;
	private JScrollPane scrollPane;
	private JTable tableCollection;

	public static String selectedcoid;
	public static int cocount;
	public static int selectmode = 0;

	// table
	private final DefaultTableModel outerTable = new DefaultTableModel();
	ArrayList<DtoCollection_OKH> beanList = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizSelect frame = new QuizSelect();
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
	public QuizSelect() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tableListInit();
				searchAction();
			}
		});
		setTitle("퀴즈 선택");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 428, 926);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblLoginname());
		contentPane.add(getLblHello());
		contentPane.add(getBtnHome());
		contentPane.add(getBtnBack());
		contentPane.add(getBtnCorrectionNote());
		contentPane.add(getBtnLinerquiz());
		contentPane.add(getBtnSelectionquiz());
		contentPane.add(getScrollPane());
	}

	private JLabel getLblHello() {
		if (lblHello == null) {
			lblHello = new JLabel("");
			lblHello.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/hello.png")));
			lblHello.setBounds(241, 82, 65, 34);
		}
		return lblHello;
	}

	private JLabel getLblLoginname() {
		if (lblLoginname == null) {
			lblLoginname = new JLabel(ShareVar.u_name + "님!");
			lblLoginname.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblLoginname.setBounds(311, 89, 75, 38);
		}
		return lblLoginname;
	}

	private JButton getBtnHome() {
		if (btnHome == null) {
			btnHome = new JButton("");
			btnHome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnHome.setBackground(new Color(0, 0, 0, 0));
			btnHome.setBorderPainted(false);
			btnHome.setFocusPainted(false);
			btnHome.setContentAreaFilled(false);
			btnHome.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/101 Logo.png")));
			btnHome.setBounds(167, 27, 101, 48);
		}
		return btnHome;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MainView main = new MainView();
					main.setVisible(true);
					dispose();
				}
			});
			btnBack.setBackground(new Color(0, 0, 0, 0));
			btnBack.setBorderPainted(false);
			btnBack.setFocusPainted(false);
			btnBack.setContentAreaFilled(false);
			btnBack.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/Back.png")));
			btnBack.setBounds(48, 79, 48, 48);
		}
		return btnBack;
	}

	private JButton getBtnCorrectionNote() {
		if (btnCorrectionNote == null) {
			btnCorrectionNote = new JButton("");
			btnCorrectionNote.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					QuizSelect.selectmode =1;
					screenPartition();
					Shortquiz shortquiz = new Shortquiz();
					shortquiz.setVisible(true);
					dispose();
				}
			});
			btnCorrectionNote.setBackground(new Color(0, 0, 0, 0));
			btnCorrectionNote.setBorderPainted(false);
			btnCorrectionNote.setFocusPainted(false);
			btnCorrectionNote.setContentAreaFilled(false);
			btnCorrectionNote
					.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/corrctionnote.png")));
			btnCorrectionNote.setBounds(41, 630, 346, 140);
		}
		return btnCorrectionNote;
	}

	private JButton getBtnLinerquiz() {
		if (btnLinerquiz == null) {
			btnLinerquiz = new JButton("");
			btnLinerquiz.setEnabled(false);
			btnLinerquiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
					Linerquiz linerquiz = new Linerquiz();
					linerquiz.setVisible(true);
					dispose();
				}
			});
			btnLinerquiz.setBackground(new Color(0, 0, 0, 0));
			btnLinerquiz.setBorderPainted(false);
			btnLinerquiz.setFocusPainted(false);
			btnLinerquiz.setContentAreaFilled(false);
			btnLinerquiz
					.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/button_linerquiz.png")));
			btnLinerquiz.setBounds(40, 810, 161, 56);
		}
		return btnLinerquiz;
	}

	private JButton getBtnSelectionquiz() {
		if (btnSelectionquiz == null) {
			btnSelectionquiz = new JButton("");
			btnSelectionquiz.setEnabled(false);
			btnSelectionquiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenPartition();
					Shortquiz shortquiz = new Shortquiz();
					shortquiz.setVisible(true);
					dispose();
				}
			});
			btnSelectionquiz.setBackground(new Color(0, 0, 0, 0));
			btnSelectionquiz.setBorderPainted(false);
			btnSelectionquiz.setFocusPainted(false);
			btnSelectionquiz.setContentAreaFilled(false);
			btnSelectionquiz.setIcon(
					new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/button_selectionquiz.png")));
			btnSelectionquiz.setBounds(226, 810, 161, 56);
		}
		return btnSelectionquiz;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 205, 346, 385);
			scrollPane.setViewportView(getTableCollection());
		}
		return scrollPane;
	}

	private JTable getTableCollection() {
		if (tableCollection == null) {
			tableCollection = new JTable() {
				// 가장 중요한 부분!
				public Class getColumnClass(int column) { // <<<
					return (column <= 0) ? Icon.class : Object.class; // <<<
				}
			};
			tableCollection.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					outerTable.setRowCount(0);  // 검색기능이 구현 되었을때 가
					tableClick(); // Row 선택하는 것. 정보를 주어야한다.
					screenPartition(); // 버튼이 불가능하게 만들어야한다.
				}
			});
			// Table의 목록은 다 원래 오브젝트, 그래서 Icon을 명시해줌.

			tableCollection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tableCollection.setModel(outerTable);
			tableCollection.setRowHeight(150);

		}
		return tableCollection;
	}

	// function

	// Search Action
	private void searchAction() {
		DaoCollection_OKH daoCollection_OKH = new DaoCollection_OKH();
		ArrayList<DtoCollection_OKH> dtoCollect = daoCollection_OKH.selectCo();

		int listCount = dtoCollect.size();

		for (int j = 0; j < listCount; j++) {
			DaoMake_OKH daoMake_OKH = new DaoMake_OKH(dtoCollect.get(j).getCoid());
			ArrayList<DtoMake_OKH> dtogenre = daoMake_OKH.getgenrecount();
			DaoTutor_OKH daoTutor_OKH = new DaoTutor_OKH(dtoCollect.get(j).getCoid());
			ArrayList<DtoTutor_OKH> dtotname = daoTutor_OKH.tutorname();

			ImageIcon coPic = new ImageIcon("./" + dtoCollect.get(j).getCopath());
			String coName = dtoCollect.get(j).getConame();
			String mGenre = dtogenre.get(0).getMgenre();
			String tname = dtotname.get(0).getTname();
			cocount = dtogenre.get(0).getCocount();
			String cocode = dtoCollect.get(j).getCoid();
			Object[] tempData = { coPic, coName, tname, mGenre, cocount, cocode };
			outerTable.addRow(tempData);
		}

	}

	// input 제한
	private void screenPartition() {
		if (tableCollection.getSelectedRow() >= 0) {
			btnLinerquiz.setEnabled(true);
			btnSelectionquiz.setEnabled(true);
		}
	}

	// tableList 정리
	private void tableListInit() {
		outerTable.addColumn("사진");
		outerTable.addColumn("이름");
		outerTable.addColumn("선생님");
		outerTable.addColumn("장르");
		outerTable.addColumn("퀴즈 갯수");
		outerTable.addColumn("code");

		outerTable.setColumnCount(6);

		int i = outerTable.getRowCount();

		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}

		tableCollection.setAutoResizeMode(tableCollection.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = tableCollection.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);

		vColIndex = 1;
		col = tableCollection.getColumnModel().getColumn(vColIndex);
		width = 69;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = tableCollection.getColumnModel().getColumn(vColIndex);
		width = 69;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = tableCollection.getColumnModel().getColumn(vColIndex);
		width = 69;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = tableCollection.getColumnModel().getColumn(vColIndex);
		width = 69;
		col.setPreferredWidth(width);

		vColIndex = 5;
		col = tableCollection.getColumnModel().getColumn(vColIndex);
		width = 1;
		col.setPreferredWidth(width);

	}

	// table click
	private void tableClick() {
		int i = tableCollection.getSelectedRow();
		selectedcoid = (String) tableCollection.getValueAt(i, 5);
	}

	
}
