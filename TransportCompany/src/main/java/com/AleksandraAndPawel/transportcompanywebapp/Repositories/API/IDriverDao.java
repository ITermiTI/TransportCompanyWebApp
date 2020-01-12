package com.AleksandraAndPawel.transportcompanywebapp.Repositories.API;

import com.AleksandraAndPawel.transportcompanywebapp.Models.DriversEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportsEntity;

import java.util.List;

public interface IDriverDao extends IGenericDao<DriversEntity> {

    DriversEntity getByAccountId(int accountId);
    public List<TransportsEntity> getAllDriverTransports(int driversId);
}
