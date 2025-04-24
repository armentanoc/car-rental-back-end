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

}
