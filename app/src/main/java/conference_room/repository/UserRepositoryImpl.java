package conference_room.repository;

import java.util.*;

import conference_room.models.User;

public class UserRepositoryImpl implements UserRepository {
    private static Map<String, User> users;

    public UserRepositoryImpl() {
        if (users == null) {
            users = new HashMap<>();
        }
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public User save(User user) {
        users.put(user.getUserId(), user);
        return user;
    }

}
