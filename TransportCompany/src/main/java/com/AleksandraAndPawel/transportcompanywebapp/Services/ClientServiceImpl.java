package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.ClientsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientsDao clientsDao;

    @Override
    public ClientsEntity getClientByAccountId(int accountId) {
        return clientsDao.getClientByAccountId(accountId);
    }
}
