package br.ucsal.infrastructure.payment;

import br.ucsal.domain.payment.Invoice;
import br.ucsal.domain.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByPayment(Payment payment);
}
