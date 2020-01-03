package com.AleksandraAndPawel.transportcompanywebapp.Repositories.API;

import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAccountsDao extends IGenericDao<UserAccountsEntity> {
    //Tu wprowadzimy kwerendu ma tabeli useraccounts = dao = data access object
    public UserAccountsEntity getUserByLogin(String login);
}
