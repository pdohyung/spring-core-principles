package project.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.core.user.MemoryUserRepository;
import project.core.user.UserRepository;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 중복 오류 발생")
    @Test
    void findBeanByTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(UserRepository.class));
    }

    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름 지정 필수")
    @Test
    void findBeanByName() {
        UserRepository bean = ac.getBean("userRepository1", UserRepository.class);
        assertThat(bean).isInstanceOf(UserRepository.class);
    }

    @DisplayName("특정 타입을 모두 조회")
    @Test
    void findAllBeanByType() {
        Map<String, UserRepository> beansOfType = ac.getBeansOfType(UserRepository.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public UserRepository userRepository1() {
            return new MemoryUserRepository();
        }

        @Bean
        public UserRepository userRepository2() {
            return new MemoryUserRepository();
        }
    }
}
