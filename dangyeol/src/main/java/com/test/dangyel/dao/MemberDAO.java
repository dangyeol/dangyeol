package com.test.dangyel.dao;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.test.dangyel.dto.MemberVO;
import com.test.dangyel.dto.PurchaseVO;

public class MemberDAO {

	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public MemberDAO() {
		String mongoContextPath = "/mongoContext.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);
		mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");

	}

	public void insert(MemberVO memberVO) {

		mongoTemplate.insert(memberVO, "member");

	}

	public MemberVO findOne(Query query) {

		MemberVO memberVO = mongoTemplate.findOne(query, MemberVO.class, "member");
	
		return memberVO;
	}
	
	public void update(Query query,Update update){
		
		mongoTemplate.updateFirst(query, update, "member");
		
	}
	
	public PurchaseVO find(Query query){
		
		PurchaseVO purchaseVO =(PurchaseVO) mongoTemplate.find(query, PurchaseVO.class, "member");
		
		return purchaseVO;
		
	}
	

	
	
	

}
