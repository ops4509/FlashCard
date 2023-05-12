package com.javalec.dto;

public class Dto_handle {

	
	
	
	
	int hseq;
	String h_uid;
	int h_cid;
	int h_status;
	String hregdaet;
	
	
	public Dto_handle(int h_cid) {
		super();
		this.h_cid = h_cid;
	}
	
	
	
	
	
	
	
	
	
	
	
	// getter & setter 목록 
	

	public int getHseq() {
		return hseq;
	}
	public void setHseq(int hseq) {
		this.hseq = hseq;
	}
	public String getH_uid() {
		return h_uid;
	}
	public void setH_uid(String h_uid) {
		this.h_uid = h_uid;
	}
	public int getH_cid() {
		return h_cid;
	}
	public void setH_cid(int h_cid) {
		this.h_cid = h_cid;
	}
	public int getH_status() {
		return h_status;
	}
	public void setH_status(int h_status) {
		this.h_status = h_status;
	}
	public String getHregdaet() {
		return hregdaet;
	}
	public void setHregdaet(String hregdaet) {
		this.hregdaet = hregdaet;
	}
	
	
	
	
}
