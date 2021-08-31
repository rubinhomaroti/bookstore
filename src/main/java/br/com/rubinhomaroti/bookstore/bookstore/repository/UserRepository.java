package br.com.rubinhomaroti.bookstore.bookstore.repository;

import br.com.rubinhomaroti.bookstore.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByUsername(String username);
}
