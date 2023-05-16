package com.javalec.dto;

public class DtoUser_OKH {

	// Field
	String uid;
	String upw;
	String uname;
	String uphonef;
	String uphonem;
	String uphoneb;
	String uemailf;
	String uemailb;

	// Constructor

	public DtoUser_OKH() {
		// TODO Auto-generated constructor stub
	}

	public DtoUser_OKH(String uid, String upw, String uname, String uphonef, String uphonem, String uphoneb, String uemailf,
			String uemailb) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.uphonef = uphonef;
		this.uphonem = uphonem;
		this.uphoneb = uphoneb;
		this.uemailf = uemailf;
		this.uemailb = uemailb;
	}

	//	Method G/S
	
	public String getUpw() {
		return upw;
	}

	public void setUpw(String upw) {
		this.upw = upw;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphonef() {
		return uphonef;
	}

	public void setUphonef(String uphonef) {
		this.uphonef = uphonef;
	}

	public String getUphonem() {
		return uphonem;
	}

	public void setUphonem(String uphonem) {
		this.uphonem = uphonem;
	}

	public String getUphoneb() {
		return uphoneb;
	}

	public void setUphoneb(String uphoneb) {
		this.uphoneb = uphoneb;
	}

	public String getUemailf() {
		return uemailf;
	}

	public void setUemailf(String uemailf) {
		this.uemailf = uemailf;
	}

	public String getUemailb() {
		return uemailb;
	}

	public void setUemailb(String uemailb) {
		this.uemailb = uemailb;
	}

	
	
	
}
