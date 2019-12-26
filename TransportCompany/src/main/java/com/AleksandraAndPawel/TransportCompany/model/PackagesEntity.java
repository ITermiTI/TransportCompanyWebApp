package com.AleksandraAndPawel.transportcompany.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
//@Entity
@Table(name ="packages")
public class PackagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int packageId;
    private PackageType packageType;
    private PackageStatus packageStatus;
    private BigDecimal packageWeight;
    private BigDecimal packagePrice;
    private String packagePriority;
    private Timestamp packageDate;
    private int clientId;
    private int recipientId;
    private int transportId;
    private ClientsEntity clientsByClientId;
    private RecipientsEntity recipientsByRecipientId;
    private TransportsEntity transportsByTransportId;
    private Collection<ReviewsEntity> reviewsByPackageId;

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public Object getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public Object getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(PackageStatus packageStatus) {
        this.packageStatus = packageStatus;
    }

    public BigDecimal getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(BigDecimal packageWeight) {
        this.packageWeight = packageWeight;
    }

    public BigDecimal getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(BigDecimal packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getPackagePriority() {
        return packagePriority;
    }

    public void setPackagePriority(String packagePriority) {
        this.packagePriority = packagePriority;
    }

    public Timestamp getPackageDate() {
        return packageDate;
    }

    public void setPackageDate(Timestamp packageDate) {
        this.packageDate = packageDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackagesEntity that = (PackagesEntity) o;

        if (packageId != that.packageId) return false;
        if (clientId != that.clientId) return false;
        if (recipientId != that.recipientId) return false;
        if (transportId != that.transportId) return false;
        if (packageType != null ? !packageType.equals(that.packageType) : that.packageType != null) return false;
        if (packageStatus != null ? !packageStatus.equals(that.packageStatus) : that.packageStatus != null)
            return false;
        if (packageWeight != null ? !packageWeight.equals(that.packageWeight) : that.packageWeight != null)
            return false;
        if (packagePrice != null ? !packagePrice.equals(that.packagePrice) : that.packagePrice != null) return false;
        if (packagePriority != null ? !packagePriority.equals(that.packagePriority) : that.packagePriority != null)
            return false;
        if (packageDate != null ? !packageDate.equals(that.packageDate) : that.packageDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageId;
        result = 31 * result + (packageType != null ? packageType.hashCode() : 0);
        result = 31 * result + (packageStatus != null ? packageStatus.hashCode() : 0);
        result = 31 * result + (packageWeight != null ? packageWeight.hashCode() : 0);
        result = 31 * result + (packagePrice != null ? packagePrice.hashCode() : 0);
        result = 31 * result + (packagePriority != null ? packagePriority.hashCode() : 0);
        result = 31 * result + (packageDate != null ? packageDate.hashCode() : 0);
        result = 31 * result + clientId;
        result = 31 * result + recipientId;
        result = 31 * result + transportId;
        return result;
    }

    public ClientsEntity getClientsByClientId() {
        return clientsByClientId;
    }

    public void setClientsByClientId(ClientsEntity clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    public RecipientsEntity getRecipientsByRecipientId() {
        return recipientsByRecipientId;
    }

    public void setRecipientsByRecipientId(RecipientsEntity recipientsByRecipientId) {
        this.recipientsByRecipientId = recipientsByRecipientId;
    }

    public TransportsEntity getTransportsByTransportId() {
        return transportsByTransportId;
    }

    public void setTransportsByTransportId(TransportsEntity transportsByTransportId) {
        this.transportsByTransportId = transportsByTransportId;
    }

    public Collection<ReviewsEntity> getReviewsByPackageId() {
        return reviewsByPackageId;
    }

    public void setReviewsByPackageId(Collection<ReviewsEntity> reviewsByPackageId) {
        this.reviewsByPackageId = reviewsByPackageId;
    }
}
