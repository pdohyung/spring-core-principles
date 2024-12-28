package project.core.user;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new MemoryUserRepository();

    @Override
    public void join(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(Long userId) {
        return userRepository.findById(userId);
    }
}
