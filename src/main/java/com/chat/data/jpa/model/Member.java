package com.chat.data.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@SequenceGenerator(name= "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Member
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MEMBER_SEQ_GENERATOR")
	@Column(name = "id")
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "enterprise")
	private String enterprise;
	
	@Column(name = "nickname")
	private String nickname;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEnterprise()
	{
		return enterprise;
	}

	public void setEnterprise(String enterprise)
	{
		this.enterprise = enterprise;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
}
