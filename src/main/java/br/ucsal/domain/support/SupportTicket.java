package br.ucsal.domain.support;

import br.ucsal.domain.BaseEntity;
import br.ucsal.domain.client.Client;
import br.ucsal.domain.enums.Status;
import br.ucsal.domain.users.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "support_ticket")
public class SupportTicket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "resolution_details", columnDefinition = "TEXT")
    private String resolutionDetails;

    // Getters and Setters with null checks

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client != null) {
            this.client = client;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user != null) {
            this.user = user;
        }
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        if (subject != null) {
            this.subject = subject;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        if (creationDate != null) {
            this.creationDate = creationDate;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status;
        }
    }

    public String getResolutionDetails() {
        return resolutionDetails;
    }

    public void setResolutionDetails(String resolutionDetails) {
        if (resolutionDetails != null) {
            this.resolutionDetails = resolutionDetails;
        }
    }
}
