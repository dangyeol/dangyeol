package com.test.dangyel.dto;

public class BenefitVO {
	
	private String pro_Name;
	private String mem_Email;
	private String mem_CardName;
	private String mem_Point;
	
	
	
	
	public String getMem_Point() {
		return mem_Point;
	}
	public void setMem_Point(String mem_Point) {
		this.mem_Point = mem_Point;
	}
	public String getPro_Name() {
		return pro_Name;
	}
	public void setPro_Name(String pro_Name) {
		this.pro_Name = pro_Name;
	}
	public String getMem_Email() {
		return mem_Email;
	}
	public void setMem_Email(String mem_Email) {
		this.mem_Email = mem_Email;
	}
	public String getMem_CardName() {
		return mem_CardName;
	}
	public void setMem_CardName(String mem_CardName) {
		this.mem_CardName = mem_CardName;
	}
	@Override
	public String toString() {
		return "BenefitVO [pro_Name=" + pro_Name + ", mem_Email=" + mem_Email + ", mem_CardName=" + mem_CardName + "]";
	}
	
	
	

}
