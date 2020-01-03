package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IUserAccountsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserAccountsDao userAccountsDao;
    @Override
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        UserAccountsEntity user = userAccountsDao.getUserByLogin(userLogin);
        if (user == null) {
            new UsernameNotFoundException("There is no user with login: " + userLogin);
        }
        return new DatabaseUserDetails(user);
    }
}
