package com.sha.appointment_booking.services;
import com.sha.appointment_booking.model.Appointment;
import com.sha.appointment_booking.repository.IAppointmentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService{

    private IAppointmentRepository appointmentRepository;

    public AppointmentService(IAppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }

    @Override
    public Appointment saveAppointment(Appointment appointment){
        appointment.setCreateTime(LocalDateTime.now());
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> findAllBooks(){
        return appointmentRepository.findAll();
    }

}
