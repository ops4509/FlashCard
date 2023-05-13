package com.javalec.daoBuy;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.javalec.dtoBuy.DtoBuy;
import com.javalec.util.ShareVar;

public class DaoBuy {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	// Field

	int csprice;
	String coid;
	String coname;
	FileInputStream file;

	String conname;
	String condata;

	// Constructor (생성자)
	public DaoBuy() {
		super();
	}

	public DaoBuy(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}

	public DaoBuy(int csprice, String coid, String coname, FileInputStream file) {
		super();
		this.csprice = csprice;
		this.coid = coid;
		this.coname = coname;
		this.file = file;
	}

//  SQL안에 있는 데이터 가지고 오기 
	public ArrayList<DtoBuy> conditionList() {
		ArrayList<DtoBuy> dtoList = new ArrayList<DtoBuy>();

		String whereDefault = "select c.coid, c.coname, c.copic, co.csprice" + " from collection c, colsales co "
				+ " where c.coid = co.cs_coid ";

		String whereDefault1 = "and " + conname + " like '%" + condata + "%'";

		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault + whereDefault1);

			while (rs.next()) {
				String coid = rs.getString(1);
				String coname = rs.getString(2);
				Blob copic = rs.getBlob(3);
				int price = rs.getInt(4);
				InputStream is = copic.getBinaryStream(1, copic.length());
				BufferedImage image = ImageIO.read(is);

				DtoBuy dto = new DtoBuy(coid, coname, image, price);
				dtoList.add(dto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public ArrayList<DtoBuy> searchList() {
		ArrayList<DtoBuy> dtoList = new ArrayList<DtoBuy>();

		String whereDefault = "select c.coid, c.coname, c.copic, co.csprice" + " from collection c, colsales co "
				+ " where c.coid = co.cs_coid";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault);

			while (rs.next()) {

				String coid = rs.getString(1);
				String coname = rs.getString(2);
				Blob copic = rs.getBlob(3);
				int price = rs.getInt(4);
				InputStream is = copic.getBinaryStream(1, copic.length());
				BufferedImage image = ImageIO.read(is);

				DtoBuy dto = new DtoBuy(coid, coname, image, price);
				dtoList.add(dto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

}