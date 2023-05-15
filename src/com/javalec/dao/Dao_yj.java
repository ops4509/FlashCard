package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import com.javalec.dto.Dto_yj;
import com.javalec.util.ShareVar;
import com.javalec.base.MainLogin_Yj;

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



	
	
	public Dao_yj(String u_id) {
		super();
		this.u_id = u_id;
	}






	public Dao_yj(String u_id, String u_pw, String ullogindate) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.ullogindate = ullogindate;
	}

	

	public Dao_yj(String u_id, String u_name, String u_pw, String u_email, String u_phone) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
		this.u_email = u_email;
		this.u_phone = u_phone;
	}






	// 로그인

	public boolean loginAction() {
		
		String whereDefault = "select u_id, u_pw, u_name from user";
		PreparedStatement ps = null;
		int token=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
	       
	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        String currentTimestampToString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(timestamp);
	        
	        String query = "UPDATE ulogin SET ullogindate = ? WHERE ul_uid = ?";
	        ps = conn_mysql.prepareStatement(query);
	        ps.setString(1, currentTimestampToString);
	        ps.setString(2, u_id); 
	       
	        
			
			while (rs.next()) {
				if (rs.getString(1).equals(u_id) && rs.getString(2).equals(u_pw)) {
						ShareVar.u_id = rs.getString(1);
						ShareVar.u_name = rs.getString(3);
					token = 1;
					break;
				}	
			}
			
			  ps.executeUpdate();
			
			conn_mysql.close();
			
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
	
	// tutor 로그인
	
	public boolean tutorAction() {

		String whereDefault = "select tid, tpw from tutor";
		PreparedStatement ps = null;
		int token = 0;
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
	       
	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        String currentTimestampToString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(timestamp);
	        
	        String query = "UPDATE tlogin SET tllogindate = ? WHERE tl_tid = ?";
	        
	        ps = conn_mysql.prepareStatement(query);
	        

	        ps.setString(1, currentTimestampToString);
	        ps.setString(2, u_id); 
	       
		
	        
			while (rs.next()) {
				
					if (rs.getString(1).equals(u_id) && rs.getString(2).equals(u_pw)) {
					token = 1;
					break;
					
				}	
					
			}
	
			ps.executeUpdate();
			
			conn_mysql.close();
			
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
	
	// 로그 아웃 
	
	public boolean logoutAction(String u_id) {
	    String query = "UPDATE ulogin SET ullogoutdate = ? WHERE ul_uid = ?";
	    PreparedStatement ps = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        String currentTimestampToString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(timestamp);

	        ps = conn_mysql.prepareStatement(query);
	        ps.setString(1, currentTimestampToString);
	        ps.setString(2, u_id);

	        int updatedRows = ps.executeUpdate();

	        conn_mysql.close();

	        return updatedRows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	        }catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	    }
	}
	
	// tutor 로그 아웃
	

	public boolean tutorLogoutAction(String u_id) {
	    String query = "UPDATE tlogin SET tllogoutdate = ? WHERE tl_tid = ?";
	    PreparedStatement ps = null;

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        String currentTimestampToString = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(timestamp);

	        ps = conn_mysql.prepareStatement(query);
	        ps.setString(1, currentTimestampToString);
	        ps.setString(2, u_id);

	        int updatedRows = ps.executeUpdate();

	        conn_mysql.close();

	        return updatedRows > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try {
	            if (ps != null) {
	                ps.close();
	            }
	        }catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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

			ps.executeUpdate();
			
			ps1.setString(1, u_id.trim());
			ps1.setInt(2, 0);
		
			ps1.executeUpdate();
		

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
		
	}
	
	// 아이디 중복 확인
	
	public boolean doubleCheckAction() {
		// TODO Auto-generated method stub
			
		String whereDefault = "select u_id from user";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereDefault);



			while (rs.next()) {
				if (rs.getString(1).equals(u_id)) {
					return false;
				}
				else {
				
				}
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
		
		return true;
	}
	
	// ----------------------------- 마이페이지 정보 불러오기 
	
	public ArrayList<Dto_yj> userMypage(){
		ArrayList<Dto_yj> dtoList = new ArrayList<Dto_yj>();
		
		String query = "select u_id, u_name, mid(u_phone, 5, 4),right(u_phone, 4), SUBSTRING_INDEX(u_email, '@', 1), SUBSTRING_INDEX(u_email, '@', -1) from user";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(query);
			MainLogin_Yj mlyj = new MainLogin_Yj();
			
			while(rs.next()) {
				if(rs.getString(1).equals(mlyj.u_id)) {
				String u_id = rs.getString(1);
				String u_name = rs.getString(2);
				String u_phone = rs.getString(3);
				String u_phone1 = rs.getString(4);
				String u_email = rs.getString(5);
				String u_email1 = rs.getString(6);
			
				Dto_yj dto_yj = new Dto_yj(u_id, u_name, u_phone, u_phone1, u_email, u_email1);
				dtoList.add(dto_yj);
				}
			}

			conn_mysql.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
	// 회원정보 변경 
	
	public boolean updateAction() {
		
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String updateUserQuery = "UPDATE user SET u_id = ?, u_pw = ?, u_name = ?, u_phone = ?, u_email = ? WHERE u_id = ?";
	        ps = conn_mysql.prepareStatement(updateUserQuery);
	        ps.setString(1, u_id.trim());
	        ps.setString(2, u_pw.trim());
	        ps.setString(3, u_name.trim());
	        ps.setString(4, u_phone.trim());
	        ps.setString(5, u_email.trim());
	        ps.setString(6, u_id.trim());
	        ps.executeUpdate();
	        
	        conn_mysql.close();	
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
		
	
	// 금액 가져오기 
	
	public ArrayList<Dto_yj> paymentAction() {
	    ArrayList<Dto_yj> dtoList = new ArrayList<Dto_yj>();

	    String query = "SELECT u.u_id, SUM(co.csprice) AS payment " +
	                   "FROM user u, buy b, collection c, colsales co " +
	                   "WHERE u.u_id = b.b_uid AND b.b_coid = c.coid AND c.coid = co.cs_coid " +
	                   "AND u.u_id = ?";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        
	        PreparedStatement pstmt = conn_mysql.prepareStatement(query);
	        pstmt.setString(1, MainLogin_Yj.u_id);
	        
	        ResultSet rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	            String payment = rs.getString("payment");
	            
	            Dto_yj dto_yj = new Dto_yj(payment);
	            dtoList.add(dto_yj);
	        }
	        
	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return dtoList;
	}
	
	// 관리자 정보 가져오기
	
	public ArrayList<Dto_yj> getTetorInfo() {
	    ArrayList<Dto_yj> dtoList = new ArrayList<Dto_yj>();

	    String query = "select tid, tpw, tname from tutor";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();

	        ResultSet rs = stmt_mysql.executeQuery(query);
	        MainLogin_Yj mlyj = new MainLogin_Yj();

	        while (rs.next()) {
	            if (rs.getString(1).equals(mlyj.u_id)) {
	                String tid = rs.getString(1);
	                String tpw = rs.getString(2);
	                String tname = rs.getString(3);

	                Dto_yj dto_yj = new Dto_yj(tid, tpw, tname);
	                dtoList.add(dto_yj);
	            }
	        }

	        conn_mysql.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	
	    }

	    return dtoList;
	}

	
} //end
