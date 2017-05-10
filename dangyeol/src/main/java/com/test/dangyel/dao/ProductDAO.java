package com.test.dangyel.dao;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.test.dangyel.dto.ProductVO;

public class ProductDAO {

	private MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public ProductDAO() {
		String mongoContextPath = "/mongoContext.xml";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(mongoContextPath);
		mongoTemplate = (MongoTemplate) ctx.getBean("mongoTemplate");

	}

	public ProductVO findOne(Query query) {

		ProductVO productVO = mongoTemplate.findOne(query, ProductVO.class, "product");
		return productVO;
	}

	public void insertProduct(ProductVO productVO) {

		mongoTemplate.insert(productVO, "product");
	}

	public void deleteProduct(Query query) {

		mongoTemplate.remove(query, "product");

	}

}
