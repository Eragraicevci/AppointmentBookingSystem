package com.sha.appointment_booking.services;
import com.sha.appointment_booking.model.User;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
