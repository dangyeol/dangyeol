package com.test.dangyel.service;

import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;
import com.test.dangyel.dao.MemberDAO;
import com.test.dangyel.dao.ProductDAO;
import com.test.dangyel.dto.ProductVO;

public class ProductService {

	private ProductDAO productDAO;
	private MemberDAO memberDAO;

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	DBObject dbObject;

	public void insertProduct(ProductVO productVO) {

		productDAO.insertProduct(productVO);
		
	
	}
	
	public void  deleteProduct(Map map){
		
		Criteria criteria = new Criteria("pro_Name");
		criteria.is(map.get("pro_Name").toString());
		Query query =new Query(criteria);
		
		productDAO.deleteProduct(query);
		
		
		
		
		
	}
}
