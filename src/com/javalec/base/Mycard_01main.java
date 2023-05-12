package com.javalec.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.javalec.dao.Dao_mycard;
import com.javalec.dao.Dao_mycollection;
import com.javalec.dto.Dto_card;
import com.javalec.dto.Dto_buy;
import com.javalec.dto.Dto_handle;
import com.javalec.dto.Dto_make;
import com.javalec.util.ShareVar;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mycard_01main extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btn_back;
	private JComboBox cb_genre;
	private JComboBox cb_title;
	private JComboBox cb_collection;
	private JLabel lblNewLabel_2;
	private JButton btn_insert;
	private JButton btn_delete;
	private JButton btn_read;
	private JTextField tf_search;
	private JButton btn_search;
	private JScrollPane scrollPane;
	private JTable mc_innertable;
	
	//ArrayList<ArrayList<ArrayList<string>>> tempUserTable =new ArrayList<>();
	
	private final DefaultTableModel outerTable = new DefaultTableModel();

	
	String user_SampleID = ShareVar.UserSampleId; //로그인한 유저의 ID를 SV에서 불러오기 
	String user_SampleName = ShareVar.UserSampleName;  //로그인한 유저의 이름을 SV에서 불러오기  
	
	

	
	ArrayList<String> user_Collection_list = new ArrayList<>();  //로그인한 유저의 구매한 collection coid 리스트를 임시저장해두
	ArrayList<String> user_Card_list = new ArrayList<>(); // 로그인한 유저의 자작 카드 cid 리스트를 임시저장해두기.
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mycard_01main frame = new Mycard_01main();
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
	public Mycard_01main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				
				
				makeTempTable(); // 로그인한 유저의 기본적인 정보들은 기억해두자.
				//screenPartition();
				
				mc_tableinit();		//테이블안에 목록 넣기. (틀만들기) 
				//mc_searchaction();	//테이블안에 내용 넣기. (내용채워넣)
				mc_searchaction();
			
			
			
			
			
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
		contentPane.add(getBtn_back());
		contentPane.add(getCb_genre());
		contentPane.add(getCb_title());
		contentPane.add(getCb_collection());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getBtn_insert());
		contentPane.add(getBtn_delete());
		contentPane.add(getBtn_read());
		contentPane.add(getTf_search());
		contentPane.add(getBtn_search());
		contentPane.add(getScrollPane());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("<html>비워둘 창로고 들어가야함<br>글씨는 하단에 붙였음.</html>\n");
			lblNewLabel.setBounds(0, 0, 428, 70);
			lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNewLabel.setForeground(new Color(147, 32, 146));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBackground(Color.LIGHT_GRAY);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel( user_SampleName + "  님");
			lblNewLabel_1.setBounds(308, 82, 80, 20);
		}
		return lblNewLabel_1;
	}
	private JButton getBtn_back() {
		if (btn_back == null) {
			btn_back = new JButton("뒤로가기버튼.       ");
			btn_back.setBounds(40, 82, 117, 20);
			btn_back.setHorizontalAlignment(SwingConstants.LEFT);
			btn_back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btn_back;
	}
	private JComboBox getCb_genre() {
		if (cb_genre == null) {
			cb_genre = new JComboBox();
			cb_genre.setBounds(40, 124, 100, 30);
			cb_genre.setModel(new DefaultComboBoxModel(new String[] {"전체"}));
			cb_genre.setToolTipText("과목");
		}
		return cb_genre;
	}
	private JComboBox getCb_title() {
		if (cb_title == null) {
			cb_title = new JComboBox();
			cb_title.setBounds(164, 124, 100, 30);
			cb_title.setModel(new DefaultComboBoxModel(new String[] {"전체"}));
			cb_title.setToolTipText("타이틀");
		}
		return cb_title;
	}
	private JComboBox getCb_collection() {
		if (cb_collection == null) {
			cb_collection = new JComboBox();
			cb_collection.setBounds(288, 124, 100, 30);
			cb_collection.setModel(new DefaultComboBoxModel(new String[] {"전체"}));
			cb_collection.setToolTipText("콜렉션");
		}
		return cb_collection;
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
	private JButton getBtn_insert() {
		if (btn_insert == null) {
			btn_insert = new JButton("내 카드 입력하기");
			btn_insert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
				Mycard_03insert insertmain = new Mycard_03insert();
				insertmain.setVisible(true);
				dispose();
				
				}
			});
			btn_insert.setBounds(40, 780, 90, 50);
			btn_insert.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		}
		return btn_insert;
	}
	private JButton getBtn_delete() {
		if (btn_delete == null) {
			btn_delete = new JButton("내 카드 삭제하기");
			btn_delete.setBounds(169, 780, 90, 50);
			btn_delete.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		}
		return btn_delete;
	}
	private JButton getBtn_read() {
		if (btn_read == null) {
			btn_read = new JButton("내 카드 읽어보기");
			btn_read.setBounds(298, 780, 90, 50);
			btn_read.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		}
		return btn_read;
	}
	private JTextField getTf_search() {
		if (tf_search == null) {
			tf_search = new JTextField();
			tf_search.setBounds(40, 160, 250, 40);
			tf_search.setColumns(10);
		}
		return tf_search;
	}
	private JButton getBtn_search() {
		if (btn_search == null) {
			btn_search = new JButton("검 색");
			btn_search.setBounds(300, 160, 88, 40);
			btn_search.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btn_search;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 210, 348, 560);
			scrollPane.setViewportView(getMc_innertable());
		}
		return scrollPane;
	}
	
	private JTable getMc_innertable() {
		if (mc_innertable == null) {
			mc_innertable = new JTable();
			mc_innertable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					screenPartition();
				}

				
					 
				 
			});
			final ListSelectionModel selectionModel = mc_innertable.getSelectionModel();

			if (selectionModel.getSelectionMode() == ListSelectionModel.SINGLE_SELECTION) {
				 btn_read.setEnabled(true);
			} else {
			    // A버튼 비활성화
			    btn_read.setEnabled(false);
			    
			}

			mc_innertable.setModel(outerTable);
			
			
		}
		return mc_innertable;
	}
	
	

	
	
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------	
	//------------------------------------------------------------------------------------------
	// -------------------------------------Function -------------------------------------------
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------

	
	
	//로그인한 유저의 구매한 [ uid / uname / Collection의 coid 목록 ] / [ 자기가 만든 Card의 cid 목록 ]   
	// [ uid / uname / [tutor003_01, tutor003_02] / [1,2,3,4,5,]]
	//useTempTable 에 저장할거야. 
	
	private void makeTempTable() {  // 로그인한 유저의 기본적인 정보들은 기억해두자.

		

		
		
		
	
		// handle 테이블에서 내가만든 단어카드의 cid목록 가져오기
		
		Dao_mycard mc_list = new Dao_mycard(user_SampleID);
		ArrayList<Dto_handle> mycardlist = mc_list.my_card_list();
		int listcount = mycardlist.size();
		
		for(int i = 0; i<listcount; i++) {
			String temp = Integer.toString(mycardlist.get(i).getH_cid());
			
			
			user_Card_list.add(temp);
			
		}
		System.out.println(user_SampleID +" 가 만든 카드아이디 리스트 : "+ user_Card_list);
		
		
		// buy table 에서 유저가 구매한 collection id 목록 가져오기.
		Dao_mycollection mcol_list = new Dao_mycollection(user_SampleID);
		ArrayList<Dto_buy>  mcollist = mcol_list.my_col_list() ;
		int listcount_col = mcollist.size();

		for(int i = 0; i<listcount_col; i++) {
			String temp = mcollist.get(i).getCoid();
			user_Collection_list.add(temp);
			
		}
		System.out.println(user_SampleID +" 가 구매한 콜렉션 아이디 리스트 : "+ user_Collection_list);
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//테이블안에 콜룸명 넣기. (틀만들기 
	
	
	private void mc_tableinit() {
		outerTable.addColumn("WordId");
		outerTable.addColumn("체크박스 항목");
		outerTable.addColumn("seq");
		outerTable.addColumn("앞면 ");
		outerTable.addColumn("뒷면 ");
		outerTable.addColumn("컬렉션 ");
		outerTable.addColumn("타이틀");
		outerTable.addColumn("장르(과목)");
		outerTable.setColumnCount(8);

		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}

		mc_innertable.setAutoResizeMode(mc_innertable.AUTO_RESIZE_OFF);

		int vColIndex = 0;
		TableColumn col = mc_innertable.getColumnModel().getColumn(vColIndex);
		int width = 30;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = mc_innertable.getColumnModel().getColumn(vColIndex);
		width = 30;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = mc_innertable.getColumnModel().getColumn(vColIndex);
		width = 30;
		col.setPreferredWidth(width);

		vColIndex = 3;
		col = mc_innertable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		vColIndex = 4;
		col = mc_innertable.getColumnModel().getColumn(vColIndex);
		width = 80;
		col.setPreferredWidth(width);

		vColIndex = 5;
		col = mc_innertable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 6;
		col = mc_innertable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);
		
		vColIndex = 7;
		col = mc_innertable.getColumnModel().getColumn(vColIndex);
		width = 40;
		col.setPreferredWidth(width);

		// 1열과 2열 숨기기. 이후 조건부로 2열은 열어줄거임.
		TableColumnModel columnModel = mc_innertable.getColumnModel();
		TableColumn column = columnModel.getColumn(0);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
	
		column = columnModel.getColumn(1);
		column.setMinWidth(0);
		column.setMaxWidth(0);
		column.setWidth(0);
		column.setPreferredWidth(0);
	}
	
	
	
	//테이블안에 내용 넣기. (내용채워넣)
	//user_Card_list 에 있는 카드아이디를 이용해서  카드 테이블에 들어가  내용 받아오기.
	//hidden에 들어가서 hidden 값 받아오기.
	//user_collection_list 에 있는 콜렉션 아이디를 이용해서 콜렉션 테이블 -make 테이블에 들어가 내용 받아오기.
	
	private void mc_searchaction(){
		Dao_mycard dao_ca = new Dao_mycard(user_Card_list);
		ArrayList<Dto_card> dtoList_ca = dao_ca.userCardList();   	//cid/ contents /answer/ title / genre  순서로 유저가 직접만든 단어 카드들이 저장되어있다.   
		System.out.println("첫번재 카드의 카드 아이디 : " + dtoList_ca.get(1).getCid()); 

		
		int listCount = dtoList_ca.size();

		for (int i = 0; i<listCount; i++) {
			String temp = Integer.toString(i+1);
			String temp2 = "Box자리";
			
			//System.out.println(dtoList_ca.get(i).getCid()); 
			
			String[] Ttxt= {Integer.toString(dtoList_ca.get(i).getCid()), temp2, temp, dtoList_ca.get(i).getCcontents(),dtoList_ca.get(i).getCanswer(),user_SampleID,dtoList_ca.get(i).getCtitle(),dtoList_ca.get(i).getCgenre()};		
			System.out.println(Ttxt + "뭐지?");
			outerTable.addRow(Ttxt);
		
		
		}
		
		
		
		
		
		Dao_mycard dao_mk = new Dao_mycard(user_Collection_list);
		ArrayList<Dto_make> dtoList_mk = dao_mk.userColCardList();   	//mid/ contents /answer/ collection 이름 / title / genre  순서로 유저가 직접만든 단어 카드들이 저장되어있다.
		int listCount_mk = dtoList_mk.size();
		
		for (int i = 0; i<listCount_mk; i++) {
			String temp = Integer.toString(i+1);
			String temp2 = "Box자리";
			
			//System.out.println(dtoList_ca.get(i).getCid()); 
			
			String[] Ttxt= {Integer.toString(dtoList_mk.get(i).getMid()), temp2, temp, dtoList_mk.get(i).getMcontents(),dtoList_mk.get(i).getManswer(),user_SampleID,dtoList_mk.get(i).getMtitle(),dtoList_mk.get(i).getMgenre()};		
			System.out.println(Ttxt + "뭐지?");
			outerTable.addRow(Ttxt);
		
		
		}
		
		
		
		
		
		/*
		for (int i = 0; i < listCount; i++) {
			String temp = Integer.toString(dtoList.get(i).getPcode());
			String[] qTxt = { temp, dtoList.get(i).getPname(), dtoList.get(i).getPcolor(), dtoList.get(i).getPbrand(),
					dtoList.get(i).getPsize() };
			outerTable.addRow(qTxt);
		}
		
			*/
	}//mc_S 닫
	
	
	private void screenPartition() {
		int selectedRowCount = mc_innertable.getSelectedRowCount(); // 테이블에서 선택된 로우 숫자.
		if (selectedRowCount==1) {
			btn_delete.setEnabled(true);
			btn_read.setEnabled(true);

			
		}
		
		if (selectedRowCount>1) {
			btn_delete.setEnabled(true);
			btn_read.setEnabled(false);

			
		}
		
		
		
	}

	
	

} //Mycard_01main 의 End Game
