package br.ucsal.infrastructure.marketing;

import br.ucsal.domain.marketing.ClientCampaign;
import br.ucsal.domain.marketing.ClientCampaignId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientCampaignRepository extends JpaRepository<ClientCampaign, ClientCampaignId> {
}
