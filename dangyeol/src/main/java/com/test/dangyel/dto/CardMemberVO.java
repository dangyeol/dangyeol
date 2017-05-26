package com.test.dangyel.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cardmember")
public class CardMemberVO {

	private String card_Id;
	private String card_Pwd;
	private String card_Name;

	
	public String getCard_Id() {
		return card_Id;
	}


	public void setCard_Id(String card_Id) {
		this.card_Id = card_Id;
	}


	public String getCard_Pwd() {
		return card_Pwd;
	}


	public void setCard_Pwd(String card_Pwd) {
		this.card_Pwd = card_Pwd;
	}


	public String getCard_Name() {
		return card_Name;
	}


	public void setCard_Name(String card_Name) {
		this.card_Name = card_Name;
	}


	
	
	

}
