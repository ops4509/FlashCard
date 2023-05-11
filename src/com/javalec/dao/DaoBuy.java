package com.javalec.dao;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.javalec.base.Buy2;
import com.javalec.dto.DtoBuy;
import com.javalec.util.ShareVar;

public class DaoBuy {

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;

	// Field

	// ps.setString(1, b_uid);
	// ps.setString(2, b_coid);
	// ps.setTimestamp(3, bdate);
	// ps.setInt(4, bprice);

	int csprice;
	String coid;
	String coname;
	FileInputStream file;
	String cs_coid;

	String b_uid;
	String b_coid;
	int bprice;
	String bdate;

	String conname;
	String condata;
	String date;
	
	
	

	// Constructor (생성자)
	
	
	public DaoBuy() {
		super();
	}

	public DaoBuy(String date) {
		super();
		this.date = date;
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

	public DaoBuy(int csprice, String cs_coid) {
		super();
		this.cs_coid = cs_coid;
		this.csprice = csprice;
	}

	// SQL안에 있는 데이터 가지고 오기 ( Buy1에 연결되어 있는 콤보박스 기능 추가 기능 )
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

	// SQL안에 있는 데이터 가지고 오기 ( Buy1에 있는 최초 실행시 보여주는 데이터 기능 )
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

	//  구매페이지 상품목록에 있는 데이터를 구매완료 페이지로 넘어가면서 해당 데이터를 Buy SQL에 입력시키는 Method 
	public boolean changepage2() {
		// Buy2 buy = new Buy2();

		PreparedStatement ps = null;
		// 다른 클래스로 이동하기 전, 추가 데이터를 입력받음 // 삭제함 
		
		/*String additionalData = JOptionPane.showInputDialog("추가 데이터를 입력하세요:");*/
		// SQL 쿼리문 작성
		String sql = "INSERT INTO buy (b_uid, b_coid, bdate, bprice)" + " VALUES (?, ?, ?, ?)";

		try {
			// 데이터베이스 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			// SQL 쿼리문 실행을 위한 PreparedStatement 생성
			ps = conn_mysql.prepareStatement(sql);
			
			// 현재 시간을 가져와서 쿼리문에 할당
			LocalDate currentDate = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDate = currentDate.format(formatter);

			// 쿼리문의 ? 위치에 값 할당
			ps.setString(1, "ajw2002");
			ps.setString(2, Buy2.cs_coid2);
			ps.setString(3, formattedDate);
			ps.setInt(4, Buy2.csprice2);

			// 쿼리문 실행
			ps.executeUpdate();

			// 자원 해제
			ps.close();
			conn_mysql.close();

			// 다른 클래스로 이동
			// ...
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	// TODO Auto-generated method stub

}
