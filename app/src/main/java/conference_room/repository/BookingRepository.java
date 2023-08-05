package conference_room.repository;

import conference_room.models.Booking;

public interface BookingRepository {
    Booking save(Booking booking);

    void delete(Booking booking);
}
