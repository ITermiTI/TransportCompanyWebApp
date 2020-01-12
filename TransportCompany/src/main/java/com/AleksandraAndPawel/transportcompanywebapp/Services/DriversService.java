package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.DriversEntity;

public interface DriversService {
    public DriversEntity getDriverByAccountId(int accountId);
}
