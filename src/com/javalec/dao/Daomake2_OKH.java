package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.javalec.dto.DtoMake_OKH;
import com.javalec.util.ShareVar;

public class Daomake2_OKH {
	// Fields

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	int cocount;
	int mid;
	String uid;
	String coid;
	String mtitle;
	String mgenre;
	String mcontents;
	String manswer;

	// Constructor
	public Daomake2_OKH() {
		// TODO Auto-generated constructor stub
	}

	public Daomake2_OKH(String mcontents, String manswer) {
		super();
		this.mcontents = mcontents;
		this.manswer = manswer;
	}

	// Mehtod

	// 정답 유무 체크하기
	public boolean checkAnswer() {
		boolean check = false;
		try (Connection conn = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql)) {
			String query = "SELECT mid FROM make WHERE mcontents=? AND manswer=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, mcontents);
			ps.setString(2, manswer);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				check = true;
			}
			System.out.println(check);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return check;
	}
}
