package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.ITransportsDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TransportsDao extends GenericDao<TransportsEntity> implements ITransportsDao {

    @Override
    public List<TransportsEntity> notAssignedTransports() {
        String hql = "FROM TransportsEntity T WHERE T.driversByDriverId.driverId = null";
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<TransportsEntity> getNotStartedTransports() {
        String hql = "FROM TransportsEntity T WHERE T.transportStatus = 'OCZEKUJE'";
        Query query = getSession().createQuery(hql);
        return query.list();
    }
}
