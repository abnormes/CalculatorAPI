package ru.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.domain.Users;

/**
 * @author Nail Rogatov
 * @created 30/01/2021
 */
public interface UserRepo extends JpaRepository<Users, Long> {
    boolean existsById(Long id);
    Users findByName(String username);
}
