package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.ViewCollectionMainDto_KMJ;
import com.javalec.util.ShareVar;

public class ViewCollectionMainDao_KMJ {
	
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	public ViewCollectionMainDao_KMJ() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ArrayList<ViewCollectionMainDto_KMJ> searchAction(){
		ArrayList<ViewCollectionMainDto_KMJ> dtoList = new ArrayList<ViewCollectionMainDto_KMJ>();
		String whereDefault = "select c.coid, c.coname, c.copicpath, c.copic from collection c, buy b where c.coid = b.b_coid and b.b_uid = ?";//이 uid는 static값의 uid
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ps = conn_mysql.prepareStatement(whereDefault);
			ps.setString(1, ShareVar.u_id);
			
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String wkCoid = rs.getString(1);
				String wkConame = rs.getString(2);
				String wkCopath = rs.getString(3);
				
				File file = new File("./" + wkCopath);
				InputStream input = rs.getBinaryStream(4);
				FileOutputStream output = new FileOutputStream(file);
				
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				
				ViewCollectionMainDto_KMJ dto = new ViewCollectionMainDto_KMJ(wkCoid,wkConame,wkCopath);
				dtoList.add(dto);
			}

			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
}
