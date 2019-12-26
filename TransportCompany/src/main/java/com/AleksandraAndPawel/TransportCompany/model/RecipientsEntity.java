package com.AleksandraAndPawel.transportcompany.model;

import javax.persistence.*;
import java.util.Collection;
//@Entity
@Table(name ="recipients")
public class RecipientsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int recipientId;
    private String recipientName;
    private String recipientSurname;
    private String recipientAddress;
    private String recipientPhoneNumber;
    private String recipientCity;
    private Collection<PackagesEntity> packagesByRecipientId;

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientSurname() {
        return recipientSurname;
    }

    public void setRecipientSurname(String recipientSurname) {
        this.recipientSurname = recipientSurname;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public String getRecipientCity() {
        return recipientCity;
    }

    public void setRecipientCity(String recipientCity) {
        this.recipientCity = recipientCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipientsEntity that = (RecipientsEntity) o;

        if (recipientId != that.recipientId) return false;
        if (recipientName != null ? !recipientName.equals(that.recipientName) : that.recipientName != null)
            return false;
        if (recipientSurname != null ? !recipientSurname.equals(that.recipientSurname) : that.recipientSurname != null)
            return false;
        if (recipientAddress != null ? !recipientAddress.equals(that.recipientAddress) : that.recipientAddress != null)
            return false;
        if (recipientPhoneNumber != null ? !recipientPhoneNumber.equals(that.recipientPhoneNumber) : that.recipientPhoneNumber != null)
            return false;
        if (recipientCity != null ? !recipientCity.equals(that.recipientCity) : that.recipientCity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = recipientId;
        result = 31 * result + (recipientName != null ? recipientName.hashCode() : 0);
        result = 31 * result + (recipientSurname != null ? recipientSurname.hashCode() : 0);
        result = 31 * result + (recipientAddress != null ? recipientAddress.hashCode() : 0);
        result = 31 * result + (recipientPhoneNumber != null ? recipientPhoneNumber.hashCode() : 0);
        result = 31 * result + (recipientCity != null ? recipientCity.hashCode() : 0);
        return result;
    }

    public Collection<PackagesEntity> getPackagesByRecipientId() {
        return packagesByRecipientId;
    }

    public void setPackagesByRecipientId(Collection<PackagesEntity> packagesByRecipientId) {
        this.packagesByRecipientId = packagesByRecipientId;
    }
}
