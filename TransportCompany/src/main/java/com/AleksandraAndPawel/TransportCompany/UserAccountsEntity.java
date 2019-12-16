package com.AleksandraAndPawel.TransportCompany;

import java.sql.Timestamp;
import java.util.Collection;

public class UserAccountsEntity {
    private int accountId;
    private String loginEmail;
    private String isEnabled;
    private String passwordHash;
    private Timestamp dateCreated;
    private Collection<ClientsEntity> clientsByAccountId;
    private Collection<DriversEntity> driversByAccountId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccountsEntity that = (UserAccountsEntity) o;

        if (accountId != that.accountId) return false;
        if (loginEmail != null ? !loginEmail.equals(that.loginEmail) : that.loginEmail != null) return false;
        if (isEnabled != null ? !isEnabled.equals(that.isEnabled) : that.isEnabled != null) return false;
        if (passwordHash != null ? !passwordHash.equals(that.passwordHash) : that.passwordHash != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + (loginEmail != null ? loginEmail.hashCode() : 0);
        result = 31 * result + (isEnabled != null ? isEnabled.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    public Collection<ClientsEntity> getClientsByAccountId() {
        return clientsByAccountId;
    }

    public void setClientsByAccountId(Collection<ClientsEntity> clientsByAccountId) {
        this.clientsByAccountId = clientsByAccountId;
    }

    public Collection<DriversEntity> getDriversByAccountId() {
        return driversByAccountId;
    }

    public void setDriversByAccountId(Collection<DriversEntity> driversByAccountId) {
        this.driversByAccountId = driversByAccountId;
    }
}
