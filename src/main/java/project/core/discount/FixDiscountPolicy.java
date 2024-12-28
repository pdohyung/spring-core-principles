package project.core.discount;

import project.core.user.Grade;
import project.core.user.User;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1_000;

    @Override
    public int discount(User user, int price) {
        if (user.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
