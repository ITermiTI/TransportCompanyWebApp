package com.AleksandraAndPawel.transportcompany.repository;

import com.AleksandraAndPawel.transportcompany.model.ClientsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ClientRepository extends CrudRepository<ClientsEntity, Integer> {
}
