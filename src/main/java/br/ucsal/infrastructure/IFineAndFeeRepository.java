package br.ucsal.infrastructure.payment;

import br.ucsal.domain.payment.FineAndFee;
import br.ucsal.domain.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFineAndFeeRepository extends JpaRepository<FineAndFee, Long> {
    List<FineAndFee> findByRental(Rental rental);
}
