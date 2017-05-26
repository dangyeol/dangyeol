
package com.test.dangyel.service;

import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.DBObject;
import com.test.dangyel.dao.MemberDAO;
import com.test.dangyel.dto.MemberVO;
import com.test.dangyel.dto.PurchaseVO;

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

	public void MemberaddToUpdate(String fieldName, Object object, Map map) {

		Criteria criteria = new Criteria("mem_Email");
		criteria.is(map.get("mem_Email").toString());
		Query query = new Query(criteria);
		Update update = new Update();
		update.addToSet(fieldName, object);
		memberDAO.update(query, update);

	}
	
	@SuppressWarnings("static-access")
	public void MemberPurchaseUpdate(String fieldName,String mem_Email,String pro_Name){
		Criteria criteria = new Criteria("mem_Email");
		criteria.is(mem_Email);
		Query query = new Query(criteria);
		query.addCriteria(Criteria.where("mem_Purchase").elemMatch(Criteria.where("mem_ProName").is(pro_Name)));
		Update update = new Update();
		update.set(fieldName, "Y");
		memberDAO.update(query, update);
		
	}

	/*
	 * public void MemberEtcUpdate(Map map, String fieldName) {
	 * 
	 * 
	 * Criteria criteria = new Criteria("mem_Email");
	 * criteria.is(map.get("mem_Email")); Query query = new Query(criteria);
	 * Query findquery = new Query(criteria);
	 * findquery.addCriteria(Criteria.where(fieldName).is("1"));
	 * 
	 * MemberVO memberVO = memberDAO.findOne(query);
	 * 
	 * map.remove("mem_Email");
	 * 
	 * if (memberVO==null) { BasicDBList list = new BasicDBList(); BasicDBObject
	 * dbObject = new BasicDBObject(); Iterator<String> keys =
	 * map.keySet().iterator(); while (keys.hasNext()) { String key =
	 * keys.next(); dbObject.append(key, map.get(key).toString()); }
	 * list.add(dbObject); Update update = new Update(); update.set(fieldName,
	 * list); memberDAO.update(query, update); } else { BasicDBObject dbObject =
	 * new BasicDBObject(); Iterator<String> keys = map.keySet().iterator();
	 * while (keys.hasNext()) { String key = keys.next(); dbObject.append(key,
	 * map.get(key).toString()); } Update update = new Update();
	 * update.addToSet(fieldName, dbObject); memberDAO.update(query, update); }
	 * }
	 */
	public MemberVO CardFind(Map map) {
		Criteria criteria = new Criteria("mem_Email");
		criteria.is(map.get("mem_Email").toString());
		Query query = new Query(criteria);
		query.fields().include("mem_Card");
		MemberVO memberVO = memberDAO.findOne(query);
		System.out.println(memberVO.toString());
		return memberVO;
	}
	
	public PurchaseVO BuyList(Map map){
		
		Criteria criteria = new Criteria("mem_Email");
		criteria.is(map.get("mem_Email").toString());
		
		
		Query query = new Query(criteria);
		query.addCriteria(Criteria.where("mem_Purchase").elemMatch(Criteria.where("mem_ProCheck").is("Y")));
		query.fields().include("mem_Purchase");
		
		PurchaseVO purchaseVO =memberDAO.find(query);
		
		return purchaseVO;
		
	}
}
