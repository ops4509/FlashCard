package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.Dto_handle;
import com.javalec.dto.Dto_make;
import com.javalec.dto.Dto_card;
import com.javalec.util.ShareVar;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Dao_mycard {
	
	
	
	
	// -------------------field ----------------------------
	
	String uid;
	ArrayList<String> ucl;  //user card list 유저가 만든 카드의 카드아이디리스트.
	int A; // 유저의 카드 아이디 목록 배열과, 유저의 콜렉션 리스트 목록을 구분하기 위한더미변수.
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	
	// 컨스트럭터
	public Dao_mycard () {
		
	}
	
	public Dao_mycard(String uid) {
		super();
		this.uid = uid;
		
	}
	
	public Dao_mycard(ArrayList<String> ucl) {
		super();
		this.ucl = ucl;
		
	}

	public Dao_mycard(int A, ArrayList<String> ucl) {
		super();
		this.ucl = ucl;
		this.A=A;
		
	}




//  ------------------------- 메쏘드--------------------- 


	
	
	
	
	
	
	
	

	
	
	
	// Card 테이블에서 내가만든 단어카드의 cid목록 가져오기
	// Mycard_01main >>> makeTempTable 메쏘드 에서 첫번째로 실행하는 기능.
	


public ArrayList<Dto_handle> my_card_list(){
	
	
	ArrayList<Dto_handle> mcList = new ArrayList<Dto_handle>(); // 리턴받을 리스트
	
	String search_mc_sql = "select h_cid from handle where h_uid = '" + uid +"'";
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mc_sql = conn_mysql.createStatement();
		ResultSet rs_mc_sql = stmt_mc_sql.executeQuery(search_mc_sql);
		
		
		while (rs_mc_sql.next()) {
			int cardid = rs_mc_sql.getInt(1);
			System.out.println(cardid);
			
			Dto_handle dtocilist = new Dto_handle(cardid);
			mcList.add(dtocilist);
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return mcList;
}
	



	
// mycard_01main의 테이블에 들어갈 내용 받아오기위한 메쏘드.
//handle 들어가서 내가 만든 card	 들의 cid	 리스트 만들기.
//위에서 받아온 cid들로 Card 테이블에 들어가서 , 정보들 받아오기. 
	
private ArrayList<Dto_card> select_Card_List(){
	ArrayList<Dto_card> dscList = new ArrayList<Dto_card>(); // 리턴받을 리스트 가져옴.
	
	
	//handle 들어가서 내가 만든 card	 들의 cid	 리스트 만들기.
	String enter_handle = "select hseq, h_uid, h_cid from handle where h_uid = " + uid;
	
	
	
	
	
	//위에서 받아온 cid들로 Card 테이블에 들어가서 , 정보들 받아오기.
	// 앞,(   ), 컬렉션명 , 
	String mycard_sql = "select contents,  from card where " ;
	
	
	
	
	//위에서 받아온 cid들로 hidden 테이블에 들어가서 히든 값 받아오기.
	
	
	

	
	
	
	//받은 Card들의 목록을 필요한 형태로 저장해서 넘기기. 리스트 첫열은 체크박스 들어갈 자리. 일단 77으로 입력.
	// (77,콜렉션명, 
	
	
	
	
	return dscList;
	
	}




public ArrayList<Dto_card> userCardList(){
	ArrayList<Dto_card> tempDto =new ArrayList<Dto_card>();
	int ucl_size = ucl.size();
	
	
	//유저의 cardid 목록으로 card 테이블에서 다음의 순서로 정보들을 받아오기. 
	//contents / title / genre
	String sql_01 = "select cid, ccontents, canswer, ctitle, cgenre from card where cid = '" ;
	String sql_02 = "'";
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mcol_sql = conn_mysql.createStatement();
		
		
		for (int i=0;i<ucl_size;i++) {
			int temp_cardId = Integer.parseInt(ucl.get(i));
			
			ResultSet rs = stmt_mcol_sql.executeQuery(sql_01+ temp_cardId +sql_02);
			
			while(rs.next()) {
				int wkcid = rs.getInt(1);
				String wkcontents = rs.getString(2);
				String wkanswer = rs.getString(3);
				String wktitle = rs.getString(4);
				String wkgenre = rs.getString(5);
				
				//System.out.println(wkcid+"  //  "+wkcontents+"  //  "+wkanswer+"  //  "+wktitle+"  //  "+wkgenre+"  //  ");
				System.out.println("Dto_Card에 들어가기 전의 wkcid 값 : "+wkcid ); 

				Dto_card dto = new Dto_card(wkcid, wkcontents, wkanswer, wktitle, wkgenre);
				
				
				System.out.println("Dto_Card에 들어간 다음 wkcid 값(dto.getCid())로출 : "+dto.getCid() ); 

				//System.out.println(wkcid + "값이어야하는데 실제로 dto에저장된 값은 : "+ dto.getCid()); 
				
				tempDto.add(dto);
				
			}
			
	
		} //try 문 .
		
		conn_mysql.close();

	
	
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	return tempDto;
}

public ArrayList<Dto_make> userColCardList() {
	// TODO Auto-generated method stub
	
	ArrayList<Dto_make> tempDto = new ArrayList<Dto_make>();
	int ucl_size = ucl.size();
	
	//유저의 구매 콜렉션 아이디 목록으로 make 테이블에서 다음의 순서로 정보들을 받아오기. 
		//mid, mcontents/manswer / m_colid(추후 콜렉션명으로 변경예정) / mtitle / mgenre
		String sql_01 = "select mid, mcontents, manswer, m_coid, mtitle, mgenre from make where m_coid = '" ;
		String sql_02 = "'";
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mcol_sql = conn_mysql.createStatement();
			
			
			for (int i=0;i<ucl_size;i++) {
				String temp_colId = ucl.get(i);
				
				ResultSet rs = stmt_mcol_sql.executeQuery(sql_01+ temp_colId +sql_02);
				
				while(rs.next()) {
					int wkcid = rs.getInt(1);
					String wkcontents = rs.getString(2);
					String wkanswer = rs.getString(3);
					String wkcoid = rs.getString(4);
					String wktitle = rs.getString(5);
					String wkgenre = rs.getString(6);
					
					Dto_make dto = new Dto_make(wkcid, wkcontents, wkanswer, wkcoid, wktitle, wkgenre);
					tempDto.add(dto);
					
				}
				
		
			} //try 문 .
			
			conn_mysql.close();

		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return tempDto;
}













}