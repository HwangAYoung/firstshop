package com.shop.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.shop.mappers.memberMapper";

	//회원가입
	@Override
	public void signup(MemberVO vo) throws Exception {
		sql.insert(namespace + ".signup",vo);
	}

	//로그인
	@Override
	public MemberVO signin(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".signin",vo);
	}

	//아이디 확인
	@Override
	public MemberVO idCheck(String userID) throws Exception {
		return sql.selectOne(namespace + ".idcheck", userID);
	}

}
