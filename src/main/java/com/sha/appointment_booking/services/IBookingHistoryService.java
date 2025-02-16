package com.sha.appointment_booking.services;

import com.sha.appointment_booking.model.BookingHistory;
import com.sha.appointment_booking.repository.projection.IBookingItem;

import java.util.List;

public interface IBookingHistoryService {
    BookingHistory saveBookingHistory(BookingHistory bookingHistory);

    List<IBookingItem> findBookedItemsOfUser(Long userId);
}
