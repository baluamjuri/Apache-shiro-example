package org.balu.learn.shiro.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="abv_user")
public class User {
	@Id
	private String username;
	
	@NotNull
	private String password;
	
	private String salt;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
            name="abv_user_role",
            joinColumns = @JoinColumn( name="username"),
            inverseJoinColumns = @JoinColumn( name="role"))
	private List<Role> roles;

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
