package conference_room.repository;

public interface Booking {
    Booking save(Booking booking);

    void delete(Booking booking);
}
