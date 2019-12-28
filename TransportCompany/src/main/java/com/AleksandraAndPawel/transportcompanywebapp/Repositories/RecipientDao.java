package com.aleksandraandpawel.transportcompanywebapp.Repositories;

import com.aleksandraandpawel.transportcompanywebapp.Models.RecipientsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RecipientDao extends GenericDao<RecipientsEntity> implements IRecipientDao {
}
