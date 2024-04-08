package com.springbootJpa.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_email", //name is optional
                columnNames = "email"
        )
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

// For BOTH UNIDIRECTIONAL + BIDIRECTIONAL MANY2MANY
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", // name of Join table
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),  //"id" of User entity
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id") //"id" of Role entity

    )
    private Set<Role> roles = new HashSet<>();
}
