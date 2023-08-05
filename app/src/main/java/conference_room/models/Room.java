package conference_room.models;

import java.util.List;

public class Room {
    private String roomId;
    private int floorNumber;
    private Building building;

    public Room(String roomId, int floorNumber, Building building, List<Booking> bookings) {
        this.roomId = roomId;
        this.floorNumber = floorNumber;
        this.building = building;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(floorNumber)
                .append(" ").append(building.getId())
                .append(" ").append(roomId)
                .toString();
    }

}
