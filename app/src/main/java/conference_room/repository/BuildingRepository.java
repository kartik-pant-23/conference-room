package conference_room.repository;

import conference_room.models.Room;

public interface BuildingRepository {
    BuildingRepository save(BuildingRepository building);

    void addFloor(int floorNumber);

    void addRoom(String buildingId, int floorNumber, Room room);

    void getRooms(String buildingId);
}
