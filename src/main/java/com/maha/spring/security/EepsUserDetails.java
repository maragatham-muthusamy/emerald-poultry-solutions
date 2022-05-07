package com.maha.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.maha.spring.entity.Role;
import com.maha.spring.entity.User;

public class EepsUserDetails implements UserDetails {

	public static final long serialVersionUID = 919292938;
	private User user;
	
	public EepsUserDetails(User user) {
		this.user = user;
	}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
         
        return authorities;
    }

	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	public String getFirstName() {
		return user.getFirstName();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName() {
		return user.getFirstName() + " " + user.getLastName();
	}
	
	public Long getId() {
		return user.getId();
	}
	
	public boolean hasRole(String role) {
		return this.user.hasRole(role);
	}

}
