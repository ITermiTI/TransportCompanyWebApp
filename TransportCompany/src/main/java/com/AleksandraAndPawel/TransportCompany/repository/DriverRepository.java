package com.AleksandraAndPawel.transportcompany.repository;
import com.AleksandraAndPawel.transportcompany.model.DriversEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<DriversEntity,Integer> {
}
