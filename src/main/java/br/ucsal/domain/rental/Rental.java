package br.ucsal.domain.rental;

import br.ucsal.domain.BaseEntity;
import br.ucsal.domain.client.Client;
import br.ucsal.domain.vehicle.Vehicle;
import jakarta.persistence.*;
import br.ucsal.domain.rental.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
public class Rental extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "initial_mileage")
    private Integer initialMileage;

    @Column(name = "final_mileage")
    private Integer finalMileage;

    @Column(name = "initial_fuel_level")
    private BigDecimal initialFuelLevel;

    @Column(name = "final_fuel_level")
    private BigDecimal finalFuelLevel;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Getters and Setters with null checks

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            this.vehicle = vehicle;
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client != null) {
            this.client = client;
        }
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        if (startDate != null) {
            this.startDate = startDate;
        }
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        if (endDate != null) {
            this.endDate = endDate;
        }
    }

    public Integer getInitialMileage() {
        return initialMileage;
    }

    public void setInitialMileage(Integer initialMileage) {
        if (initialMileage != null) {
            this.initialMileage = initialMileage;
        }
    }

    public Integer getFinalMileage() {
        return finalMileage;
    }

    public void setFinalMileage(Integer finalMileage) {
        if (finalMileage != null) {
            this.finalMileage = finalMileage;
        }
    }

    public BigDecimal getInitialFuelLevel() {
        return initialFuelLevel;
    }

    public void setInitialFuelLevel(BigDecimal initialFuelLevel) {
        if (initialFuelLevel != null) {
            this.initialFuelLevel = initialFuelLevel;
        }
    }

    public BigDecimal getFinalFuelLevel() {
        return finalFuelLevel;
    }

    public void setFinalFuelLevel(BigDecimal finalFuelLevel) {
        if (finalFuelLevel != null) {
            this.finalFuelLevel = finalFuelLevel;
        }
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        if (totalAmount != null) {
            this.totalAmount = totalAmount;
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
}
