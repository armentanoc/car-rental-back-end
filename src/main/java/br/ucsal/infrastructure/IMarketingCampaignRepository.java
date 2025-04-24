package br.ucsal.infrastructure.marketing;

import br.ucsal.domain.marketing.MarketingCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarketingCampaignRepository extends JpaRepository<MarketingCampaign, Long> {
}
