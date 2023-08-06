package conference_room.models;

import java.util.*;
import java.util.stream.Collectors;

public class Building {
    private String buildingId;
    private Map<Integer, List<Room>> floors;

    public Building(String buildingId) {
        this.buildingId = buildingId;
        this.floors = new HashMap<>();
    }

    public String getId() {
        return buildingId;
    }

    public boolean hasFloor(int floorNumber) {
        return floors.containsKey(floorNumber);
    }

    public void addFloor(int floorNumber) {
        floors.putIfAbsent(floorNumber, new ArrayList<>());
    }

    public void addRoom(int floorNumber, Room room) {
        floors.get(floorNumber).add(room);
    }

    public List<Room> getAllRooms() {
        return floors.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
