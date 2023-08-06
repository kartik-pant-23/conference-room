package conference_room.repository;

import java.util.*;

import conference_room.models.Booking;

public class BookingRepositoryImpl implements BookingRepository {
    private static Map<String, Booking> bookings;

    public BookingRepositoryImpl() {
        if (bookings == null) {
            bookings = new HashMap<>();
        }
    }

    @Override
    public void delete(Booking booking) {
        bookings.remove(booking.getBookingId());
        booking = null;
    }

    @Override
    public Booking save(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

}
