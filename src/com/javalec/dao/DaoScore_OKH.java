package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javalec.util.ShareVar;

public class DaoScore_OKH {
	// Fields
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	String s_uid;
	String s_coid;
	int s_mid;

	// Constructor
	public DaoScore_OKH() {
		// TODO Auto-generated constructor stub
	}

	public DaoScore_OKH(String s_uid, String s_coid, int s_mid) {
		super();
		this.s_uid = s_uid;
		this.s_coid = s_coid;
		this.s_mid = s_mid;
	}

	// Method

	// insertScore
	public void insertScoreCorrect() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "INSERT INTO score (s_uid, s_coid, s_mid, sdate, scorrect) " 
					+ "VALUES (?, ?, ?, now(), 0) "
					+ "ON DUPLICATE KEY UPDATE sdate=now(), scorrect=0";
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, s_uid);
			ps.setString(2, s_coid);
			ps.setInt(3, s_mid);

			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertScoreIncorrect() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "INSERT INTO score (s_uid, s_coid, s_mid, sdate, scorrect) " 
					+ "VALUES (?, ?, ?, now(), 1) "
					+ "ON DUPLICATE KEY UPDATE sdate=now(), scorrect=1";
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, s_uid);
			ps.setString(2, s_coid);
			ps.setInt(3, s_mid);

			ps.executeUpdate();

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//	오답노트 문제 수량 가져오기
	
	public int getCorrectCount() {
	    PreparedStatement ps = null;
	    int count = 0;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        String query = "SELECT COUNT(*) FROM score WHERE scorrect = 1";
	        ps = conn_mysql.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}


}
