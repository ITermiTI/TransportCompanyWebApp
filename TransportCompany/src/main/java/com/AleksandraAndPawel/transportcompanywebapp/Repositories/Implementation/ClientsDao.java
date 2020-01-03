package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IClientsDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ClientsDao extends GenericDao<ClientsEntity> implements IClientsDao {
}
