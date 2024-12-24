package project.core.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    UserService userService = new UserServiceImpl();

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
