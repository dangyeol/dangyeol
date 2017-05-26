package com.test.dangyel.controller;

import java.util.List;
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
import com.test.dangyel.dto.CardVO;
import com.test.dangyel.dto.MemberVO;
import com.test.dangyel.dto.PurchaseVO;
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
	public @ResponseBody boolean CardRegist(@RequestBody Map<String, Object> map) {
        System.out.println("dddd");
		boolean flag = true;

		CardVO cardVO = new CardVO();
		cardVO.setMem_CardName(map.get("mem_CardName").toString());
		cardVO.setMem_CardNum(map.get("mem_CardNum").toString());
		cardVO.setMem_CardPeriod(map.get("mem_CardPeriod").toString());

		memberService.MemberaddToUpdate("mem_Card", cardVO, map);
		return flag;
	}

	@RequestMapping(value = "/cardfind", method = RequestMethod.POST)
	public @ResponseBody MemberVO CardFind(@RequestBody Map<String, Object> map) {

		MemberVO memberVO = memberService.CardFind(map);
		return memberVO;

	}

	@RequestMapping(value = "/buylist", method = RequestMethod.POST)
	public @ResponseBody PurchaseVO BuyList(@RequestBody Map<String, Object> map) {

		PurchaseVO  purchaseVO = memberService.BuyList(map);
		
		return purchaseVO;

	}

}
