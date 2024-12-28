package project.core.order;

public class Order {

    private Long userId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long userId, String itemName, int itemPrice, int discountPrice) {
        this.userId = userId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    public Long getUserId() {
        return userId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
