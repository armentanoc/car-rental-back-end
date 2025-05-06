package br.ucsal.infrastructure;

import br.ucsal.domain.rental.Rental;
import br.ucsal.domain.users.Client;
import br.ucsal.domain.vehicle.Category;
import br.ucsal.domain.vehicle.FuelType;
import br.ucsal.domain.vehicle.Vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                        WHEN 1 THEN 3
                        WHEN 2 THEN 2
                        WHEN 3 THEN 3
                        ELSE 4
                    END
            """)
    Page<Rental> findByClientIdOrderByStatusPriority(Long clientId, Pageable pageable);
    

    @Query("""
                SELECT r FROM Rental r
                WHERE r.vehicle.id = :vehicleId
                  AND (r.status = 1 OR r.status = 2)
                  AND (:startDate <= r.endDate AND :endDate >= r.startDate)
            """)
    List<Rental> findConflictingRentals(Long vehicleId, LocalDateTime startDate, LocalDateTime endDate);

    @Query("""
        SELECT v FROM Vehicle v
        LEFT JOIN Rental r ON v.id = r.vehicle.id 
            AND (r.status = 1 OR r.status = 2)
            AND (:startDate <= r.endDate AND :endDate >= r.startDate)
        WHERE r.id IS NULL
          AND (:category IS NULL OR v.category = :category)
          AND (:fuelType IS NULL OR v.fuelType = :fuelType)
          AND (:startYear IS NULL OR v.year >= :startYear)
          AND (:endYear IS NULL OR v.year <= :endYear)
    """)
    Page<Vehicle> findAvailableVehiclesBetweenWithFilters(
        LocalDateTime startDate,
        LocalDateTime endDate,
        Category category,
        FuelType fuelType,
        Integer startYear,
        Integer endYear,
        Pageable pageable
    );
    
}
