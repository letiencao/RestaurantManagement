package com.letiencao.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.letiencao.entity.RoleEntity;
import com.letiencao.entity.UserEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private UserEntity userEntity;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println(userEntity.toString());
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		for (RoleEntity roleEntity : userEntity.getRoleEntities()) {
			list.add(new SimpleGrantedAuthority(roleEntity.getName()));
		}
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEntity.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
