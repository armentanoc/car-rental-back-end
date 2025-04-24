package br.ucsal.infrastructure.rental;

import br.ucsal.domain.rental.Contract;
import br.ucsal.domain.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
    Optional<Contract> findByRental(Rental rental);
}
