package com.backend.houserenting.security.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
	@Column(unique = true)
	private String userName;
	@NotNull
	private String email;
	@NotNull
	private String ph_number;
	@NotNull
	private String password;
	//Relación N a M, muchos usuarios,muchos roles
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	public User() {
	}

	public User(@NotNull String name, @NotNull String userName, @NotNull String email, @NotNull String ph_number,
			@NotNull String password) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.ph_number = ph_number;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPh_number() {
		return ph_number;
	}

	public void setPh_number(String ph_number) {
		this.ph_number = ph_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		roles = roles;
	}
	
}
