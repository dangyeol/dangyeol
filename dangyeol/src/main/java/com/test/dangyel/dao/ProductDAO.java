package com.test.dangyel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

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

	public List<ProductVO> find(Query query) {

		List<ProductVO> list = new ArrayList<ProductVO>();
		list = mongoTemplate.find(query, ProductVO.class, "product");
		return list;
	}
	


	public void updateProduct(Query query, Update update) {

		mongoTemplate.updateFirst(query, update, "product");

	}
}
