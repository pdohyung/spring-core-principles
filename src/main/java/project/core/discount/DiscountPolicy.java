package project.core.discount;

import project.core.user.User;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(User user, int price);
}
