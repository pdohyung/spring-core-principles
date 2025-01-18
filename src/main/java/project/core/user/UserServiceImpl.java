package project.core.user;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void join(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(Long userId) {
        return userRepository.findById(userId);
    }

    // 테스트 용도
    public UserRepository getUserRepository() {
        return userRepository;
    }
}
