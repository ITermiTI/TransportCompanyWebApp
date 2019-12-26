package com.AleksandraAndPawel.transportcompany.repository;
import com.AleksandraAndPawel.transportcompany.model.CarsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CarRepository extends CrudRepository<CarsEntity, Integer> {

}
