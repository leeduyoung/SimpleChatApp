package com.chat.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chat.data.jpa.model.Member;
import com.chat.data.jpa.repository.MemberRepository;
import com.chat.service.MemberService;
import com.chat.web.model.MemberResultDto;

@Component
public class MemberServiceImpl implements MemberService
{
	private final Logger systemLog = LoggerFactory.getLogger("systemLog");
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public MemberResultDto signUp(Member member)
	{
		MemberResultDto memberResultDto = null;

		if (member == null)
		{
			systemLog.error("Failed to signup. member object is null..");
			return memberResultDto;
		}

		try
		{
			memberResultDto = new MemberResultDto();
			memberResultDto.setSuccess(false);
			
			if (emailCheck(member) != null)
			{
				systemLog.info("Failed to add member in database. already exist member email : {}", member.getEmail());
				memberResultDto.setReason("이미 가입된 이메일 주소 입니다.");
				return memberResultDto;
			}
			
			if (nickNameCheck(member) != null)
			{
				systemLog.info("Failed to add member in database. already exist nickname : {}", member.getNickname());
				memberResultDto.setReason("이미 가입된 닉네임 입니다.");
				return memberResultDto;
			}

			// 멤버추가
			Member newMember = memberRepository.save(member);

			memberResultDto.setSuccess(true);
			memberResultDto.setMember(newMember);
			return memberResultDto;
		}
		catch (Exception e)
		{
			systemLog.error("Failed to addMember in database.", e);
			return null;
		}
	}

	@Override
	public MemberResultDto signIn(Member member)
	{
		MemberResultDto memberResultDto = null;

		if (member == null)
		{
			systemLog.error("Failed to signin. member object is null..");
			return memberResultDto;
		}

		try
		{
			memberResultDto = new MemberResultDto();
			memberResultDto.setSuccess(false);

			Member dbMember = memberRepository.findByEmail(member.getEmail());

			if (dbMember == null)
			{
				// 회원 아이디를 찾을 수 없습니다.
				systemLog.error("Not found member email. email : {}", member.getEmail());
				memberResultDto.setReason("가입되지 않은 이메일 주소입니다.");
				return memberResultDto;
			}
			
			if(!dbMember.getPassword().equals(member.getPassword()))
			{
				// 회원 비밀번호가 틀렸습니다.
				systemLog.debug("Password was wrong. member : {}", member.toString());
				memberResultDto.setReason("비밀번호가 잘못되었습니다.");
				return memberResultDto;
			}

			memberResultDto.setSuccess(true);
			memberResultDto.setMember(dbMember);
			return memberResultDto;
		}
		catch (Exception e)
		{
			// DB 에러
			systemLog.error("Failed to login in database. member email : {}", member.getEmail(), e);
			return null;
		}
	}
	
	private Member emailCheck(Member member) throws Exception
	{// email(id)이 uniuque 한지 검사 (null이면 unique한 것으로 판단)
		return memberRepository.findByEmail(member.getEmail());
	}

	private Member nickNameCheck(Member member) throws Exception
	{// nickName이 uniuque 한지 검사 (null이면 unique한 것으로 판단)
		return memberRepository.findByNickname(member.getNickname());
	}
}
