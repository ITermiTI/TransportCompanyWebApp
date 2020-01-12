package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportStatus;
import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IDriverDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.ITransportsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {
    @Autowired
    IDriverDao driverDao;
    @Autowired
    ITransportsDao transportDao;
    @Override
    public void startTransport(int transportId) {
        TransportsEntity transportsEntity = transportDao.getById(transportId);
        transportsEntity.setTransportStatus(TransportStatus.WTRASIE);
        transportDao.update(transportsEntity);
    }

    @Override
    public void endTransport(int transportId) {
        TransportsEntity transportsEntity = transportDao.getById(transportId);
        transportsEntity.setTransportStatus(TransportStatus.ZAKONCZONE);
        transportDao.update(transportsEntity);
    }

    @Override
    public List<TransportsEntity> getAllDriversTransports(int driverId) {

        return driverDao.getAllDriverTransports(driverId);
    }

    @Override
    public List<TransportsEntity> getAllNotAssignedTransports() {
        return transportDao.notAssignedTransports();
    }

    @Override
    public TransportsEntity getTransport(int transportId) {
        return transportDao.getById(transportId);
    }

    @Override
    public void assignDriver(int driverId, int transportId) {
        TransportsEntity transportsEntity = transportDao.getById(transportId);
        transportsEntity.setDriversByDriverId(driverDao.getById(driverId));
        transportDao.update(transportsEntity);
    }
}
