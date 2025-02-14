package com.sha.appointment_booking.repository;

import com.sha.appointment_booking.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

}
