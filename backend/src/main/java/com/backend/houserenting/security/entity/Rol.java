package com.backend.houserenting.security.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.backend.houserenting.security.enumjwt.RolName;
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private RolName rolName;
	
	public Rol() {
	}
	
	public Rol(@NotNull RolName rolName) {
		this.rolName = rolName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public RolName getRolName() {
		return rolName;
	}

	public void setRolName(RolName rolName) {
		this.rolName = rolName;
	}
	
	
	
}
