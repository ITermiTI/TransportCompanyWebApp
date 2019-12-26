package com.AleksandraAndPawel.transportcompany.repository;
import com.AleksandraAndPawel.transportcompany.model.UserAccountsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccountsEntity,Integer> {
}
