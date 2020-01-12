package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.*;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.ClientsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.PackagesDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.RecipientDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation.TransportsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Web.PackageDto;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
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
        // Automatyczne wyciagniecie zalogowanego uzytkownika
        DatabaseUserDetails d = (DatabaseUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Na podstawie calego obiektu zalogowanego uzytkownika, bierzemy id konta tego uzytkownika (account_id)
        ClientsEntity clientsEntity = clientsDao.getClientByAccountId(d.getUserAccountsEntity().getAccountId());
        PackagesEntity packagesEntity = new PackagesEntity();
        Date date = new Date();
        packagesEntity.setPackageDate(new Timestamp(date.getTime()));

        packagesEntity.setPackageType(packageDto.getPackageType());
        packagesEntity.setPackageStatus(PackageStatus.NIEODEBRANE);

        BigDecimal weight =new BigDecimal(packageDto.getPackageWeight());
        packagesEntity.setPackageWeight(weight);
        BigDecimal price = new BigDecimal(String.valueOf(weight.multiply(new BigDecimal("1.5"))));
        packagesEntity.setPackagePrice(price);
        packagesEntity.setPackagePriority(packageDto.getPackagePriority());

        RecipientsEntity recipientsEntity = new RecipientsEntity();
        recipientsEntity.setRecipientName(packageDto.getRecipientName());
        recipientsEntity.setRecipientSurname(packageDto.getRecipientSurname());
        recipientsEntity.setRecipientAddress(packageDto.getRecipientAddress());
        recipientsEntity.setRecipientCity(packageDto.getRecipientCity());
        recipientsEntity.setRecipientPhoneNumber(packageDto.getRecipientPhoneNumber());

        recipientDao.add(recipientsEntity);

        packagesEntity.setRecipientsByRecipientId(recipientsEntity);

        List<TransportsEntity> notStartedTransports = transportsDao.getNotStartedTransports();
        boolean assigned = false;
        for (TransportsEntity transport: notStartedTransports
             ) {
            List<PackagesEntity> packs = packagesDao.findPackagesByTransportId(transport.getTransportId());
            ClientsEntity client = packs.get(0).getClientsByClientId();
            if (client.getClientCity().equals(clientsEntity.getClientCity()) ) {
                assigned = true;
                packagesEntity.setTransportsByTransportId(transport);
            }
            if (assigned) break;
        }
        if(!assigned)
        {
            for (TransportsEntity transport: notStartedTransports
                 ) {
                if(transport.getTransportCity().equals(recipientsEntity.getRecipientCity()))
                {
                    assigned=true;
                    packagesEntity.setTransportsByTransportId(transport);
                }
                if(assigned)break;
            }
        }
        if(!assigned)
        {
            TransportsEntity transportsEntity = new TransportsEntity();
            transportsEntity.setTransportStatus(TransportStatus.OCZEKUJE);
            transportsEntity.setTransportCity(recipientsEntity.getRecipientCity());
            transportsEntity.setDriversByDriverId(null);
            transportsDao.add(transportsEntity);
            packagesEntity.setTransportsByTransportId(transportsEntity);
        }

        packagesEntity.setClientsByClientId(clientsEntity);

        packagesDao.add(packagesEntity);
    }

    @Override
    public List<PackagesEntity> getAllPackagesInTransport(int transportId) {
        return packagesDao.findPackagesByTransportId(transportId);
    }

    @Override
    public RecipientsEntity getRecipientByPackageId(int packageId) {
        return packagesDao.getById(packageId).getRecipientsByRecipientId();
    }

    @Override
    public PackageDto setUpPackageDto(PackagesEntity pack) {
        PackageDto packageDto = new PackageDto();
        packageDto.setPackageId(pack.getPackageId());
        packageDto.setPackagePrice(pack.getPackagePrice().toString());
        packageDto.setPackagePriority(pack.getPackagePriority());
        packageDto.setPackageType(pack.getPackageType());
        packageDto.setPackageWeight(pack.getPackageWeight().toString());
        packageDto.setPackageStatus(pack.getPackageStatus());
        RecipientsEntity recipient = getRecipientByPackageId(pack.getPackageId());
        packageDto.setRecipientAddress(recipient.getRecipientAddress());
        packageDto.setRecipientCity(recipient.getRecipientCity());
        packageDto.setRecipientName(recipient.getRecipientName());
        packageDto.setRecipientSurname(recipient.getRecipientSurname());
        packageDto.setRecipientPhoneNumber(recipient.getRecipientPhoneNumber());
        return packageDto;
    }

    @Override
    public PackagesEntity getPackageById(int packageId) {
        return packagesDao.getById(packageId);
    }

    @Override
    public void pickUpPackage(PackagesEntity pack) {
        pack.setPackageStatus(PackageStatus.ODEBRANE);
        packagesDao.update(pack);
    }

    @Override
    public void deliverPackage(PackagesEntity pack) {
        pack.setPackageStatus(PackageStatus.DOSTARCZONE);
        packagesDao.update(pack);
    }
}
