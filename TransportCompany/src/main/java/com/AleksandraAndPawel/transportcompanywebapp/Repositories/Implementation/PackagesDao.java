package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IPackagesDao;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PackagesDao extends GenericDao<PackagesEntity> implements IPackagesDao {
    @Override
    public List<PackagesEntity> findPackagesByClientId(int clientId) {
        String hql = "FROM PackagesEntity P WHERE P.clientsByClientId.clientId = :client_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("client_id", clientId);
        return query.list();
    }
}
