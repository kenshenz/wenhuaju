package com.wenhuaju.po;

/**
 * 后台用户
 * @author ccf
 * @date 2016年3月16日
 *
 */
public class XUser {

	/*主键*/
	private String id;

	/*用户名*/
	private String username;

	/*密码*/
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public String toString() {
		return "XUser [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

}
