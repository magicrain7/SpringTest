package com.yedam.app.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberSpringDAO implements DAO  {

	@Autowired JdbcTemplate template;
	
	final static String INSERT_MEMBER = "INSERT INTO MEMBER(ID , PW, JOB, GENDER, MAILYN,REASON ,HOBBY, REGDATE)" 
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, SYSDATE )";
	
	final static String DELETE_MEMBER = "DELETE FROM MEMBER WHERE ID = ?";
	
	final static String SELECT_MEMBER = " SELECT * FROM MEMBER WHERE ID= ?";
	final static String SELECT_ALL_MEMBER = "SELECT * FROM MEMBER ";

	
	@Override
	public int insert(MemberVO memberVO) {
		System.out.println( "Spring Insert");
		Object[] args = {memberVO.getId(), memberVO.getPw(), memberVO.getJob(), 
						memberVO.getGender(), memberVO.getMailyn(),
						memberVO.getReason(), memberVO.getHobby()};
		template.update(INSERT_MEMBER,args);
		return template.update(INSERT_MEMBER, args);
	}
	
	@Override
	public int delete(MemberVO memberVO) {
		System.out.println(" Spring Delete");
		String args =  memberVO.getId();
		return template.update(DELETE_MEMBER,args);
	}
	
	@Override
	public MemberVO selectOne(MemberVO memberVO) {
		Object[] args = {};
		return template.queryForObject(SELECT_MEMBER, args,new MemberRowMapper());
	}

	@Override
	public ArrayList<MemberVO> selectAll() {
		return (ArrayList<MemberVO>) template.query(SELECT_ALL_MEMBER, new MemberRowMapper());
	}

	@Override
	public int update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int getMailynCnt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HashMap<String, Object>> getGenderCnt() {
		// TODO Auto-generated method stub
		return null;
	}
	
	class MemberRowMapper implements RowMapper<MemberVO> {

		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO member = MemberVO.builder().build();
			member = MemberVO.builder().build(); 
			member.setId(rs.getString(1));
			member.setPw(rs.getString(2));
			member.setJob(rs.getString(3));
			member.setGender(rs.getString(4));
			member.setMailyn(rs.getString(5));
			member.setReason(rs.getString(6));
			member.setHobby(rs.getString(7));
			return member;
		}
		
		
	}
}
