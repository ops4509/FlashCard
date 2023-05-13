package com.javalec.dtoBuy;

import java.awt.image.BufferedImage;

public class DtoBuy {

	// Field
	String coid;
	String coname;
	BufferedImage copic;
	int csprice;

	// Constructor (생성자)

	public DtoBuy(String coid, String coname) {
		super();

		this.coid = coid;
		this.coname = coname;
	}

	public BufferedImage getCopic() {
		return copic;
	}

	public void setCopic(BufferedImage copic) {
		this.copic = copic;
	}

	public DtoBuy(String coid, String coname, BufferedImage copic, int csprice) {
		super();
		this.coid = coid;
		this.coname = coname;
		this.copic = copic;
		this.csprice = csprice;
	}

	public int getCsprice() {
		return csprice;
	}

	public void setCsprice(int csprice) {
		this.csprice = csprice;
	}

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

}
