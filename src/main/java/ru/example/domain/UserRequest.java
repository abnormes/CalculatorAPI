package ru.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Nail Rogatov
 * @created 30/01/2021
 */
@Entity
@Getter
@Setter
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String expression;
    private Double result;
    private Date requestDate;

    @ManyToOne
    private Users user;

    @Override
    public String toString() {
        return  expression +
                " | " +
                result +
                " | " +
                requestDate;
    }
}
