package com.exam.model;
//管理员对象封装定义

public class Admin {
	private int id ;   //管理员id
	private String username;  //管理员姓名
	private String password;  //管理员密码
	private int status; //邀请码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password=" + password + ", status=" + status + "]";
	}
	

}
