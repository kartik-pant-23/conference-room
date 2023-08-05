package conference_room.repository;

import java.util.*;

import conference_room.models.Booking;

public interface UserRepository {
    UserRepository save(UserRepository user);

    List<Booking> getBookings();

    void removeBooking(Booking booking);
}
