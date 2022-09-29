package com.backend.houserenting.security.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Controla la autoridad de los usuarios
public class MainUser implements UserDetails {
	private String nombre;
	private String userName;
	private String email;
	private String ph_number;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public MainUser() {
	}

	public MainUser(String nombre, String userName, String email, String ph_number, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.nombre = nombre;
		this.userName = userName;
		this.email = email;
		this.ph_number = ph_number;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static MainUser build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolName().name())).collect(Collectors.toList());
		return new MainUser (user.getName(),user.getUserName(),user.getEmail(),user.getPh_number(),user.getPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	
}
