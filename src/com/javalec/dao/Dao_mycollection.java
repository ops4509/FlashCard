package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.Dto_card;
import com.javalec.dto.Dto_buy;
import com.javalec.util.ShareVar;

public class Dao_mycollection {

	
	String uid;
	String coid;
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	
	
	
	
	
	
	
	
	
	
	// constructor
	public Dao_mycollection(String uid, String coid) {
		super();
		this.uid = uid;
		this.coid = coid;
	}


	public Dao_mycollection(String uid) {
		super();
		this.uid = uid;
	}
	
	
	
	//method
	
	public ArrayList<Dto_buy> my_col_list() {
		
		ArrayList<Dto_buy> mcolList = new ArrayList<Dto_buy>(); // 리턴받을 리스트
		
		String search_mcol_sql = "select distinct b_coid from buy where b_uid = '" + uid +"'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mcol_sql = conn_mysql.createStatement();
			ResultSet rs_mcol_sql = stmt_mcol_sql.executeQuery(search_mcol_sql);
			
			
			while (rs_mcol_sql.next()) {
				String collectionid = rs_mcol_sql.getString(1);
		
				Dto_buy dtocolidlist = new Dto_buy(collectionid);
				mcolList.add(dtocolidlist);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return mcolList;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//Dao_mycollection 의  endgame
