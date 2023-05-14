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
import com.mysql.cj.protocol.Resultset;

public class DaoMake_OKH {
	// Fields

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	int cocount;
	int mid;
	int qseq;
	String uid;
	String coid;
	String mtitle;
	String mgenre;
	String mcontents;
	String manswer;

	String selection;
	String conditionQueryColumn;

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

	public DaoMake_OKH(String coid,  String conditionQueryColumn,String selection) {
		super();
		this.coid = coid;
		this.conditionQueryColumn = conditionQueryColumn;
		this.selection = selection;
	}

	// Mehtod

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

	// 조건 검색
	public ArrayList<DtoMake_OKH> conditionfindaction() {
		PreparedStatement ps = null;
		ArrayList<DtoMake_OKH> dto = new ArrayList<DtoMake_OKH>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "SELECT distinct m.mgenre, COUNT(distinct m.mid)" 
					+ " FROM collection co, user u , buy b, tutor t, make m"
					+ " WHERE m.m_coid = co.coid " 
					+ " AND co.coid = ?" 
					+ " AND " + conditionQueryColumn + " LIKE '%" + selection + "%'" 
					+ " GROUP BY m.mgenre";

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
			String query = "SELECT m.manswer, m.mcontents, m.mgenre, m.mtitle, m.mid, m.m_coid"
					+ " FROM make m, collection co" 
					+ " WHERE m.m_coid = co.coid" 
					+ " AND co.coid = ?";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, "tutor002_001"); // Co-id 넣기

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				manswer = rs.getString(1);
				mcontents = rs.getString(2);
				mgenre = rs.getString(3);
				mtitle = rs.getString(4);
				mid = rs.getInt(5);
				qseq = rs.getInt(5);
				DtoMake_OKH beanList = new DtoMake_OKH(manswer, mcontents, mgenre, mtitle, mid, qseq);
				dto.add(beanList);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;

	}

	// 오답노트 모든 값의 문제와 히든을 가져오기.
	public ArrayList<DtoMake_OKH> getCorrectionNote() {
		PreparedStatement ps = null;
		ArrayList<DtoMake_OKH> dto = new ArrayList<DtoMake_OKH>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "SELECT DISTINCT m.manswer, m.mcontents, m.mgenre, m.mtitle, m.mid, m.m_coid"
					+ " FROM make m, collection co, score s"
					+ " WHERE m.m_coid = co.coid AND s.s_coid = co.coid AND scorrect = 1" 
					+ " AND co.coid = ?";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, "tutor002_001"); // Co-id 넣기

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				manswer = rs.getString(1);
				mcontents = rs.getString(2);
				mgenre = rs.getString(3);
				mtitle = rs.getString(4);
				mid = rs.getInt(5);
				qseq = rs.getInt(5);
				DtoMake_OKH beanList = new DtoMake_OKH(manswer, mcontents, mgenre, mtitle, mid, qseq);
				dto.add(beanList);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;

	}

}
