package conference_room.repository;

import java.util.*;

import conference_room.models.User;

public interface UserRepository {
    User save(User user);

    Optional<User> getUserById(String userId);
}
