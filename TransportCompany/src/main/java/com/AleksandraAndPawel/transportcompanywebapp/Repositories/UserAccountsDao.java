package com.aleksandraandpawel.transportcompanywebapp.Repositories;

import com.aleksandraandpawel.transportcompanywebapp.Models.UserAccountsEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UserAccountsDao extends GenericDao<UserAccountsEntity> implements IUserAccountsDao{
    @Override
    public UserAccountsEntity getUserByLogin(String login_email) {

        Criteria criteria = getSession().createCriteria(UserAccountsEntity.class);

        return (UserAccountsEntity) criteria.add(Restrictions.eq("loginEmail",login_email))
                .uniqueResult();

    }
}
