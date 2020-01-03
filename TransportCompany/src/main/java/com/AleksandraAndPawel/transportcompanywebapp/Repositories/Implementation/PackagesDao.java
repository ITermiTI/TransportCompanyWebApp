package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackagesEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IPackagesDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PackagesDao extends GenericDao<PackagesEntity> implements IPackagesDao {
}
