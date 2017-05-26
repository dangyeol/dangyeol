package com.test.dangyel.dao;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.test.dangyel.dto.BenefitVO;

public class BenefitDAO {
	
	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public BenefitDAO() {
		String mongoContextPath = "/mongoContext.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);
		mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");

	}
	
	public void insert(BenefitVO benefitVO){
		mongoTemplate.insert(benefitVO, "benefit");
	}

}
