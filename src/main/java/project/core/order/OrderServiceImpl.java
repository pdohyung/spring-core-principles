package project.core.order;

import project.core.discount.DiscountPolicy;
import project.core.user.User;
import project.core.user.UserRepository;

public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(UserRepository userRepository, DiscountPolicy discountPolicy) {
        this.userRepository = userRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long userId, String itemName, int itemPrice) {
        User user = userRepository.findById(userId);
        int discountPrice = discountPolicy.discount(user, itemPrice);

        return new Order(userId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public UserRepository getUserRepository() {
        return userRepository;
    }
}
