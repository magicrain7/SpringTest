package com.yedam.app.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class MemberVO {
	public String id;
	public String pw;
	public String job;
	public String gender;
	public String mailyn;
	public String reason;
	public String hobby;
	public String regdate;
	
	
}
