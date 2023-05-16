package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javalec.dto.DtoUser_OKH;
import com.javalec.dto.Dto_yj;
import com.javalec.util.ShareVar;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class DaoUser_OKH {
	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	// Fields
	String uid;
	String upw;
	String uname;
	String uphone;
	String uemail;

	// Constructor
	public DaoUser_OKH() {
		// TODO Auto-generated constructor stub
	}

	public DaoUser_OKH(String uid) {
		super();
		this.uid = uid;
	}

	public DaoUser_OKH(String uid, String upw, String uname, String uphone, String uemail) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphone = uphone;
		this.uemail = uemail;
	}

	// Method

	// Mypage 불러오기

	public ArrayList<DtoUser_OKH> selectUserinfo() {
		ArrayList<DtoUser_OKH> dtoList = new ArrayList<DtoUser_OKH>();

		String query = "SELECT uid, upw, uname, "
				+ " left(uphone,3), mid(uphone, 5, 4), right(uphone, 4),"
				+ " SUBSTRING_INDEX(uemail, '@', 1), SUBSTRING_INDEX(uemail, '@', -1) " 
				+ " FROM flashcard.user";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			PreparedStatement pstmt = conn_mysql.prepareStatement(query);
	        ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(ShareVar.u_id)) {
					String uid = rs.getString(1);
					System.out.println(1+uid);
					String upw = rs.getString(2);
					System.out.println(2+upw);
					String uname = rs.getString(3);
					System.out.println(3+uname);
					String uphonef = rs.getString(4);
					System.out.println(4+uphonef);
					String uphonem = rs.getString(5);
					System.out.println(5+uphonem);
					String uphoneb = rs.getString(6);
					System.out.println(6+uphoneb);
					String uemailf = rs.getString(7);
					System.out.println(7+uemailf);
					String uemailb = rs.getString(8);
					System.out.println(8+uemailb);

					DtoUser_OKH dtouser_okh = new DtoUser_OKH(uid, upw, uname, uphonef, uphonem, uphoneb, uemailf,
							uemailb);
					dtoList.add(dtouser_okh);
				}
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	// updateAction
	public void updateAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			String updateUserQuery = "UPDATE user SET uid = ?, upw = ?, uname = ?, uphone = ?, uemail = ? WHERE uid = ?";
			ps = conn_mysql.prepareStatement(updateUserQuery);
			ps.setString(1, uid.trim());
			System.out.println(1+uid.trim());
			ps.setString(2, upw.trim());
			System.out.println(2+upw.trim());
			
			ps.setString(3, uname.trim());
			System.out.println(3+uname.trim());
			
			ps.setString(4, uphone.trim());
			System.out.println(4+uphone.trim());
			
			ps.setString(5, uemail.trim());
			System.out.println(5+uemail.trim());
			ps.setString(6, uid.trim());
			System.out.println(6+uid.trim());
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// LogoutAction
	public void logoutAction() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			String updateUserQuery = "UPDATE ulogin SET ullogoutdate = now() WHERE ul_uid = ? AND ullogoutdate IS NULL";
			ps = conn_mysql.prepareStatement(updateUserQuery);
			ps.setString(1,ShareVar.u_id);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
