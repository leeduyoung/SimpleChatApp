package com.chat.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.data.jpa.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>
{
	public Member findByEmail(String email);
	public Member findByNickname(String nickname);
}
