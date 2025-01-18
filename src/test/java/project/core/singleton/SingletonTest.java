package project.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.core.AppConfig;
import project.core.user.UserService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        UserService userService1 = appConfig.userService();
        UserService userService2 = appConfig.userService();

        System.out.println("userService1 = " + userService1);
        System.out.println("userService2 = " + userService2);

        assertThat(userService1).isNotSameAs(userService2);
    }

    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    @Test
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @DisplayName("스프링 컨테이너와 싱글톤")
    @Test
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService1 = ac.getBean("userService", UserService.class);
        UserService userService2 = ac.getBean("userService", UserService.class);

        System.out.println("userService1 = " + userService1);
        System.out.println("userService2 = " + userService2);

        assertThat(userService1).isSameAs(userService2);
    }
}
