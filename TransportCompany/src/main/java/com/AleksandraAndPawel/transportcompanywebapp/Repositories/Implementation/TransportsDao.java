package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.TransportsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.ITransportsDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TransportsDao extends GenericDao<TransportsEntity> implements ITransportsDao {
}
