package com.test.dangyel.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="member")
public class MemberVO {

	private String _id;
	private String mem_Email;
	private String mem_Pwd;
	private String mem_Name;
	private String[] mem_Card;
	private String[] mem_Purchase;
	
	
	
	
	
	
    
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String[] getMem_Purchase() {
		return mem_Purchase;
	}

	public void setMem_Purchase(String[] mem_Purchase) {
		this.mem_Purchase = mem_Purchase;
	}

	public String[] getMem_Card() {
		return mem_Card;
	}

	public void setMem_Card(String[] mem_Card) {
		this.mem_Card = mem_Card;
	}

	public String getMem_Email() {
		return mem_Email;
	}

	public void setMem_Email(String mem_Email) {
		this.mem_Email = mem_Email;
	}

	public String getMem_Pwd() {
		return mem_Pwd;
	}

	public void setMem_Pwd(String mem_Pwd) {
		this.mem_Pwd = mem_Pwd;
	}

	public String getMem_Name() {
		return mem_Name;
	}

	public void setMem_Name(String mem_Name) {
		this.mem_Name = mem_Name;
	}

}
