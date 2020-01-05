package com.AleksandraAndPawel.transportcompanywebapp.Models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

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
    @OneToOne(fetch = FetchType.EAGER)
    @NotFound(action= NotFoundAction.IGNORE)
    @JoinColumn(name = "account_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriversEntity that = (DriversEntity) o;
        return driverId == that.driverId &&
                Objects.equals(driverName, that.driverName) &&
                Objects.equals(driverSurname, that.driverSurname) &&
                Objects.equals(driverEmail, that.driverEmail) &&
                Objects.equals(driverPesel, that.driverPesel) &&
                Objects.equals(driverPhoneNumber, that.driverPhoneNumber) &&
                Objects.equals(userAccountsByAccountId, that.userAccountsByAccountId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(driverId, driverName, driverSurname, driverEmail, driverPesel, driverPhoneNumber, userAccountsByAccountId);
    }

    public UserAccountsEntity getUserAccountsByAccountId() {
        return userAccountsByAccountId;
    }

    public void setUserAccountsByAccountId(UserAccountsEntity userAccountsByAccountId) {
        this.userAccountsByAccountId = userAccountsByAccountId;
    }
}
