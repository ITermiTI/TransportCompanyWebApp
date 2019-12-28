package com.aleksandraandpawel.transportcompanywebapp.Repositories;

import com.aleksandraandpawel.transportcompanywebapp.Models.UserAccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface IUserAccountsDao extends IGenericDao<UserAccountsEntity> {
    //Tu wprowadzimy kwerendu ma tabeli useraccounts = dao = data access object
    public UserAccountsEntity getUserByLogin(String login);
}
