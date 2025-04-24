package br.ucsal.infrastructure.payment;

import br.ucsal.domain.payment.Payment;
import br.ucsal.domain.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByRental(Rental rental);
}
