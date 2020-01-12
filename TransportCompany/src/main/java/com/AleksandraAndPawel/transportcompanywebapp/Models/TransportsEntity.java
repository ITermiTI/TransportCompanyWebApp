package com.AleksandraAndPawel.transportcompanywebapp.Models;

import com.AleksandraAndPawel.transportcompanywebapp.Config.TransportStatusConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "transports", schema = "systransport")
@EntityListeners(AuditingEntityListener.class)
public class TransportsEntity {
    @Id
    @Column(name = "transport_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transportId;
    @Basic
    @Column(name = "transport_city", nullable = false, length = 255)
    private String transportCity;
    @Basic
    @Column(name = "transport_status", nullable = false)
    @Convert(converter = TransportStatusConverter.class)
    private TransportStatus transportStatus;
    @OneToMany(mappedBy = "transportsByTransportId")
    private Collection<PackagesEntity> packagesByTransportId;



    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id")
    private DriversEntity driversByDriverId;

    public DriversEntity getDriversByDriverId() {
        return driversByDriverId;
    }

    public void setDriversByDriverId(DriversEntity driversByDriverId) {
        this.driversByDriverId = driversByDriverId;
    }
    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }


    public String getTransportCity() {
        return transportCity;
    }

    public void setTransportCity(String transportCity) {
        this.transportCity = transportCity;
    }


    public TransportStatus getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(TransportStatus transportStatus) {
        this.transportStatus = transportStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportsEntity that = (TransportsEntity) o;
        return transportId == that.transportId &&
                Objects.equals(transportCity, that.transportCity) &&
                transportStatus == that.transportStatus &&
                Objects.equals(packagesByTransportId, that.packagesByTransportId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transportId, transportCity, transportStatus, packagesByTransportId);
    }

    public Collection<PackagesEntity> getPackagesByTransportId() {
        return packagesByTransportId;
    }

    public void setPackagesByTransportId(Collection<PackagesEntity> packagesByTransportId) {
        this.packagesByTransportId = packagesByTransportId;
    }


}
