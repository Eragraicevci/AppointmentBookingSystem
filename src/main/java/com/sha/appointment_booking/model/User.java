package com.sha.appointment_booking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="users") //this means that the class User is related to a database table called "users". Also, we cannot use "user" as it is a reserved word by PostGreSQL configuration tables

public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY) //generates ids automatically
        private Long id;

        @Column(name="username", unique = true, nullable = false,length = 100)
        private String username;

        @Column(name="password", nullable = false, length = 100)
        private String password;

        @Column(name="name", nullable = false, length = 100)
        private String name;

        @Column(name="create time", nullable = false)
        private LocalDateTime createTime;

        //the role field  will be a numeration (enum Role)
        @Enumerated(EnumType.STRING) //we use this to store the role types in our database as String types, i.e. "Admin", "User"
        @Column(name="role")
        private Role role;






}
