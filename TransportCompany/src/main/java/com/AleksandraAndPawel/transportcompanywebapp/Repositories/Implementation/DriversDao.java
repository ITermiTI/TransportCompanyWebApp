package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.DriversEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IDriverDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DriversDao extends GenericDao<DriversEntity> implements IDriverDao {
}
