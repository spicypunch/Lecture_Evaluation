package com.jm.dto;

public class MemberVO {
	private int stu_id;
	private String pwd;
	private String name;
	private String email;
	private String phone_num;

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	@Override
	public String toString() {
		return "MemberVO [stu_id=" + stu_id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", phone_num="
				+ phone_num + "]";
	}
	
}
