package project.core;

import project.core.discount.RateDiscountPolicy;
import project.core.order.OrderService;
import project.core.order.OrderServiceImpl;
import project.core.user.MemoryUserRepository;
import project.core.user.UserService;
import project.core.user.UserServiceImpl;

// 애플리케이션 전체를 설정하고 구성하는 클래스
public class AppConfig {

    public UserService userService() {
        return new UserServiceImpl(new MemoryUserRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryUserRepository(), new RateDiscountPolicy());
    }
}
