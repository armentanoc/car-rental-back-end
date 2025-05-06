package br.ucsal.service.interfaces;

import br.ucsal.domain.vehicle.Vehicle;
import br.ucsal.dto.rental.*;
import br.ucsal.dto.users.DeleteResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IRentalService {

    AddRentalResponse add(RentalRequest request);

    Optional<RentalResponse> get(Long id);

    Page<RentalResponse> getAll(Pageable pageable);

    DeleteResponse delete(Long id, DeleteRequest request);

    Page<Vehicle> getAvailableVehicles(AvailabilityRequest request, Pageable pageable);

    Page<RentalResponse> getRentalsByClientOrdered(Long clientId, Pageable pageable);
}
