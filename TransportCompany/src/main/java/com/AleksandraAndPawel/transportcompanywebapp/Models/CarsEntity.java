package com.AleksandraAndPawel.transportcompanywebapp.Models;

import com.AleksandraAndPawel.transportcompanywebapp.Config.CarStatusConverter;
import com.AleksandraAndPawel.transportcompanywebapp.Config.CarTypeConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cars", schema = "systransport")
@EntityListeners(AuditingEntityListener.class)
public class CarsEntity {
    @Id
    @Column(name = "car_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    @Column(name = "car_reg_number", nullable = false, length = 255)
    private String carRegNumber;
    @Basic
    @Column(name = "carrying_capacity", nullable = false, precision = 2)
    private BigDecimal carryingCapacity;
    @Column(name = "car_type", nullable = false)
    @Convert(converter = CarTypeConverter.class)
    private CarType carType;
    @Column(name = "car_status", nullable = false)
    @Convert(converter = CarStatusConverter.class)
    private CarStatus carStatus;
    @Basic
    @Column(name = "driver_id", nullable = true)
    private Integer driverId;


    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }


    public String getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(String carRegNumber) {
        this.carRegNumber = carRegNumber;
    }


    public BigDecimal getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(BigDecimal carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }


    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }


    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
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

        CarsEntity that = (CarsEntity) o;

        if (carId != that.carId) return false;
        if (carRegNumber != null ? !carRegNumber.equals(that.carRegNumber) : that.carRegNumber != null) return false;
        if (carryingCapacity != null ? !carryingCapacity.equals(that.carryingCapacity) : that.carryingCapacity != null)
            return false;
        if (carType != null ? !carType.equals(that.carType) : that.carType != null) return false;
        if (carStatus != null ? !carStatus.equals(that.carStatus) : that.carStatus != null) return false;
        if (driverId != null ? !driverId.equals(that.driverId) : that.driverId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + (carRegNumber != null ? carRegNumber.hashCode() : 0);
        result = 31 * result + (carryingCapacity != null ? carryingCapacity.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (carStatus != null ? carStatus.hashCode() : 0);
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        return result;
    }
}
