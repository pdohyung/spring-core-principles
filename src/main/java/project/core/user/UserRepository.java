package project.core.user;

public interface UserRepository {

    void save(User user);

    User findById(Long userId);
}
