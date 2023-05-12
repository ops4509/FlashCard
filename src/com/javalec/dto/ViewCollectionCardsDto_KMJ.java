package com.javalec.dto;

public class ViewCollectionCardsDto_KMJ {
	String cid;
	String cgenre;
	String ccontents;
	String canswer;
	String coid;
	public ViewCollectionCardsDto_KMJ() {
		// TODO Auto-generated constructor stub
	}
	
	public ViewCollectionCardsDto_KMJ(String ccontents, String canswer) {
		super();
		this.ccontents = ccontents;
		this.canswer = canswer;
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
