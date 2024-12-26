package project.core.order;

public interface OrderService {

    Order createOrder(Long userId, String itemName, int itemPrice);
}
