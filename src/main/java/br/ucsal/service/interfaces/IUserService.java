package br.ucsal.service.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.ucsal.dto.users.*;

public interface IUserService {
    AddUserResponse add(UserRequest request);
    Optional<UserResponse> get(Long userId);
    Page<UserResponse> getAll(Pageable pageable);
    LoginResponse login(LoginRequest request);
    DeleteResponse delete(Long userId, DeleteRequest request);
    UpdateResponse update(Long userId, UserRequest request);
}
