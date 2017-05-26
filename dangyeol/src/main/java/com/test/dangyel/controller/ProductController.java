package com.test.dangyel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dangyel.dto.ProductVO;
import com.test.dangyel.dto.PurchaseVO;
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
	public @ResponseBody boolean InsertProduct(@RequestBody Map<String, Object> map) {

		boolean flag = true;

		ProductVO productVO = new ProductVO();
		PurchaseVO purchaseVO = new PurchaseVO();

		productVO.setPro_Name(map.get("pro_Name").toString());
		productVO.setPro_End(map.get("pro_End").toString());
		productVO.setPro_Count(1);
		productVO.setPro_Dead("N");
		productVO.setPro_Category(map.get("pro_Category").toString());
		productVO.setPro_Author(map.get("mem_Email").toString());
		productVO.setPro_Content(map.get("pro_Content").toString());
		productVO.setPro_Price(map.get("pro_Price").toString());
        
		purchaseVO.setMem_CardName(map.get("mem_CardName").toString());
		purchaseVO.setMem_ProCheck("N");
		purchaseVO.setMem_ProName(map.get("pro_Name").toString());
		purchaseVO.setMem_Email(map.get("mem_Email").toString());
		/*purchaseVO.setMem_CardNum(map.get("mem_CardNum").toString());*/

		productService.insertProduct(productVO, map);
		productService.updateProduct(map, "pro_Party", purchaseVO);
		memberService.MemberaddToUpdate("mem_Purchase", purchaseVO, map);

		return true;

	}

	public void DeleteProduct(@RequestBody Map<String, Object> map) {

	}

	@RequestMapping(value = "/productlist", method = RequestMethod.POST)
	public @ResponseBody List<ProductVO> ProductList() {
        Query query =  new Query();
		List<ProductVO> list = new ArrayList<ProductVO>();
		list = productService.ProductList(query);
		return list;
	}

	@RequestMapping(value = "/productbuy", method = RequestMethod.POST)
	public @ResponseBody boolean ProductPurchase(@RequestBody Map<String, Object> map) {

		PurchaseVO purchaseVO = new PurchaseVO();

		purchaseVO.setMem_ProName(map.get("pro_Name").toString());
		purchaseVO.setMem_CardName(map.get("mem_CardName").toString());
		purchaseVO.setMem_ProCheck("N");
		purchaseVO.setMem_Email(map.get("mem_Email").toString());
 
		productService.ProductBuy("pro_Party",purchaseVO,map);
		memberService.MemberaddToUpdate("mem_Purchase", purchaseVO, map);
		return true;

	}
}