package conference_room.repository;

import java.util.List;

public interface RoomRepository {
    RoomRepository save(RoomRepository room);

    void addBooking(BookingRepository booking);

    void removeBooking(BookingRepository booking);

    List<RoomRepository> getAvailableRooms(int start, int end);
}
