package br.ucsal.dto;

public class NotFoundResponse {

    private String message;
    private Long id;

    public NotFoundResponse(Long id, String entityName) {
        this.id = id;
        this.message = entityName+" não encontrado.";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long userId) {
        this.id = userId;
    }

}