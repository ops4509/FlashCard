package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javalec.util.ShareVar;

public class DaoBuy_OKH {
	// Fields
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	// Constructor

	public DaoBuy_OKH() {
		// TODO Auto-generated constructor stub
	}

	// Method
	public int selectPrice() {
	    int price = 0;
	    PreparedStatement ps = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

	        String selectPriceQuery = "SELECT SUM(bprice) FROM buy where b_uid = ?";
	        ps = conn_mysql.prepareStatement(selectPriceQuery);
	        ps.setString(1, ShareVar.u_id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            price = rs.getInt(1);
	        }

	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return price;
	}

}
