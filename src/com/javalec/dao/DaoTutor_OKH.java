package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.javalec.dto.DtoMake_OKH;
import com.javalec.dto.DtoTutor_OKH;
import com.javalec.util.ShareVar;

public class DaoTutor_OKH {

	// Field
	String tid;
	String coid;
	String tname;

	String conditionQueryColumn;
	String selection;

	public final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	// Constructor
	public DaoTutor_OKH() {
		// TODO Auto-generated constructor stub
	}

	public DaoTutor_OKH(String coid) {
		super();
		this.coid = coid;
	}

	public DaoTutor_OKH(String coid, String conditionQueryColumn, String selection) {
		super();
		this.coid = coid;
		this.conditionQueryColumn = conditionQueryColumn;
		this.selection = selection;
	}

	// Method

	// select Tutorname
	public ArrayList<DtoTutor_OKH> tutorname() {
		PreparedStatement ps = null;
		ArrayList<DtoTutor_OKH> dto = new ArrayList<DtoTutor_OKH>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "select t.tname" + " from tutor t, collection co, make m"
					+ " where t.tid = m.m_tid and m.m_coid = co.coid" + " and co.coid = ?";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, coid);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tname = rs.getString(1);
			}
			DtoTutor_OKH beanList = new DtoTutor_OKH(tname);
			dto.add(beanList);

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public ArrayList<DtoTutor_OKH> conditionfindaction() {
		PreparedStatement ps = null;
		ArrayList<DtoTutor_OKH> dto = new ArrayList<DtoTutor_OKH>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql.cj가 mysql 8버젼부터 사용된거다.
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			String query = "select distinct t.tname" + " from collection co, user u , buy b, tutor t, make m"
					+ " where t.tid = m.m_tid and m.m_coid = co.coid" + " and co.coid = ?" + " and "+conditionQueryColumn+" like '%"+selection+"%'";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, coid);

			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tname = rs.getString(1);
			}
			DtoTutor_OKH beanList = new DtoTutor_OKH(tname);
			dto.add(beanList);

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
