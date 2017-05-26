package com.test.dangyel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.dangyel.dto.BenefitVO;
import com.test.dangyel.dto.CardMemberVO;
import com.test.dangyel.dto.ProductVO;
import com.test.dangyel.service.BenefitService;
import com.test.dangyel.service.CardMemberService;
import com.test.dangyel.service.MemberService;
import com.test.dangyel.service.ProductService;

@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	MemberService memberService;

	@Autowired
	ProductService productService;

	@Autowired
	CardMemberService cardMemberService;

	@Autowired
	BenefitService benefitService;

	@RequestMapping("/home")
	public String Main() {

		String url = "main/index";

		return url;

	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		String url = "login";

		return url;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody boolean login(@RequestBody Map<String, Object> map, HttpSession session) {

		boolean flag = false;

		String card_Id = map.get("card_Id").toString();
		String card_Pwd = map.get("card_Pwd").toString();
		System.out.println(card_Id);
		System.out.println(card_Pwd);

		Criteria criteria = new Criteria("card_Id");
		criteria.is(card_Id);
		Query query = new Query(criteria);

		CardMemberVO cardMemberVO = cardMemberService.CardMemberLogin(query, card_Pwd);

		if (cardMemberVO != null) {
			flag = true;
			session.setAttribute("cardMemberVO", cardMemberVO);
		}

		return flag;

	}

	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public String ProductList(HttpSession session) {

		CardMemberVO cardMemberVO = (CardMemberVO) session.getAttribute("cardMemberVO");

		String str = "main/productlist";

		Criteria criteria = new Criteria("pro_Party.mem_CardName");
		criteria.is(cardMemberVO.getCard_Name());

		Query query = new Query(criteria);
		query.addCriteria(Criteria.where("pro_Party.mem_ProCheck").is("N"));

		List<ProductVO> list = productService.ProductList(query);

		session.setAttribute("list", list);
		return str;

	}

	@RequestMapping(value = "/detailproduct")
	public String DetailProduct(HttpServletRequest request, HttpSession session) throws ParseException {
		String str = "main/detailproduct";
		CardMemberVO cardMemberVO = (CardMemberVO) session.getAttribute("cardMemberVO");

		Criteria criteria = new Criteria("pro_Name");
		criteria.is(request.getParameter("pro_Name"));
		Query query = new Query(criteria);
		query.addCriteria(Criteria.where("pro_Party").elemMatch(Criteria.where("mem_CardName").is(cardMemberVO.getCard_Name())));
		query.fields().include("pro_Party.mem_Email");

		ProductVO productVO = new ProductVO();
		productVO = productService.FindOne(query);
		/* String attr= "{\"pro_Party\":"+productVO.getPro_Party()+"}"; */

		List list = new ArrayList();

		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = (JsonArray) jsonParser.parse(productVO.getPro_Party());

		for (int i = 0; i < jsonArray.size(); i++) {

			JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
			String mem_Email = jsonObject.get("mem_Email").toString();
			String Email = mem_Email.replace("\"", "");
			list.add(Email);

		}
		request.setAttribute("pro_Name", request.getAttribute("pro_Name"));
		session.setAttribute("purchaselist", list);

		return str;

	}

	@RequestMapping(value = "/memapproval", method = RequestMethod.POST)
	public @ResponseBody int MemApproval(HttpServletRequest request,
			@RequestParam(value = "name", required = true) List<String> name,
			@RequestParam(value = "pro_Name", required = true) String pro_Name,
			@RequestParam(value = "mem_Point", required = true) String mem_Point, HttpSession session) {
		CardMemberVO cardMemberVO = (CardMemberVO) session.getAttribute("cardMemberVO");
		System.out.println(pro_Name);
		System.out.println(mem_Point);

		BenefitVO benefitVO = new BenefitVO();

		for (String value : name) {

			benefitVO.setMem_CardName(cardMemberVO.getCard_Name());
			benefitVO.setMem_Email(value);
			benefitVO.setPro_Name(pro_Name);
			benefitVO.setMem_Point(mem_Point);
			
			benefitService.insertBenefit(benefitVO, value, pro_Name);

		}
		
		
		int i = 1;
		return i;

	}

}
