package com.chat.service;

import com.chat.data.jpa.model.Member;
import com.chat.web.model.MemberResultDto;

/**
 * Member CRUD service
 * 
 * @author leedu
 *
 */
public interface MemberService
{
	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public MemberResultDto signUp(Member member);
	
	/**
	 * 로그인
	 * @param member
	 * @return
	 */
	public MemberResultDto signIn(Member member);
}
