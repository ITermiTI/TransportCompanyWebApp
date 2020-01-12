package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.DriversEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IDriverDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriversService {
    @Autowired
    IDriverDao driverDao;
    @Override
    public DriversEntity getDriverByAccountId(int accountId) {
        return driverDao.getByAccountId(accountId);
    }
}
