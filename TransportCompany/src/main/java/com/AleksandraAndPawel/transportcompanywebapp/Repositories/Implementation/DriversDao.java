package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.DriversEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IDriverDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
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
        if (out.size() == 0)
            return null;
        else
            return out.get(0);
    }
    @Override
    public List<TransportsEntity> getAllDriverTransports(int driversId) {
        String hql = "FROM TransportsEntity T WHERE T.driversByDriverId.driverId = :driver_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("driver_id", driversId);
        return query.list();
    }
}
