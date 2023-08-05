package conference_room.repository;

import java.util.List;

import conference_room.models.Booking;
import conference_room.models.Room;

public interface RoomRepository {
    Room save(Room room);

    void addBooking(String roomId, Booking booking);

    void removeBooking(String roomId, Booking booking);

    List<Room> getAvailableRooms(int start, int end);
}
