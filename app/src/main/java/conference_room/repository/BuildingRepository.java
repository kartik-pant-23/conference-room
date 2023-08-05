package conference_room.repository;

import java.util.Optional;

import conference_room.models.Building;
import conference_room.models.Room;

public interface BuildingRepository {
    Building save(Building building);

    void addFloor(int floorNumber);

    void addRoom(String buildingId, int floorNumber, Room room);

    void getRooms(String buildingId);

    Optional<Building> getBuildingById(String buildingId);
}
