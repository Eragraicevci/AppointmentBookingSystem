package com.sha.appointment_booking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="booking_history")
public class BookingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name="appointment_id", nullable = false)
    private Long appointmentId;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

}
