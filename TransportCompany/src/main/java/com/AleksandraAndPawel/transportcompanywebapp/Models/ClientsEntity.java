package com.AleksandraAndPawel.transportcompanywebapp.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "clients", schema = "systransport")
@EntityListeners(AuditingEntityListener.class)
public class ClientsEntity {
    @Id
    @Column(name = "client_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;
    @Column(name = "client_name", nullable = false, length = 255)
    private String clientName;
    @Column(name = "client_surname", nullable = false, length = 255)
    private String clientSurname;
    @Column(name = "client_email", nullable = false, length = 255)
    private String clientEmail;
    @Column(name = "client_address", nullable = false, length = 255)
    private String clientAddress;
    @Column(name = "client_PESEL", nullable = false, length = 11)
    private String clientPesel;
    @Column(name = "client_phone_number", nullable = false, length = 255)
    private String clientPhoneNumber;
    @Column(name = "client_city", nullable = false, length = 255)
    private String clientCity;
    @Column(name = "account_id", nullable = false)
    private int accountId;
    //private UserAccountsEntity userAccountsByAccountId;
    //private Collection<PackagesEntity> packagesByClientId;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }


    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }


    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }


    public String getClientPesel() {
        return clientPesel;
    }

    public void setClientPesel(String clientPesel) {
        this.clientPesel = clientPesel;
    }


    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }


    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (clientId != that.clientId) return false;
        if (accountId != that.accountId) return false;
        if (clientName != null ? !clientName.equals(that.clientName) : that.clientName != null) return false;
        if (clientSurname != null ? !clientSurname.equals(that.clientSurname) : that.clientSurname != null)
            return false;
        if (clientEmail != null ? !clientEmail.equals(that.clientEmail) : that.clientEmail != null) return false;
        if (clientAddress != null ? !clientAddress.equals(that.clientAddress) : that.clientAddress != null)
            return false;
        if (clientPesel != null ? !clientPesel.equals(that.clientPesel) : that.clientPesel != null) return false;
        if (clientPhoneNumber != null ? !clientPhoneNumber.equals(that.clientPhoneNumber) : that.clientPhoneNumber != null)
            return false;
        if (clientCity != null ? !clientCity.equals(that.clientCity) : that.clientCity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientSurname != null ? clientSurname.hashCode() : 0);
        result = 31 * result + (clientEmail != null ? clientEmail.hashCode() : 0);
        result = 31 * result + (clientAddress != null ? clientAddress.hashCode() : 0);
        result = 31 * result + (clientPesel != null ? clientPesel.hashCode() : 0);
        result = 31 * result + (clientPhoneNumber != null ? clientPhoneNumber.hashCode() : 0);
        result = 31 * result + (clientCity != null ? clientCity.hashCode() : 0);
        result = 31 * result + accountId;
        return result;
    }

    /*public Collection<PackagesEntity> getPackagesByClientId() {
        return packagesByClientId;
    }

    public void setPackagesByClientId(Collection<PackagesEntity> packagesByClientId) {
        this.packagesByClientId = packagesByClientId;
    }

    public UserAccountsEntity getUserAccountsByAccountId() {
        return userAccountsByAccountId;
    }

    public void setUserAccountsByAccountId(UserAccountsEntity userAccountsByAccountId) {
        this.userAccountsByAccountId = userAccountsByAccountId;
    }*/
}