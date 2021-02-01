package ru.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.domain.UserRequest;

import java.util.Date;
import java.util.List;

/**
 * @author Nail Rogatov
 * @created 30/01/2021
 */
public interface UserRequestRepo extends JpaRepository<UserRequest, Long> {
    List<UserRequest> findAllByRequestDateIsBetween(Date startDate, Date endDate);
    List<UserRequest> findAllByExpression(String expression);
}
