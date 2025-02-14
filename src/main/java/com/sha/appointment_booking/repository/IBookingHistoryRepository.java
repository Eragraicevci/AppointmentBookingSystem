package com.sha.appointment_booking.repository;

import com.sha.appointment_booking.model.BookingHistory;
import com.sha.appointment_booking.repository.projection.IBookingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookingHistoryRepository extends JpaRepository<BookingHistory, Long> {

    @Query("select " +
    "a.type as type, bh.price as price, bh.createdAt as createdAt " +
    "from BookingHistory bh left join Appointment a on a.id=bh.appointmentId " +
    "where bh.userId=:userId ")
    List<IBookingItem> findAllBookingsOfUser(@Param("userId") Long userId);

}
