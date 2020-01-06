package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;

public interface ClientService {

    public ClientsEntity getClientByAccountId(int accountId);
}
