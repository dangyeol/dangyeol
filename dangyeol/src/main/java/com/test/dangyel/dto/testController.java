package com.test.dangyel.dto;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;

public class testController {
    
	private MongoTemplate mongoTemplate;  
	public testController() {
	String mongoContextPath = "mongoContext.xml";
	AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);
	mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");
	}

//	public static void main(String[] args) {
//	testController mongoTest = new testController();
//	System.out.println(mongoTest.mongoTemplate);
//	mongoTest.insertTestData();
//	}

	private void insertTestData() {
	MongoTestVO testVO = new MongoTestVO();
	testVO.setName("?λ¦?!!");
	testVO.setAddress("κ³ κΈΈ? μ§? 1?΅??  ?΄?κ°?...");
	
	// testVO? ?? ?΄?©? "person" Collection? ?£κ² λ€.
	mongoTemplate.insert(testVO, "person");
	}

	private class MongoTestVO {
		// λ°λ? id annotation?΄ λΆμ? id λ³??κ°? ??!
		
	@Id
	private String id;
	private String name;
	private String address;

	public String getId() {
	return id;
	}

		public void setId(String id) {
	this.id = id;
	}

		public String getName() {
	return name;
	}

		public void setName(String name) {
	this.name = name;
	}

		public String getAddress() {
	return address;
	}

		public void setAddress(String address) {
	this.address = address;
	}
	}
}
