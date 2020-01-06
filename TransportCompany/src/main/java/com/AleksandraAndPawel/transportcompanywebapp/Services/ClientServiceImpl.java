package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.ClientsDao;
import com.AleksandraAndPawel.transportcompanywebapp.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientsDao clientsDao;

    @Override
    public ClientsEntity getClientByAccountId(int accountId) {
        return clientsDao.getClientByAccountId(accountId);
    }

    @Override
    public void updateClient(ClientDto clientDto) {
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ClientsEntity clientsEntity = getClientByAccountId(d.getUserAccountsEntity().getAccountId());
        clientsEntity.setClientAddress(clientDto.getAddress());
        clientsEntity.setClientPhoneNumber(clientDto.getPhoneNumber());
        clientsDao.update(clientsEntity);
    }
}
