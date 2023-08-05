package conference_room.models;

import java.util.*;

public class Booking {
    private String bookingId;
    private int startTime, endTime;
    private User user;
    private Room room;

    public Booking(int start, int end, User user, Room room) {
        this.bookingId = UUID.randomUUID().toString();
        this.startTime = start;
        this.endTime = end;
        this.user = user;
        this.room = room;
    }

    public String getBookingId() {
        return bookingId;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isOverlapping(int startTime, int endTime) {
        if (this.startTime >= endTime && this.endTime <= startTime) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(startTime).append(":").append(endTime)
                .append(" ").append(room.toString())
                .toString();
    }
}
