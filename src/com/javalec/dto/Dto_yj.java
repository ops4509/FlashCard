package com.javalec.dto;

public class Dto_yj {

	String u_id;
	String u_name;
	String u_pw;
	String u_phone;
	String u_phone1;
	String u_email;
	String u_email1;
	String u_edate;
	String ullogindate;
	
	String tid;
	String tpw;
	String tname;
	String tspeciality;
	String tllogindate;
	
	String payment;

	public Dto_yj(String u_id, String u_name, String u_pw) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public Dto_yj(String payment) {
		super();
		this.payment = payment;
	}

	public Dto_yj() {
		// TODO Auto-generated constructor stub
	}

	public String getU_phone1() {
		return u_phone1;
	}
	public void setU_phone1(String u_phone1) {
		this.u_phone1 = u_phone1;
	}
	public String getU_email1() {
		return u_email1;
	}

	public void setU_email1(String u_email1) {
		this.u_email1 = u_email1;
	}

	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTpw() {
		return tpw;
	}

	public void setTpw(String tpw) {
		this.tpw = tpw;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTspeciality() {
		return tspeciality;
	}

	public void setTspeciality(String tspeciality) {
		this.tspeciality = tspeciality;
	}

	public Dto_yj(String u_id, String u_name, String u_phone, String u_phone1, String u_email, String u_email1) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_phone = u_phone;
		this.u_phone1 = u_phone1;
		this.u_email = u_email;
		this.u_email1 = u_email1;
	}

	public Dto_yj(String u_id, String u_name, String u_email, String u_phone) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_phone = u_phone;
	}

	public Dto_yj(String u_id, String u_name, String u_pw,String u_phone, String u_email) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_pw = u_pw;
		this.u_phone = u_phone;
		this.u_email = u_email;
	}

	public Dto_yj(String ullogindate, String tllogindate) {
		super();
		this.ullogindate = ullogindate;
		this.tllogindate = tllogindate;
	}


	public String getUllogindate() {
		return ullogindate;
	}


	public void setUllogindate(String ullogindate) {
		this.ullogindate = ullogindate;
	}


	public String getTllogindate() {
		return tllogindate;
	}


	public void setTllogindate(String tllogindate) {
		this.tllogindate = tllogindate;
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
		this.tid = t_id;
		this.tpw = t_pw;
		this.tname = t_name;
		this.tspeciality = t_speciality;
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
		return tid;
	}

	public void setT_id(String tid) {
		this.tid = tid;
	}

	public String getT_pw() {
		return tpw;
	}

	public void setT_pw(String tpw) {
		this.tpw = tpw;
	}

	public String getT_name() {
		return tname;
	}

	public void setT_name(String tname) {
		this.tname = tname;
	}

	public String getT_speciality() {
		return tspeciality;
	}

	public void setT_speciality(String tspeciality) {
		this.tspeciality = tspeciality;
	}
	
}
	

