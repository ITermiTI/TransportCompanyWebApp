package com.AleksandraAndPawel.transportcompanywebapp.Services;

import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportsEntity;

import java.util.List;

public interface TransportService {
    public void startTransport(int transportId);
    public void endTransport(int transportId);
    public List<TransportsEntity> getAllDriversTransports(int driverId);
    public List<TransportsEntity> getAllNotAssignedTransports();
    public TransportsEntity getTransport(int transportId);
    public void assignDriver(int driverId,int transportId);
}
