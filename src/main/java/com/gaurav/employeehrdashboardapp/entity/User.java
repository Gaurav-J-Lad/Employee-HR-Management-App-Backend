package com.gaurav.employeehrdashboardapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    // ================= PRIMARY KEY =================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // ================= USERNAME =================
    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    // ================= PASSWORD =================
    @Column(name = "password", nullable = false, length = 255)
    private String password;
}