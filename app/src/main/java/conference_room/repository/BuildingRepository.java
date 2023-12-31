package conference_room.repository;

import java.util.*;

import conference_room.models.Building;
import conference_room.models.Room;

public interface BuildingRepository {
    Building save(Building building);

    void addFloor(String buildingId, int floorNumber);

    void addRoom(String buildingId, int floorNumber, Room room);

    List<Room> getRooms(String buildingId);

    Optional<Building> getBuildingById(String buildingId);
}
