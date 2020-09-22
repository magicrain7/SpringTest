package com.yedam.app.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DAO {

	//전체조회
	ArrayList<MemberVO> selectAll();

	//단건 조회
	MemberVO selectOne(MemberVO memberVO);

	//삭제
	int delete(MemberVO memberVO);

	//수정
	int update(MemberVO memberVO);

	//insert
	int insert(MemberVO memberVO);

	//select count(id) from member where mailyn ='y'
	int getMailynCnt();

	//성별 인원수 :select gender, count(id) cnt from member group by gender
	List<HashMap<String, Object>> getGenderCnt();

}