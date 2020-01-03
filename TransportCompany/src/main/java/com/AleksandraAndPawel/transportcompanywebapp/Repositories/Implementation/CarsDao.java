package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.CarsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.ICarsDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarsDao extends GenericDao<CarsEntity> implements ICarsDao {
}
