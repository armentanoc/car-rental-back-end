package br.ucsal.infrastructure.vehicle;

import br.ucsal.domain.vehicle.GPSTracking;
import br.ucsal.domain.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGPSTrackingRepository extends JpaRepository<GPSTracking, Long> {
    List<GPSTracking> findByVehicle(Vehicle vehicle);
}
