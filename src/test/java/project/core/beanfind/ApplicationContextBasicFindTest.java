package project.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.core.AppConfig;
import project.core.user.UserService;
import project.core.user.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("빈 이름으로 조회")
    @Test
    void findBeanByName() {
        UserService userService = ac.getBean("userService", UserService.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @DisplayName("이름 없이 타임으로만 조회")
    @Test
    void findBeanByType() {
        UserService userService = ac.getBean(UserService.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @DisplayName("구체 타입으로 조회")
    @Test
    void findBeanByName2() {
        UserService userService = ac.getBean("userService", UserServiceImpl.class);
        assertThat(userService).isInstanceOf(UserServiceImpl.class);
    }

    @DisplayName("빈 이름으로 조회 X")
    @Test
    void findBeanByNameX() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", UserService.class));
    }
}
