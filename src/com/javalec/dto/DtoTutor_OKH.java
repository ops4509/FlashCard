package com.javalec.dto;

public class DtoTutor_OKH {
	//	Fields
	String tid;
	String tpw;
	String tname;
	String tspeciality;
	
	//	Constructor
	public DtoTutor_OKH() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoTutor_OKH(String tid, String tpw, String tname, String tspeciality) {
		super();
		this.tid = tid;
		this.tpw = tpw;
		this.tname = tname;
		this.tspeciality = tspeciality;
	}

	public DtoTutor_OKH(String tname) {
		super();
		this.tname = tname;
	}

	//	Method G/S
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
	
	
}
