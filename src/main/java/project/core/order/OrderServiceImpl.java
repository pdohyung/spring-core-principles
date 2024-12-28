package project.core.order;

import project.core.discount.DiscountPolicy;
import project.core.discount.FixDiscountPolicy;
import project.core.user.MemoryUserRepository;
import project.core.user.User;
import project.core.user.UserRepository;

public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepository = new MemoryUserRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long userId, String itemName, int itemPrice) {
        User user = userRepository.findById(userId);
        int discountPrice = discountPolicy.discount(user, itemPrice);

        return new Order(userId, itemName, itemPrice, discountPrice);
    }
}
