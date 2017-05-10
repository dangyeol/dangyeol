package com.test.dangyel.service;

import java.util.Iterator;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.test.dangyel.dao.MemberDAO;
import com.test.dangyel.dto.MemberVO;

public class MemberService {

	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	DBObject dbObject;

	public int MemberJoin(Query query, MemberVO memberVO) {

		int result = -1;

		MemberVO mmemberVO = memberDAO.findOne(query);

		if (mmemberVO == null) {
			memberDAO.insert(memberVO);
			result = 1;
		}

		return result;

	}

	public MemberVO MemberLogin(Query query, String pwd) {

		MemberVO memberVO = (MemberVO) memberDAO.findOne(query);

		if (memberVO != null) {
			if (!memberVO.getMem_Pwd().equals(pwd)) {
				memberVO = null;
			}

		}

		return memberVO;

	}

	
	public void MemberEtcUpdate(Map map, String fieldName) {
		
		
		Criteria criteria = new Criteria("mem_Email");
		criteria.is(map.get("mem_Email"));
		Query query = new Query(criteria);
		Query findquery = new Query(criteria);
		findquery.addCriteria(Criteria.where(fieldName).is("1"));
     
		MemberVO memberVO = memberDAO.findOne(query);
       
		map.remove("mem_Email");

		if (memberVO==null) {
			BasicDBList list = new BasicDBList();
			BasicDBObject dbObject = new BasicDBObject();

			Iterator<String> keys = map.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				dbObject.append(key, map.get(key).toString());
			}

			list.add(dbObject);
			Update update = new Update();
			update.set(fieldName, list);
			memberDAO.update(query, update);
		} else {
			BasicDBObject dbObject = new BasicDBObject();
			Iterator<String> keys = map.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				dbObject.append(key, map.get(key).toString());
			}

			Update update = new Update();
			update.addToSet(fieldName, dbObject);

			memberDAO.update(query, update);

		}

	}

}
