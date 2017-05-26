package com.test.dangyel.dao;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.test.dangyel.dto.CardMemberVO;

public class CardMemberDAO {

	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public CardMemberDAO() {
		String mongoContextPath = "/mongoContext.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);
		mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");

	}

	public CardMemberVO findOne(Query query) {

		CardMemberVO cardMemberVO =mongoTemplate.findOne(query, CardMemberVO.class,"cardmember");
		
		return cardMemberVO;
	}

}
