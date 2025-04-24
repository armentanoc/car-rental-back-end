package br.ucsal.service.interfaces;

import br.ucsal.domain.users.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    Optional<Client> getByUserId(Long userId);

    List<Client> getAll();
}
