package org.balu.learn.shiro.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="abv_role")
public class Role {
	@Id
	private String role;
	private String description;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
            name="abv_role_permission",
            joinColumns = @JoinColumn( name="role"),
            inverseJoinColumns = @JoinColumn( name="permission"))
	private List<Permission> permisssions;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Permission> getPermisssions() {
		return permisssions;
	}
	public void setPermisssions(List<Permission> permisssions) {
		this.permisssions = permisssions;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
