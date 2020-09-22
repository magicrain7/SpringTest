package com.yedam.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired //getBean("memberDAO")이랑 같음
				//new memberDAO()
	DAO dao;
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		//회원조회
		model.addAttribute("list",dao.selectAll());
	
		return "/member/memberAll";
	}
	
	//등록처리
	@RequestMapping("/memberInsert")
	public String memberInsert(MemberVO vo) {
		System.out.println(vo);
		return "/memeber/memberList";
	}
}
