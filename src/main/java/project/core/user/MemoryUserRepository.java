package project.core.user;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {

    private static Map<Long, User> store = new HashMap<>();

    @Override
    public void save(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public User findById(Long userId) {
        return store.get(userId);
    }
}
