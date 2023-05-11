package com.javalec.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.javalec.dto.DtoCollection_OKH;
import com.javalec.dto.DtoMake_OKH;
import com.javalec.util.ShareVar;

public class DaoMake_OKH {
	// Fields

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	int mid;
	int cocount;
	String uid;
	String coid;
	String mtitle;
	String mgenre;
	String mcontents;
	String manswer;

	// Constructor
	public DaoMake_OKH() {
		// TODO Auto-generated constructor stub
	}

	public DaoMake_OKH(String uid, String coid) {
		super();
		this.uid = uid;
		this.coid = coid;
	}

	public DaoMake_OKH(String coid) {
		super();
		this.coid = coid;
	}

	// Mehtod

	// SelectionMake

//	public ArrayList<DtoMake_OKH> selectMake() {
//		PreparedStatement ps = null;
//		ArrayList<DtoMake_OKH> dto = new ArrayList<DtoMake_OKH>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
//			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			String query = "select mid, uid, mtitle, mgenre,mcontents, manswer from make";
//
//			ps = conn_mysql.prepareStatement(query);
//
//
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				int mid = rs.getString(1);
//				String uid = rs.getString(2);
//				String uid = rs.getString(3);
//				String wpsize = rs.getString(4);
//				String  = rs.getInt(5);
//
//				dto = new DtoMake_OKH(wpname, wpbrand, wpcolor, wpsize, wpprice);
//			}
//			conn_mysql.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dto;
//
//	}

	// Collection에서 genre 값 가져오기
	public ArrayList<DtoMake_OKH> getgenrecount() {
		PreparedStatement ps = null;
		ArrayList<DtoMake_OKH> dto = new ArrayList<DtoMake_OKH>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "SELECT m.mgenre, COUNT(*)" + " FROM make m, collection co" + " WHERE m.m_coid = co.coid "
					+ " AND co.coid = ?" + " GROUP BY m.mgenre";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, coid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mgenre = rs.getString(1);
				cocount = rs.getInt(2);
			}
			DtoMake_OKH beanList = new DtoMake_OKH(mgenre, cocount);
			dto.add(beanList);

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;

	}

	// 하나의 Collection을 선택해 모든 값의 문제와 히든을 가져오기.

	public ArrayList<DtoMake_OKH> getQuestAns() {
		PreparedStatement ps = null;
		ArrayList<DtoMake_OKH> dto = new ArrayList<DtoMake_OKH>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "select m.manswer, m.mcontents, m.mgenre, m.mtitle" + " from make m, collection co"
					+ " where m.m_coid = co.coid" + " and co.coid = ?";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, "tutor002_001"); // Co-id 넣기

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mcontents = rs.getString(1);
				manswer = rs.getString(2);
				mgenre = rs.getString(3);
				mtitle = rs.getString(4);
				DtoMake_OKH beanList = new DtoMake_OKH(mcontents, manswer, mgenre, mtitle);
				dto.add(beanList);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;

	}
}
