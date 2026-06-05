package ua.khpi.oop.lab02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Cafe {
    private final String name;
    private final String address;
    private final List<MenuItem> menu;
    private final List<Order> orders;

    public Cafe(String name, String address) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
        if (address == null || address.isEmpty()) throw new IllegalArgumentException("Address cannot be null or empty.");
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        Objects.requireNonNull(item, "Item cannot be null.");
        menu.add(item);
    }

    public MenuItem findMenuItemById(String itemId) {
        return menu.stream().filter(i -> i.getItemId().equals(itemId)).findFirst().orElse(null);
    }

    public Order createOrder(User user) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        Order order = new Order(id, user);
        orders.add(order);
        return order;
    }

    public Order findOrderById(String orderId) {
        return orders.stream().filter(o -> o.getOrderId().equals(orderId)).findFirst().orElse(null);
    }

    public void processOrder(Order order) { Objects.requireNonNull(order); order.updateStatus(OrderStatus.PREPARING); }
    public void completeOrder(Order order) { Objects.requireNonNull(order); order.updateStatus(OrderStatus.COMPLETED); }
    public void payOrder(Order order) { Objects.requireNonNull(order); order.updateStatus(OrderStatus.PAID); }
    public void cancelOrder(Order order) { Objects.requireNonNull(order); order.updateStatus(OrderStatus.CANCELLED); }

    public List<MenuItem> getMenu() { return Collections.unmodifiableList(menu); }
    public List<Order> getOrders() { return Collections.unmodifiableList(orders); }
    public String getName() { return name; }
    public String getAddress() { return address; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return Objects.equals(name, cafe.name) && Objects.equals(address, cafe.address);
    }

    @Override
    public int hashCode() { return Objects.hash(name, address); }

    @Override
    public String toString() {
        return String.format("Cafe[name=%s, address=%s, menu=%d, orders=%d]",
                name, address, menu.size(), orders.size());
    }
}
