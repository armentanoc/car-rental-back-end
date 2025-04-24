package br.ucsal.dto.users;

import br.ucsal.domain.enums.Role;

public record UserResponse(Long id, String name, String email, String username, Role role) {
}
