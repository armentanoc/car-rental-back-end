package br.ucsal.service.interfaces;

import br.ucsal.domain.users.Address;

public interface IAddressService {

    Address save(Address address);

    Address findById(Long id);

    void delete(Long id);
}
