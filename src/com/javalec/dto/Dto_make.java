package com.javalec.dto;

public class Dto_make {

	
	
	
	
	int mid;
	String m_tid;
	String m_coid;
	String mgenre;
	String mtitle;
	String mcontents;
	String manswer;
	
	
	
	
	
	
	
	
	 
	
	
	
	//Dto_make dto = new Dto_make(wkcid, wkcontents, wkanswer, wkcoid, wktitle, wkgenre);

	
	
	
	public Dto_make(int mid, String mcontents, String manswer, String m_coid, String mtitle, String mgenre) {
		super();
		this.mid = mid;
		this.m_tid = m_tid;
		this.mgenre = mgenre;
		this.mtitle = mtitle;
		this.mcontents = mcontents;
		this.manswer = manswer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 게터 앤 세
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getM_tid() {
		return m_tid;
	}
	public void setM_tid(String m_tid) {
		this.m_tid = m_tid;
	}
	public String getM_coid() {
		return m_coid;
	}
	public void setM_coid(String m_coid) {
		this.m_coid = m_coid;
	}
	public String getMgenre() {
		return mgenre;
	}
	public void setMgenre(String mgenre) {
		this.mgenre = mgenre;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMcontents() {
		return mcontents;
	}
	public void setMcontents(String mcontents) {
		this.mcontents = mcontents;
	}
	public String getManswer() {
		return manswer;
	}
	public void setManswer(String manswer) {
		this.manswer = manswer;
	}
	
	
	
	
	
	
	
	
	
}
