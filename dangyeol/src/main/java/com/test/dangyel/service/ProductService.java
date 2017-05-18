package com.test.dangyel.service;

import java.util.HashMap;
import java.util.List;
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
		
		Map map1 = new HashMap();
		map1.put("mem_Email", productVO1.getPro_Author());
		map1.put("mem_ProId", productVO1.get_id());
		map1.put("mem_ProName", productVO1.getPro_Name());

		memberService.MemberEtcUpdate(map1, "mem_Purchase");

	}

	public void deleteProduct(Map map) {

		Criteria criteria = new Criteria("pro_Name");
		criteria.is(map.get("pro_Name").toString());
		Query query = new Query(criteria);

		productDAO.deleteProduct(query);

	}
	
	
	public List<ProductVO> ProductList(){
	
		Query query =new Query();
		
		List<ProductVO> list= productDAO.find(query);
		return list;
	}

}
