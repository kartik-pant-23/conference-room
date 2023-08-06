package conference_room.repository;

import java.util.List;
import java.util.Optional;

import conference_room.models.Booking;
import conference_room.models.Room;

public interface RoomRepository {
    Room save(Room room);

    Optional<Room> getRoom(String roomId, int floorNumber, String buildingId);

    void addBooking(String roomId, int floorNumber, String buildingId, Booking booking);

    void removeBooking(String roomId, int floorNumber, String buildingId, Booking booking);

    List<Room> getAvailableRooms(int startTime, int endTime);
}
