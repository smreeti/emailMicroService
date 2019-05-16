package com.smriti.emailscheduler.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

}
