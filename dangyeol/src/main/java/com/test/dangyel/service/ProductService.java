package com.test.dangyel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.DBObject;
import com.test.dangyel.dao.MemberDAO;
import com.test.dangyel.dao.ProductDAO;
import com.test.dangyel.dto.ProductVO;
import com.test.dangyel.dto.PurchaseVO;

public class ProductService {

	private ProductDAO productDAO;
	private MemberDAO memberDAO;

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	DBObject dbObject;

	public ProductVO FindOne(Query query) {

		ProductVO productVO = productDAO.findOne(query);
		return productVO;

	}

	public void insertProduct(ProductVO productVO, Map map) {

		productDAO.insertProduct(productVO);

		Criteria criteria = new Criteria("pro_Name");
		criteria.is(map.get("pro_Name"));
		Query query = new Query(criteria);

		ProductVO productVO1 = productDAO.findOne(query);
		System.out.println(productVO1.toString());


	}

	public void deleteProduct(Map map) {

		Criteria criteria = new Criteria("pro_Name");
		criteria.is(map.get("pro_Name").toString());
		Query query = new Query(criteria);

		productDAO.deleteProduct(query);

	}

	public List<ProductVO> ProductList(Query query) {

		

		List<ProductVO> list = new ArrayList<ProductVO>();
		list = productDAO.find(query);
		return list;
	}
	
	
	

	public void ProductBuy(String fieldName,PurchaseVO purchaseVO ,Map map) {

		Criteria criteria = new Criteria("pro_Name");
		criteria.is(map.get("pro_Name").toString());
		Query query = new Query(criteria);

		Update update = new Update();
		update.addToSet(fieldName, purchaseVO);

		productDAO.updateProduct(query, update);

	}
	
	
	public void updateProduct(Map map,String fieldName, Object object){
		

		Criteria criteria = new Criteria("pro_Name");
		criteria.is(map.get("pro_Name").toString());
		Query query = new Query(criteria);
		Update update = new Update();
		update.addToSet(fieldName, object);
		productDAO.updateProduct(query, update);
		
		
	}
	
	public void updateParty(String fieldName,String mem_Email,String pro_Name){
		
		Criteria criteria = new Criteria("pro_Name");
		criteria.is(pro_Name);
		Query query = new Query(criteria);
		query.addCriteria(Criteria.where("pro_Party").elemMatch(Criteria.where("mem_Email").is(mem_Email)));
		Update update = new Update();
		update.set(fieldName, "Y");
		productDAO.updateProduct(query, update);
	}

}
