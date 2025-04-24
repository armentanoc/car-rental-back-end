package br.ucsal.domain.payment;

import br.ucsal.domain.BaseEntity;
import br.ucsal.domain.payment.*;
import br.ucsal.domain.rental.Rental;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    private BigDecimal amount;

    @Column(name = "date_limit")
    private LocalDateTime dateLimit;

    @Column(name = "date_payment")
    private LocalDateTime datePayment;

    private String method;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Getters and Setters with null checks

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        if (rental != null) {
            this.rental = rental;
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        if (amount != null) {
            this.amount = amount;
        }
    }

    public LocalDateTime getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(LocalDateTime dateLimit) {
        if (dateLimit != null) {
            this.dateLimit = dateLimit;
        }
    }

    public LocalDateTime getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(LocalDateTime datePayment) {
        if (datePayment != null) {
            this.datePayment = datePayment;
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        if (method != null) {
            this.method = method;
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
