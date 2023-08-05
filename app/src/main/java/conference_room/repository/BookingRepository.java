package conference_room.repository;

public interface BookingRepository {
    BookingRepository save(BookingRepository booking);

    void delete(BookingRepository booking);
}
