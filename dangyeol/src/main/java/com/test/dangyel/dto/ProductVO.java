package com.test.dangyel.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class ProductVO {

	private String pro_Id;
	private String pro_Name;
	private int pro_Date;
	private int pro_Start;
	private int pro_End;
	private int pro_Count;
	private String pro_Dead;
	private String[] pro_Party;
	private String pro_Category;
	private String pro_Author;

	
	public String getPro_Id() {
		return pro_Id;
	}

	public void setPro_Id(String pro_Id) {
		this.pro_Id = pro_Id;
	}

	public String getPro_Name() {
		return pro_Name;
	}

	public void setPro_Name(String pro_Name) {
		this.pro_Name = pro_Name;
	}

	public int getPro_Date() {
		return pro_Date;
	}

	public void setPro_Date(int pro_Date) {
		this.pro_Date = pro_Date;
	}

	public int getPro_Start() {
		return pro_Start;
	}

	public void setPro_Start(int pro_Start) {
		this.pro_Start = pro_Start;
	}

	public int getPro_End() {
		return pro_End;
	}

	public void setPro_End(int pro_End) {
		this.pro_End = pro_End;
	}

	public int getPro_Count() {
		return pro_Count;
	}

	public void setPro_Count(int pro_Count) {
		this.pro_Count = pro_Count;
	}

	public String getPro_Dead() {
		return pro_Dead;
	}

	public void setPro_Dead(String pro_Dead) {
		this.pro_Dead = pro_Dead;
	}

	public String[] getPro_Party() {
		return pro_Party;
	}

	public void setPro_Party(String[] pro_Party) {
		this.pro_Party = pro_Party;
	}

	public String getPro_Category() {
		return pro_Category;
	}

	public void setPro_Category(String pro_Category) {
		this.pro_Category = pro_Category;
	}

	public String getPro_Author() {
		return pro_Author;
	}

	public void setPro_Author(String pro_Author) {
		this.pro_Author = pro_Author;
	}

}
