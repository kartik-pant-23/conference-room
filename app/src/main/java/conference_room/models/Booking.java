package conference_room.models;

import java.util.*;

public class Booking {
    private String bookingId;
    private int start, end;
    private User user;
    private Room room;

    public Booking(int start, int end, User user, Room room) {
        this.bookingId = UUID.randomUUID().toString();
        this.start = start;
        this.end = end;
        this.user = user;
        this.room = room;
    }

    public String getBookingId() {
        return bookingId;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isOverlapping(Booking booking) {
        if (start >= booking.end && end <= booking.start) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(start).append(":").append(end)
                .append(" ").append(room.toString())
                .toString();
    }
}
