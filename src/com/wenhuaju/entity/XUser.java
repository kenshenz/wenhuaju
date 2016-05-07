package com.wenhuaju.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 后台用户
 * @author ccf
 * @date 2016年3月16日
 *
 */
@Entity
@Table(name="xuser")
public class XUser {

	/*主键*/
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="uuid")
	private String id;

	/*用户名*/
	@Column(name="username")
	private String username;

	/*密码*/
	@Column(name="password")
//	@Temporal(TemporalType.TIMESTAMP)
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
