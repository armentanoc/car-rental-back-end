package br.ucsal.service.interfaces;

import br.ucsal.dto.rental.*;

import br.ucsal.dto.users.DeleteResponse;
import java.util.List;
import java.util.Optional;

public interface IRentalService {

    AddRentalResponse add(RentalRequest request);

    Optional<RentalResponse> get(Long id);

    List<RentalResponse> getAll();

    DeleteResponse delete(Long id, DeleteRequest request);
}
