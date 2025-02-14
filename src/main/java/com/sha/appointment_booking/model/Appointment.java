package com.sha.appointment_booking.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="books")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="type", nullable = false, length = 100)
    private String type;

    @Column(name="description", nullable = false, length = 1000)
    private String description;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="createTime", nullable = false)
    private LocalDateTime createTime;

}
