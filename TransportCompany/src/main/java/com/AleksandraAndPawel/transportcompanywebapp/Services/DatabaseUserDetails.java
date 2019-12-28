package com.aleksandraandpawel.transportcompanywebapp.Services;

import com.aleksandraandpawel.transportcompanywebapp.Models.UserAccountsEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DatabaseUserDetails implements UserDetails {
    private String userLogin;
    private String password;
    private boolean enabled;
    private SimpleGrantedAuthority authority;

    public DatabaseUserDetails(UserAccountsEntity user) {

        userLogin=user.getLoginEmail();
        password=user.getPasswordHash();
        if(user.getIsEnabled().equals("0"))
            enabled=false;
        else enabled=true;
        authority=new SimpleGrantedAuthority("DRIVER");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {

        return password;
    }

    @Override
    public String getUsername() {
        return userLogin;
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
        return enabled;
    }
}
