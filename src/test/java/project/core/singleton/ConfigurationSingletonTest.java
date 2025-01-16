package project.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.core.AppConfig;
import project.core.order.OrderServiceImpl;
import project.core.user.UserRepository;
import project.core.user.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        UserServiceImpl userService = ac.getBean(UserServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        UserRepository userRepository = ac.getBean(UserRepository.class);

        UserRepository userRepository1 = userService.getUserRepository();
        UserRepository userRepository2 = orderService.getUserRepository();

        System.out.println("userService -> userRepository = " + userRepository1);
        System.out.println("orderService -> userRepository = " + userRepository2);
        System.out.println("userRepository = " + userRepository);

        assertThat(userRepository1).isSameAs(userRepository);
        assertThat(userRepository2).isSameAs(userRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
