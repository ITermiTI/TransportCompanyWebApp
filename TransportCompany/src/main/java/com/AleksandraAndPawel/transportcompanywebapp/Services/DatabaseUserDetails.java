package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IClientsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IDriverDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DatabaseUserDetails implements UserDetails {
    private String userLogin;
    private String password;
    private boolean enabled;
    private SimpleGrantedAuthority authority;
    private UserAccountsEntity userAccountsEntity;


    public DatabaseUserDetails(UserAccountsEntity user, String role) {

        userLogin=user.getLoginEmail();
        password=user.getPasswordHash();
        if(user.getIsEnabled().equals("0"))
            enabled=false;
        else enabled=true;

        authority=new SimpleGrantedAuthority(role);
        this.userAccountsEntity = user;
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

    public UserAccountsEntity getUserAccountsEntity() {
        return userAccountsEntity;
    }

    public void setUserAccountsEntity(UserAccountsEntity userAccountsEntity) {
        this.userAccountsEntity = userAccountsEntity;
    }
}
