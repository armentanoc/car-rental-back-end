package br.ucsal.domain.client;

import br.ucsal.domain.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    private String street;
    private String number;
    private String state;
    private String cep;
    private String country;
    private String complement;

    // Getters and Setters with null checks

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street != null) {
            this.street = street;
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number != null) {
            this.number = number;
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state != null) {
            this.state = state;
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep != null) {
            this.cep = cep;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country != null) {
            this.country = country;
        }
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        if (complement != null) {
            this.complement = complement;
        }
    }
}
