package com.javalec.dto;

import java.io.FileInputStream;

public class DtoCollection_OKH {
	// Fields
	String coid;
	String coname;
	String copath;

	// Constructor

	public DtoCollection_OKH() {

	}

	public DtoCollection_OKH(String coid, String coname, String copath) {
		super();
		this.coid = coid;
		this.coname = coname;
		this.copath = copath;
	}

	// Method G/S

	public String getCoid() {
		return coid;
	}

	public void setCoid(String coid) {
		this.coid = coid;
	}

	public String getConame() {
		return coname;
	}

	public void setConame(String coname) {
		this.coname = coname;
	}

	public String getCopath() {
		return copath;
	}

	public void setCopath(String copath) {
		this.copath = copath;
	}

}
