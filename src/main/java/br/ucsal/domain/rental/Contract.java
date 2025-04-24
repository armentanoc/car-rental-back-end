package br.ucsal.domain.rental;

import br.ucsal.domain.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "terms_and_conditions", columnDefinition = "TEXT")
    private String termsAndConditions;

    @Column(columnDefinition = "TEXT")
    private String responsibilities;

    // Getters and Setters with null checks

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        if (rental != null) {
            this.rental = rental;
        }
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        if (contractNumber != null) {
            this.contractNumber = contractNumber;
        }
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        if (creationDate != null) {
            this.creationDate = creationDate;
        }
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        if (termsAndConditions != null) {
            this.termsAndConditions = termsAndConditions;
        }
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        if (responsibilities != null) {
            this.responsibilities = responsibilities;
        }
    }
}
