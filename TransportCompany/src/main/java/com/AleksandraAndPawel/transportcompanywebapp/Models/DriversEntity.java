package com.AleksandraAndPawel.transportcompanywebapp.Models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "drivers", schema = "systransport")
@EntityListeners(AuditingEntityListener.class)
public class DriversEntity {
    @Id
    @Column(name = "driver_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    @Basic
    @Column(name = "driver_name", nullable = false, length = 255)
    private String driverName;
    @Basic
    @Column(name = "driver_surname", nullable = false, length = 255)
    private String driverSurname;
    @Basic
    @Column(name = "driver_email", nullable = false, length = 255)
    private String driverEmail;
    @Basic
    @Column(name = "driver_PESEL", nullable = false, length = 11)
    private String driverPesel;
    @Basic
    @Column(name = "driver_phone_number", nullable = false, length = 255)
    private String driverPhoneNumber;
    @Basic
    @Column(name = "account_id", nullable = false)
    private int accountId;

    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private UserAccountsEntity userAccountsByAccountId;


    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }


    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    public String getDriverSurname() {
        return driverSurname;
    }

    public void setDriverSurname(String driverSurname) {
        this.driverSurname = driverSurname;
    }


    public String getDriverEmail() {
        return driverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }


    public String getDriverPesel() {
        return driverPesel;
    }

    public void setDriverPesel(String driverPesel) {
        this.driverPesel = driverPesel;
    }


    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(String driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
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

        DriversEntity that = (DriversEntity) o;

        if (driverId != that.driverId) return false;
        if (accountId != that.accountId) return false;
        if (driverName != null ? !driverName.equals(that.driverName) : that.driverName != null) return false;
        if (driverSurname != null ? !driverSurname.equals(that.driverSurname) : that.driverSurname != null)
            return false;
        if (driverEmail != null ? !driverEmail.equals(that.driverEmail) : that.driverEmail != null) return false;
        if (driverPesel != null ? !driverPesel.equals(that.driverPesel) : that.driverPesel != null) return false;
        if (driverPhoneNumber != null ? !driverPhoneNumber.equals(that.driverPhoneNumber) : that.driverPhoneNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + (driverName != null ? driverName.hashCode() : 0);
        result = 31 * result + (driverSurname != null ? driverSurname.hashCode() : 0);
        result = 31 * result + (driverEmail != null ? driverEmail.hashCode() : 0);
        result = 31 * result + (driverPesel != null ? driverPesel.hashCode() : 0);
        result = 31 * result + (driverPhoneNumber != null ? driverPhoneNumber.hashCode() : 0);
        result = 31 * result + accountId;
        return result;
    }

    public UserAccountsEntity getUserAccountsByAccountId() {
        return userAccountsByAccountId;
    }

    public void setUserAccountsByAccountId(UserAccountsEntity userAccountsByAccountId) {
        this.userAccountsByAccountId = userAccountsByAccountId;
    }
}
