package com.javalec.dto;

public class DtoMake_OKH {

	// Fields
	int mid;
	String m_tid;
	String m_coid;
	String genre;
	String mtitle;
	String mcontents;
	String manswer;
	int cocount;

	// Constructor
	public DtoMake_OKH() {
		// TODO Auto-generated constructor stub
	}
	

	public DtoMake_OKH(int mid, String m_tid, String m_coid, String m_genre, String mtitle, String mcontents,
			String manswer) {
		super();
		this.mid = mid;
		this.m_tid = m_tid;
		this.m_coid = m_coid;
		this.genre = m_genre;
		this.mtitle = mtitle;
		this.mcontents = mcontents;
		this.manswer = manswer;
	}
	
	
	

	public DtoMake_OKH(String m_genre, int cocount) {
		super();
		this.genre = m_genre;
		this.cocount = cocount;
	}


	// Method G/S

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

	public String getM_genre() {
		return genre;
	}

	public void setM_genre(String m_genre) {
		this.genre = m_genre;
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


	public int getCocount() {
		return cocount;
	}


	public void setCocount(int cocount) {
		this.cocount = cocount;
	}
	

}
