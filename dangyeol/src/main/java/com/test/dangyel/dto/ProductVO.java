package com.test.dangyel.dto;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class ProductVO {

	private ObjectId _id;
	private int pro_Num;
	private String pro_Name;
	private int pro_Date;
	private int pro_Start;
	private int pro_End;
	private int pro_Count;
	private String pro_Dead;
	private String[] pro_Party;
	private String pro_Category;
	private String pro_Author;
	private String pro_Content;

	
	
	
	


	

	@Override
	public String toString() {
		return "ProductVO [_id=" + _id + ", pro_Num=" + pro_Num + ", pro_Name=" + pro_Name + ", pro_Date=" + pro_Date
				+ ", pro_Start=" + pro_Start + ", pro_End=" + pro_End + ", pro_Count=" + pro_Count + ", pro_Dead="
				+ pro_Dead + ", pro_Party=" + Arrays.toString(pro_Party) + ", pro_Category=" + pro_Category
				+ ", pro_Author=" + pro_Author + ", pro_Content=" + pro_Content + "]";
	}

	public int getPro_Num() {
		return pro_Num;
	}

	public void setPro_Num(int pro_Num) {
		this.pro_Num = pro_Num;
	}

	

	public String getPro_Content() {
		return pro_Content;
	}

	public void setPro_Content(String pro_Content) {
		this.pro_Content = pro_Content;
	}

	

	



	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
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
