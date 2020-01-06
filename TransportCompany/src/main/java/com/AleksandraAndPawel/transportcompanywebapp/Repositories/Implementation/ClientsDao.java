package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IClientsDao;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ClientsDao extends GenericDao<ClientsEntity> implements IClientsDao {

    @Override
    public ClientsEntity getClientByAccountId(int accountId) {
        String hql = "FROM ClientsEntity C WHERE C.accountId = :account_id";
        Query query = getSession().createQuery(hql);
        query.setParameter("account_id", accountId);
        List<ClientsEntity> out = query.list();
        if (out.size() == 0)
            return null;
        else
            return out.get(0);
    }
}
