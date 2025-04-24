package br.ucsal.service.interfaces;

import br.ucsal.dto.rental.*;

import br.ucsal.dto.users.DeleteResponse;
import br.ucsal.dto.users.DeleteResponse;
import java.util.List;
import java.util.Optional;
import br.ucsal.dto.rental.*;

public interface IRentalService {

    AddRentalResponse add(RentalRequest request);

    Optional<RentalResponse> get(Long id);

    List<RentalResponse> getAll();

    DeleteResponse delete(Long id, DeleteRequest request);
}
