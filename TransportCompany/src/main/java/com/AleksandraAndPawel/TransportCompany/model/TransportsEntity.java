package com.AleksandraAndPawel.transportcompany.model;

import javax.persistence.*;
import java.util.Collection;

//@Entity
@Table(name ="transports")
public class TransportsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transportId;
    private String transportCity;
    private TransportStatus transportStatus;
    private Integer driverId;
    private Collection<PackagesEntity> packagesByTransportId;
    private DriversEntity driversByDriverId;

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

    public Object getTransportStatus() {
        return transportStatus;
    }

    public void setTransportStatus(TransportStatus transportStatus) {
        this.transportStatus = transportStatus;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportsEntity that = (TransportsEntity) o;

        if (transportId != that.transportId) return false;
        if (transportCity != null ? !transportCity.equals(that.transportCity) : that.transportCity != null)
            return false;
        if (transportStatus != null ? !transportStatus.equals(that.transportStatus) : that.transportStatus != null)
            return false;
        if (driverId != null ? !driverId.equals(that.driverId) : that.driverId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transportId;
        result = 31 * result + (transportCity != null ? transportCity.hashCode() : 0);
        result = 31 * result + (transportStatus != null ? transportStatus.hashCode() : 0);
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        return result;
    }

    public Collection<PackagesEntity> getPackagesByTransportId() {
        return packagesByTransportId;
    }

    public void setPackagesByTransportId(Collection<PackagesEntity> packagesByTransportId) {
        this.packagesByTransportId = packagesByTransportId;
    }

    public DriversEntity getDriversByDriverId() {
        return driversByDriverId;
    }

    public void setDriversByDriverId(DriversEntity driversByDriverId) {
        this.driversByDriverId = driversByDriverId;
    }
}
