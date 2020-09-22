package com.yedam.app.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:config/datasource-context.xml" })
public class MemberDAOClient {

	@Autowired
	DAO dao;

	/*
	 * @Ignore @Test public void selectTest() { MemberVO memberVO =
	 * MemberVO.builder().id("ccc").build(); // 생성자를 대신해주는게 빌더 , 아이디 비번 초기화
	 * dao.insert(memberVO); memberVO = dao.selectOne(memberVO);
	 * assertEquals("1111", memberVO.getPw()); }
	 */

 @Test
	public void insertTeet() {
		MemberVO memberVO = MemberVO.builder().id("hhh").pw("222") // 생성자를 대신해주는게 빌더 , 아이디 비번 초기화
							.hobby("ski").reason("....").build();
		dao.insert(memberVO);
		/*
		 * memberVO = dao.selectOne(memberVO); assertNotNull(memberVO);
		 */
	}
//	@Test
	public void delete() {
		MemberVO memberVO = MemberVO.builder()
							.id("ddd").build();
		dao.delete(memberVO);
	}
	
//	@Test
	public void selectTest() {
		MemberVO memberVO = MemberVO.builder().id("123").build();
		memberVO = dao.selectOne(memberVO);
		assertEquals("1111", memberVO.getPw());
			
	}
//	@Test
	public void selectAlltest() {
		dao.selectAll();
	}
}
