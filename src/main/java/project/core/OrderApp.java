package project.core;

import project.core.order.Order;
import project.core.order.OrderService;
import project.core.user.Grade;
import project.core.user.User;
import project.core.user.UserService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        UserService userService = appConfig.userService();
        OrderService orderService = appConfig.orderService();

        Long userId = 1L;
        User user = new User(userId, "userA", Grade.VIP);
        userService.join(user);

        Order order = orderService.createOrder(userId, "itemA", 10_000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
