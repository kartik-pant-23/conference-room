package conference_room.repository;

import java.util.List;

public interface Room {
    Room save(Room room);

    void addBooking(Booking booking);

    void removeBooking(Booking booking);

    List<Room> getAvailableRooms(int start, int end);
}
