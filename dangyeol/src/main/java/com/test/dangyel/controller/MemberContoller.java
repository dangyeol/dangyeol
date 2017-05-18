package com.test.dangyel.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dangyel.common.RSA;
import com.test.dangyel.dto.MemberVO;
import com.test.dangyel.service.MemberService;

@Controller
@RequestMapping("member")
@SuppressWarnings("deprecation")
public class MemberContoller {

	@Autowired
	private MemberService memberService;

	RSA rsa;

	@RequestMapping(value = "/memberjoin", method = RequestMethod.POST)
	public @ResponseBody int MemberJoin(@RequestBody Map<String, Object> map) {

		int result;

		MemberVO memberVO = new MemberVO();
		memberVO.setMem_Email(map.get("mem_Email").toString());
		memberVO.setMem_Pwd(map.get("mem_Pwd").toString());
		memberVO.setMem_Name(map.get("mem_Name").toString());

		Criteria criteria = new Criteria("mem_Email");
		criteria.is(map.get("mem_Email").toString());
		Query query = new Query(criteria);

		result = memberService.MemberJoin(query, memberVO);

		System.out.println(result);
		return result;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody MemberVO Login(@RequestBody Map<String, Object> map) {

		String mem_Email = map.get("mem_Email").toString();
		String mem_Pwd = map.get("mem_Pwd").toString();

		Criteria criteria = new Criteria("mem_Email");
		criteria.is(mem_Email);
		Query query = new Query(criteria);

		MemberVO memberVO = memberService.MemberLogin(query, mem_Pwd);

		return memberVO;
	}

	@RequestMapping(value = "/cardregist", method = RequestMethod.POST)
	public void CardRegist(@RequestBody Map<String, Object> map) {

		memberService.MemberEtcUpdate(map,"mem_Card");
	}
	
	
	@RequestMapping(value="/cardfind",method=RequestMethod.POST)
	public @ResponseBody MemberVO CardFind(@RequestBody Map<String,Object> map){
		
	MemberVO memberVO= memberService.CardFind(map);
	
	return memberVO;
		
		
	}
	
	
	@RequestMapping(value="productbuy", method=RequestMethod.POST)
	public void ProductBuy(@RequestBody Map<String,Object> map){
		
		
		memberService.MemberEtcUpdate(map, "mem_Purchase");
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
