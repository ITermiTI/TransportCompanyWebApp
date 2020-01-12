package com.AleksandraAndPawel.transportcompanywebapp.Repositories.API;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IPackagesDao extends IGenericDao<PackagesEntity> {
    List<PackagesEntity> findPackagesByClientId(int clientId);
    List<PackagesEntity> findPackagesByTransportId(int transportId);

}
