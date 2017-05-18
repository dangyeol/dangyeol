package com.test.dangyel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dangyel.dto.ProductVO;
import com.test.dangyel.service.MemberService;
import com.test.dangyel.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/insertproduct", method = RequestMethod.POST)
	public void InsertProduct(@RequestBody Map<String, Object> map) {

		ProductVO productVO = new ProductVO();

		String[] attr = { map.get("mem_Email").toString() };

		productVO.setPro_Name(map.get("pro_Name").toString());
		productVO.setPro_End(Integer.parseInt(map.get("pro_End").toString()));
		productVO.setPro_Count(1);
		productVO.setPro_Dead("N");
		productVO.setPro_Party(attr);
		productVO.setPro_Category(map.get("pro_Category").toString());
		productVO.setPro_Author(map.get("mem_Email").toString());
		productVO.setPro_Content(map.get("pro_Content").toString());

		productService.insertProduct(productVO, map);

	}

	public void DeleteProduct(@RequestBody Map<String, Object> map) {

	}

	@RequestMapping(value = "/productlist", method = RequestMethod.POST)
	public @ResponseBody List<ProductVO> ProductList() {
		System.out.println("푸드코트가는날");
		List<ProductVO> list = productService.ProductList();
		return list;
	}

}
