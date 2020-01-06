package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import com.AleksandraAndPawel.transportcompanywebapp.dto.PackageDto;

import java.util.List;

public interface PackageService {
    public List<PackagesEntity> getAllPackagesByClientId(int clientId);
    public void addPackage(PackageDto packageDto);
}
