package br.ucsal.service;

import br.ucsal.domain.users.Client;
import br.ucsal.infrastructure.IClientRepository;
import br.ucsal.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository repository;

    @Override
    public Optional<Client> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Client> getAll() {
        var clients = repository.findAllByOrderByIdAsc();
		return clients.stream().collect(Collectors.toList());
    }
}
