package project.core.user;

public interface UserService {

    void join(User user);

    User findUser(Long userId);
}
