package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IPackagesDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    public List<PackagesEntity> findPackagesByTransportId(int transportId) {
        List<PackagesEntity> packagesEntities =getAll();
        List<PackagesEntity> transportsPackages = new ArrayList();
        for (PackagesEntity pack: packagesEntities
             ) {
            if(pack.getTransportsByTransportId().getTransportId()==transportId)
                transportsPackages.add(pack);
        }
        return transportsPackages;
    }
}
