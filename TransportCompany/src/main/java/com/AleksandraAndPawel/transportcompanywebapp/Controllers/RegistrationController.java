package com.AleksandraAndPawel.transportcompanywebapp.Controllers;

import com.AleksandraAndPawel.transportcompanywebapp.Models.ClientsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Models.UserAccountsEntity;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IClientsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Repositories.API.IUserAccountsDao;
import com.AleksandraAndPawel.transportcompanywebapp.Services.DatabaseUserDetails;
import com.AleksandraAndPawel.transportcompanywebapp.Web.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private IUserAccountsDao userDao;
    @Autowired
    private IClientsDao clientsDao;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result){

        UserAccountsEntity existing = userDao.getUserByLogin(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered using that email");
        }

        if (result.hasErrors()){
            return "registration";
        }
    UserAccountsEntity user = new UserAccountsEntity();
        user.setPasswordHash(userDto.getPassword());
        user.setLoginEmail(userDto.getEmail());
        user.setIsEnabled("1");
        user.setDateCreated(new Timestamp(System.currentTimeMillis()));
        userDao.add(user);
        ClientsEntity client = new ClientsEntity();
        client.setClientAddress(userDto.getAddress());
        client.setClientCity(userDto.getCity());
        client.setClientEmail(userDto.getEmail());
        client.setClientName(userDto.getFirstName());
        client.setClientSurname(userDto.getLastName());
        client.setClientPesel(userDto.getPESEL());
        client.setClientPhoneNumber(userDto.getPhoneNumber());
        client.setAccountId(userDao.getUserByLogin(userDto.getEmail()).getAccountId());
        clientsDao.add(client);
        return "redirect:/registration?success";
    }

}
