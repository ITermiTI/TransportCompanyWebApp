package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IClientsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IDriverDao;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    IDriverDao driverDao;

    public DatabaseUserDetails(UserAccountsEntity user) {

        userLogin=user.getLoginEmail();
        password=user.getPasswordHash();
        if(user.getIsEnabled().equals("0"))
            enabled=false;
        else enabled=true;
        if(driverDao.getById(user.getAccountId())!=null)
            authority=new SimpleGrantedAuthority("DRIVER");
        else
            authority=new SimpleGrantedAuthority("CLIENT");
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
