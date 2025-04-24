package br.ucsal.domain.marketing;

import java.io.Serializable;

public class ClientCampaignId implements Serializable {
    private Long client;
    private Long campaign;

    public Long getClient() {
        return client;
    }
    public void setClient(Long client) {
        this.client = client;
    }
    public Long getCampaign() {
        return campaign;
    }
    public void setCampaign(Long campaign) {
        this.campaign = campaign;
    }
    
}
