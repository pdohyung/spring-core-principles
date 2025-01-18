package project.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.core.discount.DiscountPolicy;
import project.core.discount.RateDiscountPolicy;
import project.core.order.OrderService;
import project.core.order.OrderServiceImpl;
import project.core.user.MemoryUserRepository;
import project.core.user.UserRepository;
import project.core.user.UserService;
import project.core.user.UserServiceImpl;

// 애플리케이션 전체를 설정하고 구성하는 클래스
@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        System.out.println("Call AppConfig.userService");
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        System.out.println("Call AppConfig.userRepository");
        return new MemoryUserRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(userRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
