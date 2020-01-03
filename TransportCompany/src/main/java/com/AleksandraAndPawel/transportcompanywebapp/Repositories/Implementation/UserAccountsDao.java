package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IUserAccountsDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserAccountsDao extends GenericDao<UserAccountsEntity> implements IUserAccountsDao {
    @Override
    public UserAccountsEntity getUserByLogin(String login_email) {

        Criteria criteria = getSession().createCriteria(UserAccountsEntity.class);

        return (UserAccountsEntity) criteria.add(Restrictions.eq("loginEmail",login_email))
                .uniqueResult();

    }
}
