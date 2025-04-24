package br.ucsal.infrastructure.rental;

import br.ucsal.domain.rental.Rental;
import br.ucsal.domain.client.Client;
import br.ucsal.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByClient(Client client);
    List<Rental> findByVehicle(Vehicle vehicle);
}
