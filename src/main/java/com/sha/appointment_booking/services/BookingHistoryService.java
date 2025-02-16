package com.sha.appointment_booking.services;
import com.sha.appointment_booking.model.BookingHistory;
import com.sha.appointment_booking.repository.IBookingHistoryRepository;
import com.sha.appointment_booking.repository.projection.IBookingItem;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class BookingHistoryService implements IBookingHistoryService{

    private final IBookingHistoryRepository bookingHistoryRepository;

    public BookingHistoryService(IBookingHistoryRepository bookingHistoryRepository){
        this.bookingHistoryRepository=bookingHistoryRepository;
    }

    @Override
    public BookingHistory saveBookingHistory(BookingHistory bookingHistory){
        bookingHistory.setCreatedAt(LocalDateTime.now());
        return bookingHistoryRepository.save(bookingHistory);
    }

    @Override
    public List<IBookingItem> findBookedItemsOfUser(Long userId){
        return bookingHistoryRepository.findAllBookingsOfUser(userId);
    }


}
