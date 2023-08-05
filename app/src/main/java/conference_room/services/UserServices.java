package conference_room.services;

import java.util.*;

import conference_room.models.Booking;
import conference_room.models.User;
import conference_room.repository.UserRepository;

public class UserServices {
    UserRepository repo;

    public UserServices(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser() {
        return repo.save(new User());
    }

    public List<Booking> getBookings(String userId) throws Exception {
        try {
            User user = getUser(userId);
            return user.getBookings();
        } catch (Exception e) {
            throw e;
        }
    }

    public void removeBookings(String userId, Booking booking) throws Exception {
        try {
            List<Booking> bookings = getBookings(userId);
            bookings.remove(booking);
        } catch (Exception e) {
            throw e;
        }
    }

    public User getUser(String userId) throws Exception {
        Optional<User> user = repo.getUserById(userId);
        if (!user.isPresent()) {
            throw new Exception("Requested user does not exist");
        }
        return user.get();
    }
}
