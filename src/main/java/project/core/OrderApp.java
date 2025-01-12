package project.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.core.order.Order;
import project.core.order.OrderService;
import project.core.user.Grade;
import project.core.user.User;
import project.core.user.UserService;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        UserService userService = appConfig.userService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long userId = 1L;
        User user = new User(userId, "userA", Grade.VIP);
        userService.join(user);

        Order order = orderService.createOrder(userId, "itemA", 20_000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
