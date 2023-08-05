package conference_room.repository;

import conference_room.models.Room;

public interface Building {
    Building save(Building building);

    void addFloor(int floorNumber);

    void addRoom(String buildingId, int floorNumber, Room room);

    void getRooms(String buildingId);
}
