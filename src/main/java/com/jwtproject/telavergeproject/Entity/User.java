package com.jwtproject.telavergeproject.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user" ,uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private String email;

    private String password;


    @ManyToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private Collection<Role> roles;
}




