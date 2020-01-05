package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.DriversEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IDriverDao;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class DriversDao extends GenericDao<DriversEntity> implements IDriverDao {

    @Override
    public DriversEntity getByAccountId(int accountId) {
        String hql = "FROM DriversEntity D WHERE D.userAccountsByAccountId.accountId = :account_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("account_id", accountId);
        List<DriversEntity> out = query.list();
        return out.get(0);
    }
}
