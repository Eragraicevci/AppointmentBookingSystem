package com.sha.appointment_booking.services;

import com.sha.appointment_booking.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
