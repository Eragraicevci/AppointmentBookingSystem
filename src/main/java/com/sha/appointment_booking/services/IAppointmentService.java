package com.sha.appointment_booking.services;

import com.sha.appointment_booking.model.Appointment;

import java.util.List;

public interface IAppointmentService {
    Appointment saveAppointment(Appointment appointment);

    void deleteAppointment(Long id);

    List<Appointment> findAllBooks();
}
