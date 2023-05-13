package com.javalec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.javalec.dto.DtoCollection_OKH;
import com.javalec.dto.DtoMake_OKH;
import com.javalec.util.ShareVar;

public class DaoCollection_OKH {
	// Field

	private final String url_mysql = ShareVar.DBName;
	private final String id_mysql = ShareVar.DBUser;
	private final String pw_mysql = ShareVar.DBPass;
	
	String coname;
	FileInputStream copic;
	String copicpath;
	
	String selection;
	String conditionQueryColumn;

	// Constructor
	public DaoCollection_OKH() {

	}

	
	
	
	public DaoCollection_OKH(String conditionQueryColumn, String selection) {
		super();
		this.conditionQueryColumn = conditionQueryColumn;
		this.selection = selection;
	}




	// Method
	
	// selectCollection 
	public ArrayList<DtoCollection_OKH> selectCo() {
		PreparedStatement ps = null;
		ArrayList<DtoCollection_OKH> dto = new ArrayList<DtoCollection_OKH>();

		String query = "select co.coid, co.coname, co.copic, co.copicpath "
				+ " from collection co, user u , buy b "
				+ " where u.u_id = b.b_uid and b.b_coid = co.coid"
				+ " and u.u_id = ? ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, ShareVar.u_id);
			// sql에서 여기로 데이터가 넘어간다는 문구.

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String coid = rs.getString(1);
				String coname = rs.getString(2);
				InputStream copic = rs.getBinaryStream(3); // DB에서 데이터를 가져온다. // blob은 binary이다. 즉, SQL에서 BLOB으로 저장했으니,
				String copicpath = rs.getString(4);
				// Binary를 받아야한다.

				// File
				ShareVar.filename += 1; // Main 에서 이용할 공용 변수이기 때문
				File file = new File(Integer.toString(ShareVar.filename)); // 파일이나 디렉토리를 나타내기 위한 클래스이며, 이 클래스를 사용하여 파일을
																			// 생성하거나 읽기/쓰기 등의 작업을 수행할 수 있습니다.
				FileOutputStream output = new FileOutputStream(file); // "file" Object에 데이터를 출력하기 위한 클래스이며, 생성자에 파일 객체를
																		// 전달하여 해당 파일에 대한 출력 Stream을 생성
																		// * Stream : 데이터를 단위별로 처리하며, 이러한 단위를
																		// 버퍼(Buffer)라고 부릅니다.
				byte[] buffer = new byte[1024]; // 1024의 배열로 만들어주는 것
				while (copic.read(buffer) > 0) {
					output.write(buffer); // 버퍼는 스트림을 담아놓는 임시 저장소를 하는 것.
				}

				DtoCollection_OKH dtopic = new DtoCollection_OKH(coid, coname, copicpath);
				dto.add(dtopic);
			}

			// mysql에서 부른 정보들을 하나씩 묶어서 쌓아가는 과정.
			conn_mysql.close();

		} catch (Exception e) {

			e.printStackTrace(); // Error가 걸리면, Error 코드가 보여준다. 만약프로젝트 오픈한다고 하면 다이얼로그를 보여준다.
		}
		return dto;
	}
	
	// 조건 검색
	public ArrayList<DtoCollection_OKH> conditionfindaction() {
		PreparedStatement ps = null;
		ArrayList<DtoCollection_OKH> dto = new ArrayList<DtoCollection_OKH>();

		String query = "select distinct co.coid, co.coname, co.copic, co.copicpath "
				+ " from collection co, user u , buy b, tutor t, make m"
				+ " where u.u_id = b.b_uid and b.b_coid = co.coid"
				+ " and u.u_id = ? "
				+ " and ? like ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, ShareVar.u_id);
			ps.setString(2, conditionQueryColumn);
			ps.setString(3, "'%"+selection+"%'");
			
			// sql에서 여기로 데이터가 넘어간다는 문구.

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String coid = rs.getString(1);
				String coname = rs.getString(2);
				InputStream copic = rs.getBinaryStream(3); // DB에서 데이터를 가져온다. // blob은 binary이다. 즉, SQL에서 BLOB으로 저장했으니,
				String copicpath = rs.getString(4);
				// Binary를 받아야한다.

				// File
				ShareVar.filename += 1; // Main 에서 이용할 공용 변수이기 때문
				File file = new File(Integer.toString(ShareVar.filename)); // 파일이나 디렉토리를 나타내기 위한 클래스이며, 이 클래스를 사용하여 파일을
																			// 생성하거나 읽기/쓰기 등의 작업을 수행할 수 있습니다.
				FileOutputStream output = new FileOutputStream(file); // "file" Object에 데이터를 출력하기 위한 클래스이며, 생성자에 파일 객체를
																		// 전달하여 해당 파일에 대한 출력 Stream을 생성
																		// * Stream : 데이터를 단위별로 처리하며, 이러한 단위를
																		// 버퍼(Buffer)라고 부릅니다.
				byte[] buffer = new byte[1024]; // 1024의 배열로 만들어주는 것
				while (copic.read(buffer) > 0) {
					output.write(buffer); // 버퍼는 스트림을 담아놓는 임시 저장소를 하는 것.
				}

				DtoCollection_OKH dtopic = new DtoCollection_OKH(coid, coname, copicpath);
				dto.add(dtopic);
			}

			// mysql에서 부른 정보들을 하나씩 묶어서 쌓아가는 과정.
			conn_mysql.close();

		} catch (Exception e) {

			e.printStackTrace(); // Error가 걸리면, Error 코드가 보여준다. 만약프로젝트 오픈한다고 하면 다이얼로그를 보여준다.
		}
		return dto;
	}
	
	
}
