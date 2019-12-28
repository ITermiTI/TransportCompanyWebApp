package com.aleksandraandpawel.transportcompanywebapp.Repositories;

import com.aleksandraandpawel.transportcompanywebapp.Models.CarsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarsDao extends GenericDao<CarsEntity> implements ICarsDao {
}
