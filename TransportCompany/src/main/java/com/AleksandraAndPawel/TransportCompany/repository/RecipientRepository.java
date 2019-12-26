package com.AleksandraAndPawel.transportcompany.repository;
import com.AleksandraAndPawel.transportcompany.model.RecipientsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends CrudRepository<RecipientsEntity,Integer> {
}
