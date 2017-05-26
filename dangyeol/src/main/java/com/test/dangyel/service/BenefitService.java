package com.test.dangyel.service;

import com.test.dangyel.dao.BenefitDAO;
import com.test.dangyel.dto.BenefitVO;

public class BenefitService {
	
	
	BenefitDAO benefitDAO;
	MemberService memberService;
	ProductService productService;
	
	
	
	
	
	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}


	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	public void setBenefitDAO(BenefitDAO benefitDAO) {
		this.benefitDAO = benefitDAO;
	}
	
	
	public void insertBenefit(BenefitVO benefitVO,String mem_Email,String pro_Name){
		
		benefitDAO.insert(benefitVO);
		memberService.MemberPurchaseUpdate("mem_Purchase.$.mem_ProCheck", mem_Email, pro_Name);
		productService.updateParty("pro_Party.$.mem_ProCheck", mem_Email, pro_Name);
		
		
		
	}
	

}
