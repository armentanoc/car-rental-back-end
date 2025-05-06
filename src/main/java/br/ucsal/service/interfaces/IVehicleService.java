package br.ucsal.service.interfaces;

import br.ucsal.dto.vehicle.*;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.ucsal.dto.users.DeleteResponse;

public interface IVehicleService {

    AddVehicleResponse add(VehicleRequest request);

    Optional<VehicleResponse> get(Long id);

    Page<VehicleResponse> getAll(Pageable page);

    DeleteResponse delete(Long id, DeleteRequest request);
}
