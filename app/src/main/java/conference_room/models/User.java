package conference_room.models;

import java.util.*;

public class User {
    private String userId;
    private List<Booking> bookings;

    public User() {
        this.userId = UUID.randomUUID().toString();
        this.bookings = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", bookings=" + bookings.size() + "]";
    }

}
