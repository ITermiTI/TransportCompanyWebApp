package com.AleksandraAndPawel.transportcompanywebapp.Repositories.API;

import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportsEntity;

import java.util.List;

public interface ITransportsDao extends IGenericDao<TransportsEntity> {
    public List<TransportsEntity> notAssignedTransports();
    public List<TransportsEntity> getNotStartedTransports();
}
