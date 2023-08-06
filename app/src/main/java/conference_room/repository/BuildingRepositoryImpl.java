package conference_room.repository;

import java.util.*;

import conference_room.models.Building;
import conference_room.models.Room;

public class BuildingRepositoryImpl implements BuildingRepository {
    private static Map<String, Building> buildings;

    public BuildingRepositoryImpl() {
        if (buildings == null) {
            buildings = new HashMap<>();
        }
    }

    @Override
    public void addFloor(String buildingId, int floorNumber) {
        Building building = buildings.get(buildingId);
        building.addFloor(floorNumber);
    }

    @Override
    public void addRoom(String buildingId, int floorNumber, Room room) {
        Building building = buildings.get(buildingId);
        building.addRoom(floorNumber, room);
    }

    @Override
    public Optional<Building> getBuildingById(String buildingId) {
        return Optional.ofNullable(buildings.get(buildingId));
    }

    @Override
    public List<Room> getRooms(String buildingId) {
        return buildings.get(buildingId).getAllRooms();
    }

    @Override
    public Building save(Building building) {
        buildings.put(building.getId(), building);
        return building;
    }

}
