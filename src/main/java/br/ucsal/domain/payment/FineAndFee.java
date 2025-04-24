package br.ucsal.domain.payment;

import br.ucsal.domain.BaseEntity;
import br.ucsal.domain.rental.Rental;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fine_and_fee")
public class FineAndFee extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal amount;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    // Getters and Setters with null checks

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        if (rental != null) {
            this.rental = rental;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        if (date != null) {
            this.date = date;
        }
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        if (status != null) {
            this.status = status;
        }
    }
}
