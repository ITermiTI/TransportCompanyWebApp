package com.AleksandraAndPawel.transportcompanywebapp;

import com.AleksandraAndPawel.transportcompanywebapp.Models.*;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.ICarsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IRecipientDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IUserAccountsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IPackagesDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransportCompanyWebAppApplicationTests {

    @Autowired
    IUserAccountsDao userAccountsDao;
    @Autowired
    IRecipientDao recipientDao;
    @Autowired
    ICarsDao carsDao;

    @Autowired
    private IPackagesDao packagesDao;


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
   /* @Test
    public void testCreateUser()
    {
        UserAccountsEntity user = new UserAccountsEntity();
        user.setIsEnabled("1");
        user.setLoginEmail("test@test.pl");
        user.setDateCreated(Timestamp.valueOf("2019-02-02 00:00:00"));
        user.setPasswordHash("123");
        assertNotNull(userAccountsDao.add(user));
    }*/
   /*@Test
    public void testDeleteById()
   {
       userAccountsDao.removeById(121);
       assertNull(userAccountsDao.getById(121));
   }*/

   @Test
   public void testPackageEntity() {
      PackagesEntity packagesEntity = packagesDao.getById(1);
      assertNotNull(packagesEntity);
   }

   @Test
   public void testCarStatusMappedProperly() {
       CarsEntity car = carsDao.getById(3);
       assertEquals(car.getCarStatus(),CarStatus.PRZYDZIELONO_TRANSPORT);
   }


}
