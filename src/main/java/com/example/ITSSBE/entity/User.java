package com.example.ITSSBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column( name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column( name = "last_name")
    private String last_name;
    @Column( name = "birth")
    private Date birth;
    @Column( name = "gender")
    private String gender;
    @Column( name = "gmail")
    private String gmail;
    @Column( name = "password")
    private String password;
    @Column( name = "phone")
    private String phone;
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn( name = "role")
    private Role role;


}
