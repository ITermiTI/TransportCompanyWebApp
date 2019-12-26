package com.AleksandraAndPawel.transportcompany.repository;
import com.AleksandraAndPawel.transportcompany.model.TransportsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TransportRepository extends CrudRepository<TransportsEntity,Integer> {
}
