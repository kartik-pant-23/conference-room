package conference_room.repository;

import conference_room.models.Building;
import conference_room.models.Room;

public interface BuildingRepository {
    Building save(Building building);

    void addFloor(int floorNumber);

    void addRoom(String buildingId, int floorNumber, Room room);

    void getRooms(String buildingId);
}
