package conference_room.repository;

import java.util.*;

import conference_room.models.Booking;
import conference_room.models.User;

public interface UserRepository {
    User save(User user);

    List<Booking> getBookings();

    void removeBooking(Booking booking);
}
