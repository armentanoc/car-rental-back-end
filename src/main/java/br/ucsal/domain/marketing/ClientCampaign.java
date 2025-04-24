package br.ucsal.domain.marketing;

import br.ucsal.domain.users.Client;
import jakarta.persistence.*;

@Entity
@Table(name = "client_campaign")
@IdClass(ClientCampaignId.class)
public class ClientCampaign {

    @Id
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Id
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private MarketingCampaign campaign;

    public ClientCampaign() {
        // default for JPA
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client != null) {
            this.client = client;
        }
    }

    public MarketingCampaign getCampaign() {
        return campaign;
    }

    public void setCampaign(MarketingCampaign campaign) {
        if (campaign != null) {
            this.campaign = campaign;
        }
    }
}
