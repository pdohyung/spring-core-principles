package project.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import project.core.user.Grade;
import project.core.user.User;
import project.core.user.UserService;
import project.core.user.UserServiceImpl;

class OrderServiceTest {

    UserService userService = new UserServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long userId = 1L;
        User user = new User(userId, "userA", Grade.VIP);
        userService.join(user);

        //when
        Order order = orderService.createOrder(userId, "itemA", 10_000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1_000);
    }
}
