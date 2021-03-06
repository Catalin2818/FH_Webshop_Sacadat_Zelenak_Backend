package com.fhproject.security;

import com.fhproject.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


public class CustomUserDetail implements UserDetails {

    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;
    private String role;

    public CustomUserDetail(String userName) {
        this.username = userName;
    }

    public CustomUserDetail(User user) {
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
        this.role = user.getRole();


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getUsername() {
        return username;
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
        return active;
    }
}
