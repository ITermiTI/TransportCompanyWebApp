package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.RecipientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Web.PackageDto;

import java.util.List;

public interface PackageService {
    public List<PackagesEntity> getAllPackagesByClientId(int clientId);
    public void addPackage(PackageDto packageDto);
    public List<PackagesEntity> getAllPackagesInTransport(int transportId);
    public RecipientsEntity getRecipientByPackageId(int packageId);
    public PackageDto setUpPackageDto(PackagesEntity pack);
    public PackagesEntity getPackageById(int packageId);
    public void pickUpPackage(PackagesEntity pack);
    public void deliverPackage(PackagesEntity pack);
}
