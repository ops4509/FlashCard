package com.javalec.dto;

public class Dto_yj {

	String u_id;
	String u_name;
	String u_pw;
	String u_email;
	String u_phone;
	String u_edate;
	String ullogindate;
	
	String t_id;
	String t_pw;
	String t_name;
	String t_speciality;
	
	public Dto_yj() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Dto_yj(String ullogindate) {
		super();
		this.ullogindate = ullogindate;
	}



	public String getUllogindate() {
		return ullogindate;
	}



	public void setUllogindate(String ullogindate) {
		this.ullogindate = ullogindate;
	}



	public Dto_yj(String u_id, String u_name, String u_pw, String u_email, String u_phone, String u_edate, String t_id,
			String t_pw, String t_name, String t_speciality) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
		this.u_email = u_email;
		this.u_phone = u_phone;
		this.u_edate = u_edate;
		this.t_id = t_id;
		this.t_pw = t_pw;
		this.t_name = t_name;
		this.t_speciality = t_speciality;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_edate() {
		return u_edate;
	}

	public void setU_edate(String u_edate) {
		this.u_edate = u_edate;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getT_pw() {
		return t_pw;
	}

	public void setT_pw(String t_pw) {
		this.t_pw = t_pw;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public String getT_speciality() {
		return t_speciality;
	}

	public void setT_speciality(String t_speciality) {
		this.t_speciality = t_speciality;
	}
	
	
	
}
