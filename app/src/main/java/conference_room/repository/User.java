package conference_room.repository;

import java.util.*;

import conference_room.models.Booking;

public interface User {
    User save(User user);

    List<Booking> getBookings();

    void removeBooking(Booking booking);
}
