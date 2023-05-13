package com.javalec.dto;

public class Dto_card {
	
	int cid;
	String cgenre;
	String ctitle;
	String ccontents;
	String canswer;
	String collection;

	
	
	
	/*
	public Dto_card(int cid, String cgenre, String ctitle, String ccontents, String canswer) {
		super();
		this.cid = cid;
		this.cgenre = cgenre;
		this.ctitle = ctitle;
		this.ccontents = ccontents;
		this.canswer = canswer;
	}*/
	
	
	public Dto_card(int cid, String ccontents, String canswer, String ctitle, String cgenre) {
		super();
		this.cgenre = cgenre;
		this.ctitle = ctitle;
		this.ccontents = ccontents;
		this.canswer = canswer;
		this.cid = cid;
	}
	

	public Dto_card(String ccontents, String canswer, String collection, String ctitle, String cgenre) {
		super();
		this.ccontents = ccontents;
		this.canswer = canswer;
		this.collection = collection;
		this.ctitle = ctitle;
		this.cgenre = cgenre;
	}
	
	// getter & setter 목록
	


	//contents / answer / (collection) / title / genre / 





	public Dto_card(int cid) {
		super();
		this.cid = cid;
	}







	
	
	
	





	public String getCollection() {
		return collection;
	}




	public void setCollection(String collection) {
		this.collection = collection;
	}




	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCgenre() {
		return cgenre;
	}
	public void setCgenre(String cgenre) {
		this.cgenre = cgenre;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getCcontents() {
		return ccontents;
	}
	public void setCcontents(String ccontents) {
		this.ccontents = ccontents;
	}
	public String getCanswer() {
		return canswer;
	}
	public void setCanswer(String canswer) {
		this.canswer = canswer;
	}
	
	
	
	
	

}
