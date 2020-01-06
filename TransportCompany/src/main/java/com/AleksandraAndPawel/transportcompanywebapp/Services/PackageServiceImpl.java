package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.*;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.ClientsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.PackagesDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.RecipientDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.TransportsDao;
import com.AleksandraAndPawel.transportcompanywebapp.dto.PackageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackagesDao packagesDao;

    @Autowired
    private RecipientDao recipientDao;

    @Autowired
    private TransportsDao transportsDao;

    @Autowired
    private ClientsDao clientsDao;

    @Override
    public List<PackagesEntity> getAllPackagesByClientId(int clientId) {
        return packagesDao.findPackagesByClientId(clientId);
    }


    @Override
    public void addPackage(PackageDto packageDto) {
        PackagesEntity packagesEntity = new PackagesEntity();
        Date date = new Date();
        packagesEntity.setPackageDate(new Timestamp(date.getTime()));

        packagesEntity.setPackageType(packageDto.getPackageType());
        packagesEntity.setPackageStatus(PackageStatus.ODEBRANE);

        packagesEntity.setPackageWeight(new BigDecimal(packageDto.getPackageWeight()));
        packagesEntity.setPackagePrice(new BigDecimal(packageDto.getPackagePrice()));
        packagesEntity.setPackagePriority(packageDto.getPackagePriority());

        RecipientsEntity recipientsEntity = new RecipientsEntity();
        recipientsEntity.setRecipientName(packageDto.getRecipientName());
        recipientsEntity.setRecipientSurname(packageDto.getRecipientSurname());
        recipientsEntity.setRecipientAddress(packageDto.getRecipientAddress());
        recipientsEntity.setRecipientCity(packageDto.getRecipientCity());
        recipientsEntity.setRecipientPhoneNumber(packageDto.getRecipientPhoneNumber());

        recipientDao.add(recipientsEntity);

        packagesEntity.setRecipientsByRecipientId(recipientsEntity);

        TransportsEntity transportsEntity = transportsDao.getById(1);
        packagesEntity.setTransportsByTransportId(transportsEntity);

        // Automatyczne wyciagniecie zalogowanego uzytkownika
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Na podstawie calego obiektu zalogowanego uzytkownika, bierzemy id konta tego uzytkownika (account_id)
        ClientsEntity clientsEntity = clientsDao.getClientByAccountId(d.getUserAccountsEntity().getAccountId());
        packagesEntity.setClientsByClientId(clientsEntity);

        packagesDao.add(packagesEntity);
    }
}
