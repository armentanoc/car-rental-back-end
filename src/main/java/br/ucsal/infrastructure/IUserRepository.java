package br.ucsal.infrastructure;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.domain.users.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>  {
    Optional<User> findByusername(String username);
    Page<User> findAllByOrderByIdAsc(Pageable pageable); 
}
