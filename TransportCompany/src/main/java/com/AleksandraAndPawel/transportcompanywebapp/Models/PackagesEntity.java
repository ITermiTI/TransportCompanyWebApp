package com.AleksandraAndPawel.transportcompanywebapp.Models;

import com.AleksandraAndPawel.transportcompanywebapp.Config.PackageStatusConverter;
import com.AleksandraAndPawel.transportcompanywebapp.Config.PackageTypeConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "packages", schema = "systransport")
@EntityListeners(AuditingEntityListener.class)
public class PackagesEntity {
    @Id
    @Column(name = "package_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int packageId;
    @Basic
    @Column(name = "package_type", nullable = false)
    @Convert(converter = PackageTypeConverter.class)
    private PackageType packageType;
    @Basic
    @Column(name = "package_status", nullable = false)
    @Convert(converter = PackageStatusConverter.class)
    private PackageStatus packageStatus;
    @Basic
    @Column(name = "package_weight", nullable = false, precision = 2)
    private BigDecimal packageWeight;
    @Basic
    @Column(name = "package_price", nullable = false, precision = 2)
    private BigDecimal packagePrice;
    @Basic
    @Column(name = "package_priority", nullable = false, length = 1)
    private String packagePriority;
    @Basic
    @Column(name = "package_date", nullable = true)
    private Timestamp packageDate;
    /*@Basic
    @Column(name = "client_id", nullable = false)
    private int clientId;
    @Basic
    @Column(name = "recipient_id", nullable = false)
    private int recipientId;
    @Basic
    @Column(name = "transport_id", nullable = false)
    private int transportId;*/

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private ClientsEntity clientsByClientId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_id")
    private RecipientsEntity recipientsByRecipientId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transport_id")
    private TransportsEntity transportsByTransportId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackagesEntity that = (PackagesEntity) o;
        return packageId == that.packageId &&
                packageType == that.packageType &&
                packageStatus == that.packageStatus &&
                Objects.equals(packageWeight, that.packageWeight) &&
                Objects.equals(packagePrice, that.packagePrice) &&
                Objects.equals(packagePriority, that.packagePriority) &&
                Objects.equals(packageDate, that.packageDate) &&
                Objects.equals(clientsByClientId, that.clientsByClientId) &&
                Objects.equals(recipientsByRecipientId, that.recipientsByRecipientId) &&
                Objects.equals(transportsByTransportId, that.transportsByTransportId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(packageId, packageType, packageStatus, packageWeight, packagePrice, packagePriority, packageDate, clientsByClientId, recipientsByRecipientId, transportsByTransportId);
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(PackageType packageType) {
        this.packageType = packageType;
    }

    public PackageStatus getPackageStatus() {
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
}
