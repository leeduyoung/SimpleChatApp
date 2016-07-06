package com.chat.web.model;

import com.chat.data.jpa.model.Member;

public class MemberResultDto
{
	private boolean success;
	private Member member;
	private String reason;

	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public Member getMember()
	{
		return member;
	}

	public void setMember(Member member)
	{
		this.member = member;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}
}
