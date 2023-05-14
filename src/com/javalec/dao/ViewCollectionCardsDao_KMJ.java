package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	
	public ViewCollectionCardsDao_KMJ(String uid) {
		super();
		this.uid = uid;
	}



	//method
	public ArrayList<ViewCollectionCardsDto_KMJ> userCard(){
		ArrayList<ViewCollectionCardsDto_KMJ> dtoList = new ArrayList<ViewCollectionCardsDto_KMJ>();
		String cid;
		//아이디를 가져와야 한다.
		String where = "select c.cid from card c, handle h where h.h_uid = ? and h.h_cid = c.cid";
		
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Connection conn_mysql1 = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			ps = conn_mysql.prepareStatement(where);
			ps.setString(1, ShareVar.u_id);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				cid = rs.getString(1);
				String where1 = "select ccontents, canswer from card where cid = ? ";
				ps1 = conn_mysql1.prepareStatement(where1);
				ps1.setString(1, cid);
				ps1.executeQuery();
				ResultSet rs1 = ps1.executeQuery();
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
		String colName = ViewCollectionMain.colName;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		String where = "select coid from collection where coname = ? ";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Connection conn_mysql1 = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			Statement stmt_mysql1 = conn_mysql.createStatement();
			
			ps = conn_mysql.prepareStatement(where);
			ps.setString(1, colName);
			
			ps.executeQuery();
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				coid = rs.getString(1);
				String where1 = "select mcontents, manswer from make where m_coid = ?";
				
				ps1 = conn_mysql1.prepareStatement(where1);
				ps1.setString(1, coid);
				ps1.executeQuery();
				ResultSet rs1 = ps1.executeQuery();
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
