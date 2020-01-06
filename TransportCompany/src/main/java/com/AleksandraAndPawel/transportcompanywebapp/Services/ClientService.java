package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.dto.ClientDto;

public interface ClientService {

    public ClientsEntity getClientByAccountId(int accountId);
    public void updateClient(ClientDto clientDto);
}
