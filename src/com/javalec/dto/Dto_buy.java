package com.javalec.dto;

public class Dto_buy {
	
	
	String coid;
	String coname;
	
	
	
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
	
	
	
	
	//         
	
	
	public Dto_buy(String coid, String coname) {
		super();
		this.coid = coid;
		this.coname = coname;
	}
	
	
	
	
	public Dto_buy(String coid) {
		super();
		this.coid = coid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
