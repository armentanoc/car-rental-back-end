package br.ucsal.service.interfaces;

import br.ucsal.domain.client.Client;

import java.util.List;
import java.util.Optional;
import br.ucsal.dto.users.DeleteResponse;

public interface IClientService {

    Client add(Client client);

    Optional<Client> get(Long clientId);

    List<Client> getAll();

    DeleteResponse delete(Long clientId);
}
