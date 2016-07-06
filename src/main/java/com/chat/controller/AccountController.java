package com.chat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chat.data.jpa.model.Member;
import com.chat.data.jpa.repository.MemberRepository;
import com.chat.service.MemberService;
import com.chat.web.model.MemberResultDto;

@RestController
@RequestMapping(value = "/account")
public class AccountController
{
	private final Logger systemLog = LoggerFactory.getLogger("systemLog");

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public MemberResultDto signup(@RequestBody Member member)
	{
		systemLog.info("try to sign up..");
		MemberResultDto memberResultDto = memberService.signUp(member);
		return memberResultDto;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberResultDto login(@RequestBody Member member)
	{
		systemLog.info("try to login..");
		MemberResultDto memberResultDto = memberService.signIn(member);
		return memberResultDto;
	}

//	@RequestMapping(value = "/linked/login", method = RequestMethod.POST)
//	public Boolean linkedLogin(@RequestBody Member member)
//	{
//		systemLog.info("linked login..");
//		return null;
//	}
}
