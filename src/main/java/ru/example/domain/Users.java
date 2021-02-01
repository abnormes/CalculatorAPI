package ru.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Nail Rogatov
 * @created 30/01/2021
 */
@Entity
@Getter
@Setter
public class Users {

    @Id
    private Long id;
    private String name;
    private String password;
}
