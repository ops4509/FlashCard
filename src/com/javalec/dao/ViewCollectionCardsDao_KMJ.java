package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.base.ViewCollectionMain;
import com.javalec.dto.ViewCollectionCardsDto_KMJ;
import com.javalec.util.ShareVar;


public class ViewCollectionCardsDao_KMJ {
	//field
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	String uid;
	//constructor
	public ViewCollectionCardsDao_KMJ() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//method
	public ArrayList<ViewCollectionCardsDto_KMJ> userCard(){
		ArrayList<ViewCollectionCardsDto_KMJ> dtoList = new ArrayList<ViewCollectionCardsDto_KMJ>();
		String cid;
		//아이디를 가져와야 한다.
		String where = "select c.cid from card c, handle h where h.h_uid = 'ajw2002' and h.h_cid = c.cid";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			Statement stmt_mysql1 = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(where);
			
			while(rs.next()) {
				cid = rs.getString(1);
				String where1 = "select ccontents, canswer from card where cid = '"+cid+"'";
				ResultSet rs1 = stmt_mysql1.executeQuery(where1);
				while(rs1.next()) {
					String ccontents = rs1.getString(1);
					String canswer = rs1.getString(2);
					
					ViewCollectionCardsDto_KMJ dto = new ViewCollectionCardsDto_KMJ(ccontents, canswer);
					dtoList.add(dto);
				}
			}
			
			

			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
	public ArrayList<ViewCollectionCardsDto_KMJ> payCard(){
		ArrayList<ViewCollectionCardsDto_KMJ> dtoList = new ArrayList<ViewCollectionCardsDto_KMJ>();
		//ViewCollectionMain.colName
		String coid;
		String where = "select coid from collection where coname = '"+ViewCollectionMain.colName+"'";
		System.out.println(ViewCollectionMain.colName);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			Statement stmt_mysql1 = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where);
			
			while(rs.next()) {
				coid = rs.getString(1);
				String where1 = "select mcontents, manswer from make where m_coid = '" +coid+"'";
				ResultSet rs1 = stmt_mysql1.executeQuery(where1);
				while(rs1.next()) {
					String ccontents = rs1.getString(1);
					String canswer = rs1.getString(2);
					
					ViewCollectionCardsDto_KMJ dto = new ViewCollectionCardsDto_KMJ(ccontents, canswer);
					dtoList.add(dto);
					
				}
				
			}
			

			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
}
