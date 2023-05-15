package com.javalec.dto;

import java.io.FileOutputStream;

public class ViewCollectionMainDto_KMJ {
	
	String coName;
	String coId;
	int coPicpath;
	FileOutputStream file;
	

	public ViewCollectionMainDto_KMJ() {
		// TODO Auto-generated constructor stub
	}
	
	public ViewCollectionMainDto_KMJ(String coId, String coName, int coPicpath) {
		super();
		this.coId = coId;
		this.coName = coName;
		this.coPicpath = coPicpath;
	}
	
	public ViewCollectionMainDto_KMJ(String coName, String coId) {
		super();
		this.coName = coName;
		this.coId = coId;
	}

	public int getCoPicpath() {
		return coPicpath;
	}
	
	public void setCoPath(int coPicpath) {
		this.coPicpath = coPicpath;
	}
	
	public String getCoid() {
		return coId;
	}

	public void setCoid(String coId) {
		this.coId = coId;
	}
	
	public String getConame() {
		return coName;
	}

	public void setConame(String coName) {
		this.coName = coName;
	}
	
	
	
	
}
