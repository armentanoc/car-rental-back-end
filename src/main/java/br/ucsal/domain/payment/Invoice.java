package br.ucsal.domain.payment;

import br.ucsal.domain.BaseEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
public class Invoice extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "status")
    private InvoiceStatus status;

    public Invoice() {
        // default for JPA
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        if (payment != null) {
            this.payment = payment;
        }
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        if (invoiceNumber != null) {
            this.invoiceNumber = invoiceNumber;
        }
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        if (issueDate != null) {
            this.issueDate = issueDate;
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

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        if (status != null) {
            this.status = status;
        }
    }
}
