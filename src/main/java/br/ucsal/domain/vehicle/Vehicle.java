package br.ucsal.domain.vehicle;

import br.ucsal.domain.BaseEntity;
import br.ucsal.domain.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity {

    private String brand;
    private String model;
    private Integer year;
    private String color;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "chassi_number")
    private String chassiNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type")
    private FuelType fuelType;

    private Integer mileage;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "additional_features", columnDefinition = "TEXT")
    private String additionalFeatures;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Vehicle() {
        // default for JPA
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null) {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null) {
            this.model = model;
        }
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (year != null) {
            this.year = year;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null) {
            this.color = color;
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        if (licensePlate != null) {
            this.licensePlate = licensePlate;
        }
    }

    public String getChassiNumber() {
        return chassiNumber;
    }

    public void setChassiNumber(String chassiNumber) {
        if (chassiNumber != null) {
            this.chassiNumber = chassiNumber;
        }
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        if (fuelType != null) {
            this.fuelType = fuelType;
        }
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        if (mileage != null) {
            this.mileage = mileage;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status;
        }
    }

    public String getAdditionalFeatures() {
        return additionalFeatures;
    }

    public void setAdditionalFeatures(String additionalFeatures) {
        if (additionalFeatures != null) {
            this.additionalFeatures = additionalFeatures;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category != null) {
            this.category = category;
        }
    }

}
