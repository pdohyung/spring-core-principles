package project.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project.core.user.Grade;
import project.core.user.User;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    @Test
    void vip_o() {
        //given
        User user = new User(1L, "userVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(user, 10_000);

        //then
        assertThat(discount).isEqualTo(1_000);
    }

    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    @Test
    void vip_x() {
        //given
        User user = new User(2L, "userBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(user, 10_000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}
