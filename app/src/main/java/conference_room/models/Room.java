package conference_room.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomId;
    private int floorNumber;
    private String buildingId;
    private List<Booking> bookings;

    public Room(String roomId, int floorNumber, String buildingId) {
        this.roomId = roomId;
        this.floorNumber = floorNumber;
        this.buildingId = buildingId;
        this.bookings = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public boolean isAvailable(int startTime, int endTime) {
        return bookings.stream().anyMatch((booking) -> !booking.isOverlapping(startTime, endTime));
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(floorNumber)
                .append(" ").append(buildingId)
                .append(" ").append(roomId)
                .toString();
    }

}
