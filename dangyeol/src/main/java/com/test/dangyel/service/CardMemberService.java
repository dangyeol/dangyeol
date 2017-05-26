package com.test.dangyel.service;

import org.springframework.data.mongodb.core.query.Query;

import com.test.dangyel.dao.CardMemberDAO;
import com.test.dangyel.dto.CardMemberVO;

public class CardMemberService {
	
	
	private CardMemberDAO cardMemberDAO;

	public void setCardMemberDAO(CardMemberDAO cardMemberDAO) {
		this.cardMemberDAO = cardMemberDAO;
	}
	
	public CardMemberVO CardMemberLogin(Query query, String pwd) {

		CardMemberVO cardMemberVO = (CardMemberVO) cardMemberDAO.findOne(query);
        System.out.println(cardMemberVO);
		if (cardMemberVO != null) {
			if (!cardMemberVO.getCard_Pwd().equals(pwd)) {
				cardMemberVO = null;
			}

		}

		return cardMemberVO;

	}

}
