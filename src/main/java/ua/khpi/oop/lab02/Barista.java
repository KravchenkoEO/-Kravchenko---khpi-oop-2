package ua.khpi.oop.lab02;

public class Barista extends User {

    public Barista(String userId, String username, String password) {
        super(userId, username, password);
    }

    public void takeOrder(Order order, MenuItem item, int quantity) {
        order.addItem(item, quantity);
        System.out.printf("Barista %s added %d x %s to order %s%n",
                getUsername(), quantity, item.getName(), order.getOrderId());
    }

    public void updateOrderStatus(Order order, OrderStatus newStatus) {
        order.updateStatus(newStatus);
        System.out.printf("Barista %s updated order %s to %s%n",
                getUsername(), order.getOrderId(), newStatus);
    }

    @Override
    public String toString() {
        return String.format("Barista[id=%s, username=%s]", getUserId(), getUsername());
    }
}
