package project.core.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.core.AppConfig;

class UserServiceTest {

    UserService userService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        userService = appConfig.userService();
    }

    @Test
    void join() {
        //given
        User user = new User(1L, "userA", Grade.VIP);

        //when
        userService.join(user);
        User findUser = userService.findUser(1L);

        //then
        Assertions.assertThat(user).isEqualTo(findUser);
    }
}
