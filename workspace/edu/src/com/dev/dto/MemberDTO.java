package com.dev.dto;

public class MemberDTO {
	private String id;
	private String pwd;
	private String name;
	private String email;
		
	public MemberDTO(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
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
