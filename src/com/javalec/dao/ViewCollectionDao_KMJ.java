package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.ViewCollectionDto_KMJ;
import com.javalec.util.ShareVar;

public class ViewCollectionDao_KMJ {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String uid, coid;
	
	public ViewCollectionDao_KMJ() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ViewCollectionDao_KMJ(String uid, String coid) {
		super();
		this.uid = uid;
		this.coid = coid;
	}



	public ArrayList<ViewCollectionDto_KMJ> selectAction(){
		ArrayList<ViewCollectionDto_KMJ> dtoList = new ArrayList<ViewCollectionDto_KMJ>();
		String whereDefault = "select c.coname from collection c, buy b where c.coid = b.b_coid and b.b_uid = '"+ uid + "' and b.b_coid = '" + coid+"'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
			while(rs.next()) {
				String wkConame = rs.getString(1);
	
				
				ViewCollectionDto_KMJ dto = new ViewCollectionDto_KMJ(wkConame);
				dtoList.add(dto);
			}

			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
}
