package br.ucsal.infrastructure;

import br.ucsal.domain.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByDocumentNumber(String documentNumber);
    Optional<Client> findByUserId(Long userId);
    List<Client> findAllByOrderByIdAsc();
}
