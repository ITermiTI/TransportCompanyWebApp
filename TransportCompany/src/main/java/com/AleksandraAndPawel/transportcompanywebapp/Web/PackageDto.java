package com.AleksandraAndPawel.transportcompanywebapp.Web;

import com.AleksandraAndPawel.transportcompanywebapp.Models.PackageStatus;
import com.AleksandraAndPawel.transportcompanywebapp.Models.PackageType;

import java.sql.Timestamp;

public class PackageDto {



    private Integer packageId;
    private PackageType packageType;
    private String packageWeight;
    private String packagePrice;
    private String packagePriority;

    private PackageStatus packageStatus;

    private String recipientName;
    private String recipientSurname;
    private String recipientAddress;
    private String recipientPhoneNumber;
    private String recipientCity;

    public PackageDto() {
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public String getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(String packageWeight) {
        this.packageWeight = packageWeight;
    }

    public String getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getPackagePriority() {
        return packagePriority;
    }

    public void setPackagePriority(String packagePriority) {
        this.packagePriority = packagePriority;
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
    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }
    public PackageStatus getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(PackageStatus packageStatus) {
        this.packageStatus = packageStatus;
    }
}
