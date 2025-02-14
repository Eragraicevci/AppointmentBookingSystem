package com.sha.appointment_booking.repository.projection;

//we created this interface because it helps use see all the wanted details of one booking if we want to.

import java.time.LocalDateTime;

public interface IBookingItem {

    String getType();
    Double getPrice();
    LocalDateTime getCreatedAt();
}
