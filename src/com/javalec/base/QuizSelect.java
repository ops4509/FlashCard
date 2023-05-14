package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javalec.dao.DaoCollection_OKH;
import com.javalec.dao.DaoMake_OKH;
import com.javalec.dao.DaoScore_OKH;
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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class QuizSelect extends JFrame {

	private JPanel contentPane;
	private JLabel lblHello;
	private JLabel lblLoginname;
	private JButton btnHome;
	private JButton btnBack;
	private JButton btnCorrectionNote;
	private JButton btnSelectionquiz;
	private JScrollPane scrollPane;
	private JTable tableCollection;

	public static String selectedcoid;
	public static int cocount;
	public static int selectmode = 0;

	// table
	private final DefaultTableModel outerTable = new DefaultTableModel();
	ArrayList<DtoCollection_OKH> beanList = null;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox cbSelection;
	private JTextField tfInsert;
	private JButton btnSearch;

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
		contentPane.add(getScrollPane());
		contentPane.add(getLblNewLabel());
		contentPane.add(getBtnCorrectionNote());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnSelectionquiz());
		contentPane.add(getCbSelection());
		contentPane.add(getTfInsert());
		contentPane.add(getBtnSearch());
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
					// selectmode 들어가기전에 확인을 해줘야한다.
					// 오답 할게 있는지 없는지.
					// 오답노트는 selectmode =1;
					corrcttioncount();

				}
			});
			btnCorrectionNote.setBackground(new Color(0, 0, 0, 0));
			btnCorrectionNote.setBorderPainted(false);
			btnCorrectionNote.setFocusPainted(false);
			btnCorrectionNote.setContentAreaFilled(false);
			btnCorrectionNote.setIcon(
					new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/correctionquizbutton.png")));
			btnCorrectionNote.setBounds(40, 630, 345, 110);
		}
		return btnCorrectionNote;
	}

	private JButton getBtnSelectionquiz() {
		if (btnSelectionquiz == null) {
			btnSelectionquiz = new JButton("");
			btnSelectionquiz.setEnabled(false);
			btnSelectionquiz.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Shortquiz.qseq != 0) {
						Warningquiz warningquiz = new Warningquiz();
						warningquiz.setVisible(true);
					} else {
						Shortquiz shortquiz = new Shortquiz();
						shortquiz.setVisible(true);
						setVisible(false);
					}
				}
			});
			btnSelectionquiz.setBackground(new Color(0, 0, 0, 0));
			btnSelectionquiz.setBorderPainted(false);
			btnSelectionquiz.setFocusPainted(false);
			btnSelectionquiz.setContentAreaFilled(false);
			btnSelectionquiz.setIcon(
					new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/correctionquizbutton.png")));
			btnSelectionquiz.setBounds(40, 756, 345, 110);
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

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("오답 노트");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 56));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setBounds(40, 630, 345, 110);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("단답형 퀴즈");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(Color.GREEN);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 56));
			lblNewLabel_1.setBounds(40, 756, 345, 110);
		}
		return lblNewLabel_1;
	}

	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.setModel(new DefaultComboBoxModel(new String[] { "이름", "선생님", "장르" }));
			cbSelection.setBounds(115, 175, 101, 18);
		}
		return cbSelection;
	}

	private JTextField getTfInsert() {
		if (tfInsert == null) {
			tfInsert = new JTextField();
			tfInsert.setBounds(228, 175, 130, 18);
			tfInsert.setColumns(10);
		}
		return tfInsert;
	}

	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					findAction();
				}
			});
			btnSearch.setIcon(new ImageIcon(QuizSelect.class.getResource("/com/javalec/assets/search.png")));
			btnSearch.setBounds(370, 175, 18, 18);
		}
		return btnSearch;
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
		width = 59;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = tableCollection.getColumnModel().getColumn(vColIndex);
		width = 79;
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

	// 오답노트 count가져오기
	private void corrcttioncount() {
		DaoScore_OKH daoScore_OKH = new DaoScore_OKH();
		int count = daoScore_OKH.getCorrectCount();
		if (count != 0) {
			cocount = count;
			Shortquiz.score = 0;
			selectmode = 1;
			Shortquiz shortquiz = new Shortquiz();
			shortquiz.setVisible(true);
			setVisible(false);
		} else {
			Warningcorrection warningcorrection = new Warningcorrection();
			warningcorrection.setVisible(true);
		}

	}

	// 검색기능
	private void findAction() {
		String selection = tfInsert.getText();
		int i = cbSelection.getSelectedIndex();
		System.out.println(i);
		String conditionQueryColumn = "";

		switch (i) {
		case 0:
			conditionQueryColumn = "co.coname";
			break;
		case 1:
			conditionQueryColumn = "t.tname";
			break;
		case 2:
			conditionQueryColumn = "m.mgenre";
			break;
		default:
			break;
		}

		tableListInit();
		DaoCollection_OKH daoCollection_OKH = new DaoCollection_OKH(conditionQueryColumn, selection);
		ArrayList<DtoCollection_OKH> dtoCollect = daoCollection_OKH.conditionfindaction();

		int listCount = dtoCollect.size();

		for (int j = 0; j < listCount; j++) {
			DaoMake_OKH daoMake_OKH = new DaoMake_OKH(dtoCollect.get(j).getCoid(), conditionQueryColumn, selection);
			ArrayList<DtoMake_OKH> dtogenre = daoMake_OKH.conditionfindaction();
			DaoTutor_OKH daoTutor_OKH = new DaoTutor_OKH(dtoCollect.get(j).getCoid(), conditionQueryColumn, selection);
			ArrayList<DtoTutor_OKH> dtotname = daoTutor_OKH.conditionfindaction();

			ImageIcon coPic = new ImageIcon("./" + dtoCollect.get(j).getCopath());
			String coName = dtoCollect.get(j).getConame();
			System.out.println(coName);
			String mGenre = dtogenre.get(0).getMgenre();
			String tname = dtotname.get(0).getTname();
			cocount = dtogenre.get(0).getCocount();
			String cocode = dtoCollect.get(j).getCoid();
			Object[] tempData = { coPic, coName, tname, mGenre, cocount, cocode };
			outerTable.addRow(tempData);
		}

	}

}
