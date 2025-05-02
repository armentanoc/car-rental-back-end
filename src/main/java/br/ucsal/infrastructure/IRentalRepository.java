package br.ucsal.infrastructure;

import br.ucsal.domain.rental.Rental;
import br.ucsal.domain.users.Client;
import br.ucsal.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IRentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByClient(Client client);

    List<Rental> findByVehicle(Vehicle vehicle);

    @Query("""
                SELECT r FROM Rental r
                WHERE r.client.id = :clientId
                ORDER BY
                    CASE r.status
                        WHEN 'CONFIRMED' THEN 1
                        WHEN 'RESERVED' THEN 2
                        WHEN 'CANCELED' THEN 3
                        ELSE 4
                    END
            """)
    List<Rental> findByClientIdOrderByStatusPriority(Long clientId);

    @Query("""
                SELECT r FROM Rental r
                WHERE r.vehicle.id = :vehicleId
                  AND (r.status = 1 OR r.status = 2)
                  AND (:startDate <= r.endDate AND :endDate >= r.startDate)
            """)
    List<Rental> findConflictingRentals(Long vehicleId, LocalDateTime startDate, LocalDateTime endDate);

    @Query("""
                SELECT v FROM Vehicle v
                WHERE v.id NOT IN (
                    SELECT r.vehicle.id FROM Rental r
                    WHERE (r.status = 1 OR r.status = 2)
                    AND (:startDate <= r.endDate AND :endDate >= r.startDate)
                )
            """)
    List<Vehicle> findAvailableVehiclesBetween(LocalDateTime startDate, LocalDateTime endDate);

}
