package br.ucsal.service.client;

import br.ucsal.domain.client.Address;

public interface IAddressService {

    Address save(Address address);

    Address findById(Long id);

    void delete(Long id);
}
