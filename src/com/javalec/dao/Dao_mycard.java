package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import com.javalec.dto.Dto_handle;
import com.javalec.dto.Dto_make;
import com.javalec.base.Mycard_01main;
import com.javalec.dto.Dto_card;
import com.javalec.util.ShareVar;
import com.mysql.cj.ParseInfo;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Dao_mycard {
	
	
	
	
	// -------------------field ----------------------------
	
	String uid;
	ArrayList<String> ucl;  //user card list 유저가 만든 카드의 카드아이디리스트.
	
	int A; // 유저의 카드 아이디 목록 배열과, 유저의 콜렉션 리스트 목록을 구분하기 위한더미변수.
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	Mycard_01main main01 = new Mycard_01main();
	String viewCid = main01.select_ci;
	String user_SampleID = ShareVar.UserSampleId;
	
	
	
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


public ArrayList<Dto_card> getUcView(String ucid){
	ArrayList<Dto_card> tempDto = new ArrayList<Dto_card>();
	int tempcid =Integer.parseInt(ucid.substring(2));
	System.out.println("카드아이디 짜른"+ucid.substring(2));

	
	// 받아오고 넘겨주는 데이터 순서는 contents / answer / (collection) / title / genre / cid 
	// 메인페이지에서 넘긴 카드아이디의 상태에 따라서, 카드테이블에 갈지, make & collection 테이블에 갈지 결정함.
	if(ucid.substring(0,2).equals("UC")) {
		//card 에서 데이터 받아오는
		String sql_01 = "Select ccontents, canswer, ctitle, cgenre from card where cid = " + tempcid;
		

		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt = conn_mysql.createStatement();
			
		
				ResultSet rs = stmt.executeQuery(sql_01);
				
				while(rs.next()) {
					String wkcontents = rs.getString(1);
					String wkanswer  = rs.getString(2);
					String wktitle   = rs.getString(3);
					String wkgenre   = rs.getString(4);
					
					System.out.println("컨텐츠내"+wkcontents);
					Dto_card dto = new Dto_card(wkcontents, wkanswer, viewCid+ "의 콜렉션", wktitle, wkgenre );
					tempDto.add(dto);
			
				} 
				conn_mysql.close();

		
		}catch (Exception e) {
			e.printStackTrace();
		}//try 문 .
		
		
		
	}else if(ucid.substring(0,2).equals("CC")) {
		//make에서 데이터 받아오는 문구가 01번.    collection 테이블에서 coname 받아오는게 02
		//1번 문구로 make 테이블에서 정보들 받아옴 (m_coid 도 받아옴)
		
		//그다음에 2번 문구로 collection 테이블에 들어가, Dto 형식 완성 시키자.
		
		String tempColName ="";
		String sql_01 = "Select mcontents, manswer, mtitle, mgenre,m_coid from make where mid = " + tempcid;
		String sql_02 = "Select coname from collection where coid = '";
		String sql_02_01 = "'";
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			
			Statement stmt2 = conn_mysql.createStatement();
			
			
			ResultSet rs2 = stmt2.executeQuery(sql_01);
				
			while(rs2.next()) {
				String wkcontents = rs2.getString(1);
				String wkanswer  = rs2.getString(2);
				String wktitle   = rs2.getString(3);
				String wkgenre   = rs2.getString(4);
				String tempMid = rs2.getString(5);
				System.out.println("컨텐츠내"+wkcontents);

				Statement stmt = conn_mysql.createStatement();
				ResultSet rs = stmt.executeQuery(sql_02 + tempMid +sql_02_01);
				
				while(rs.next()) {
					tempColName = rs.getString(1);
				
				} 


					
				Dto_card dto = new Dto_card(wkcontents, wkanswer, tempColName, wktitle, wkgenre );
				tempDto.add(dto);
			}

				
				
				conn_mysql.close();

		
		}catch (Exception e) {
			e.printStackTrace();
		}//try 문 .
		
		
		
				
	}
	

	return tempDto;
}


// -------------------user card insert ---------------

public void usercardInsert(String title,String genre,String contents,String answer) {
	
	PreparedStatement ps = null;
	PreparedStatement ps2 = null;

	int tempcid = 0 ; //입력한 카드의 마지막 번호를 가져와서 저장하는 변수.
	

	//String sql_02
	
	try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mcol_sql = conn_mysql.createStatement();
		String sql_01 ="insert into Card (ctitle,cgenre,ccontents,canswer) values (?,?,?,?)";
		//String sql_01_02 = "LAST_INSERT_ID();";
		
		
		ps = conn_mysql.prepareStatement(sql_01,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, title.trim());
		ps.setString(2, genre.trim());
		ps.setString(3, contents.trim());
		ps.setString(4, answer.trim());
		
		ps.executeUpdate();

		
		ResultSet rs = ps.getGeneratedKeys();
		while(rs.next()) {
			tempcid = rs.getInt(1);
		}
			
		String sql_02 ="insert into handle (h_uid,h_cid,hstatus,hregdate) values (?,?,?,now())";
	
		
		System.out.println("임시 카드 아이디 : " +tempcid);
		
		ps2 = conn_mysql.prepareStatement(sql_02);
		ps2.setString(1, user_SampleID.trim());
		ps2.setInt(2, tempcid);
		ps2.setInt(3, 1);
	
		
		ps2.executeUpdate();

		
		conn_mysql.close();

	
	}catch (Exception e) {
		e.printStackTrace();
	
	}//try 문 .
	
	/*
	try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		Statement stmt_mcol_sql = conn_mysql.createStatement();
		String sql_01 ="insert into handle (h_uid,h_cid,h_status,hregdate) values (?,?,?,now())";
	
		
		System.out.println("임시 카드 아이디 : " +tempcid);
		ps = conn_mysql.prepareStatement(sql_01);
		ps.setString(1, viewCid.trim());
		ps.setInt(2, tempcid);
		ps.setInt(3, 1);
	
		
		ps.executeUpdate();
		
		
		conn_mysql.close();

	
	}catch (Exception e) {
		e.printStackTrace();
	}*/
	
	
	
}//usercardInser 종 







}//Dao_mycard 엔드게임