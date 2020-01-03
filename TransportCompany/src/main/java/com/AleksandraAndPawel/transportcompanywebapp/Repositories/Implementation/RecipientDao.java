package com.AleksandraAndPawel.transportcompanywebapp.Repositories.Implementation;

import com.AleksandraAndPawel.transportcompanywebapp.Models.RecipientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IRecipientDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RecipientDao extends GenericDao<RecipientsEntity> implements IRecipientDao {
}
