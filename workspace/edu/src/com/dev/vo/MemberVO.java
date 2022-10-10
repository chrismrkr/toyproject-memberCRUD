package com.dev.vo;

import java.util.concurrent.atomic.AtomicLong;

import com.dev.dto.MemberDTO;

public class MemberVO {
	private static AtomicLong PRIMARY_KEY = new AtomicLong(1);
	
	private Long key;
	private String id, pwd, name, email;
	public MemberVO(MemberDTO dto) {
		this.key = PRIMARY_KEY.getAndIncrement();
		this.id = dto.getId();
		this.pwd = dto.getPwd();
		this.name = dto.getName();
		this.email = dto.getEmail();
	}
	
	public Long getKey() {
		return key;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
}
