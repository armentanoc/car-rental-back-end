package br.ucsal.infrastructure.support;

import br.ucsal.domain.support.SupportTicket;
import br.ucsal.domain.client.Client;
import br.ucsal.domain.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISupportTicketRepository extends JpaRepository<SupportTicket, Long> {
    List<SupportTicket> findByClient(Client client);
    List<SupportTicket> findByUser(User user);
}
