package com.aleksandraandpawel.transportcompanywebapp;

import com.aleksandraandpawel.transportcompanywebapp.Models.*;
import com.aleksandraandpawel.transportcompanywebapp.Repositories.ICarsDao;
import com.aleksandraandpawel.transportcompanywebapp.Repositories.IRecipientDao;
import com.aleksandraandpawel.transportcompanywebapp.Repositories.IUserAccountsDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TransportCompanyWebAppApplicationTests {

    @Autowired
    IUserAccountsDao userAccountsDao;
    @Autowired
    IRecipientDao recipientDao;
    @Autowired
    ICarsDao carsDao;
    @Test
    public void testGetUserById()
    {
        UserAccountsEntity user =userAccountsDao.getById(3);
        assertNotNull(user);
    }
    @Test
    public void testGetUserByUsername()
    {
        UserAccountsEntity user = userAccountsDao.getUserByLogin("ahmed.quigley@yahoo.com");
        assertNotNull(user);
    }
    @Test
    public void testGetRecipientById()
    {
        RecipientsEntity recipient = recipientDao.getById(3);
        assertNotNull(recipient);
    }
    @Test
    public void testGetDriverById()
    {
        CarsEntity car = carsDao.getById(3);
        assertNotNull(car);
    }
    @Test
    void contextLoads() {
    }

}
