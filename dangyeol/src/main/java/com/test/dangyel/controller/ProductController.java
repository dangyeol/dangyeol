package com.test.dangyel.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.test.dangyel.dto.ProductVO;
import com.test.dangyel.service.MemberService;
import com.test.dangyel.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	private MemberService memberService;
	private ProductService productService;

	BasicDBObject searchQuery = new BasicDBObject();
	BasicDBObject searchQuery2 = new BasicDBObject();
	BasicDBObject whereQuery = new BasicDBObject();

	@RequestMapping(value = "/insertproduct", method = RequestMethod.POST)
	public void InsertProduct(@RequestBody Map<String, Object> map) {

		ProductVO productVO = new ProductVO();

		String[] attr = { map.get("mem_Email").toString() };

		productVO.setPro_Name(map.get("pro_Name").toString());
		productVO.setPro_Date(Integer.parseInt(map.get("pro_Date").toString()));
		productVO.setPro_Start(Integer.parseInt(map.get("pro_Start").toString()));
		productVO.setPro_End(Integer.parseInt(map.get("pro_End").toString()));
		productVO.setPro_Count(Integer.parseInt(map.get("pro_Count").toString()));
		productVO.setPro_Dead("N");
		productVO.setPro_Party(attr);
		productVO.setPro_Category(map.get("pro_Category").toString());
		productVO.setPro_Author(map.get("mem_Email").toString());

		productService.insertProduct(productVO);
		memberService.MemberEtcUpdate(map, "mem_Purchase");

	}

	public void DeleteProduct(@RequestBody Map<String, Object> map) {
       
		
		
	}

}
