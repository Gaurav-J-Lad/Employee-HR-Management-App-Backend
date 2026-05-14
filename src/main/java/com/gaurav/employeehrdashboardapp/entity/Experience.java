package com.gaurav.employeehrdashboardapp.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "experiences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "experience_range",unique = true, nullable = false)
    private String range;
}