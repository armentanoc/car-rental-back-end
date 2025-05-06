package br.ucsal.infrastructure;

import br.ucsal.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    Page<Vehicle> findAllByOrderById(Pageable pageable);  
}
