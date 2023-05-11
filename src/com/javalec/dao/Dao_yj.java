package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.sql.Timestamp;

import com.javalec.util.ShareVar;

public class Dao_yj {
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String u_id;			// 유저 아이디
	String u_name;			// 유저 이름
	String u_pw;			// 유저 비밀번호
	String u_email;			// 유저 이메일
	String u_phone;			// 유저 휴대폰
	String u_edate;			// 가입 시간?
	String ullogindate;		// 로그인 시간
	
	public Dao_yj() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Dao_yj(String u_id, String u_name, String u_pw, String u_email, String u_phone, String u_edate) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
		this.u_email = u_email;
		this.u_phone = u_phone;
		this.u_edate = u_edate;
	}

	public Dao_yj(String u_id, String u_pw) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
	}

	public Dao_yj(String ullogindate) {
		super();
		this.ullogindate = ullogindate;
	}

	
	
	public Dao_yj(String u_id, String u_pw, String ullogindate) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.ullogindate = ullogindate;
	}


	// 로그인


	public boolean loginAction() {

		String whereDefault = "select u_id, u_pw from user";
		PreparedStatement ps = null;
		int token=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			
	        Date date = new Date();
	        Timestamp timestamp = new Timestamp(date.getTime());
	        
	        /*
	        String query = "INSERT INTO ulogin (ullogindate) VALUES (?)";
	        ps = conn_mysql.prepareStatement(query);
	        ps.setTimestamp(1, timestamp);
	        */
	        
	        String query = "UPDATE ulogin SET ullogindate = ? WHERE u_id = ?";
	        ps = conn_mysql.prepareStatement(query);
	        ps.setTimestamp(1, timestamp);
	        ps.setString(2, u_id); 
	        
	        ps.executeUpdate();
	        
	        conn_mysql.close();
	        
			
			while (rs.next()) {
					if (rs.getString(1).equals(u_id) && rs.getString(2).equals(u_pw)) {
					token = 1;
					break;
				}
					
			}
			
			// 시간 가져오기
	

			
			if(token == 1) {
				return true;
			}else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	// 회원 가입
	public boolean insertAction() {

		String whereDefault = "select u_id, u_pw from user";

		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Connection conn_mysql1 = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			// Connection conn_mysql1 = DriverManager.getConnection(url_mysql, id_mysql,
			// pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "insert into user (u_id, u_pw, u_name, u_phone, u_email, u_edate)";
			String query1 = " values (?, ?, ?, ?, ?, ?)";
			
			String query2 = "insert into ulogin (ul_uid, ulseq)";
			String query3 = " values (?, ?)";
	
			ps = conn_mysql.prepareStatement(query + query1);
			ps1 = conn_mysql1.prepareStatement(query2 + query3);
		
			
			ps.setString(1, u_id.trim());
			ps.setString(2, u_pw.trim());
			ps.setString(3, u_name.trim());
			ps.setString(4, u_phone.trim());
			ps.setString(5, u_email.trim());
			ps.setString(6, u_edate.trim());

		
			ps1.setString(1, u_id.trim());
			ps1.setInt(2, 0);
		
			
			ps.executeUpdate();
			ps1.executeUpdate();
		

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public boolean tutorAction() {

		String whereDefault = "select t_id, t_pw from tutor";
		PreparedStatement ps = null;
		int token = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
			while (rs.next()) {
				
				
				if (rs.getString(1).equals(u_id) && rs.getString(2).equals(u_pw)) {

					token = 1;
				}
			
			}
			
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
}
