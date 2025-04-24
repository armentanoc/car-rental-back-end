package br.ucsal.dto.users;

import br.ucsal.domain.enums.Role;

public record UserRequest(String name, String email, String username, String password, Role role, Long adminId) {
}
