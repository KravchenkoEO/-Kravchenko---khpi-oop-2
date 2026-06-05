package ua.khpi.oop.lab02;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {
    private final String orderId;
    private final LocalDateTime creationTime;
    private OrderStatus status;
    private double totalAmount;
    private final User user;
    private final List<OrderItem> items;

    public Order(String orderId, User user) {
        if (orderId == null || orderId.isEmpty()) throw new IllegalArgumentException("Order ID cannot be null or empty.");
        this.orderId = orderId;
        this.creationTime = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
        this.totalAmount = 0.0;
        this.user = user;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item, int quantity) {
        Objects.requireNonNull(item, "Menu item cannot be null.");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        if (!isModifiable()) throw new IllegalStateException("Cannot modify order with status: " + status);

        OrderItem existing = items.stream()
                .filter(oi -> oi.getItem().equals(item))
                .findFirst().orElse(null);

        if (existing != null) {
            existing.addQuantity(quantity);
        } else {
            items.add(new OrderItem(item, quantity));
        }
        calculateTotal();
    }

    public double calculateTotal() {
        this.totalAmount = items.stream().mapToDouble(OrderItem::getCost).sum();
        return this.totalAmount;
    }

    public void updateStatus(OrderStatus newStatus) {
        if (!isValidTransition(this.status, newStatus))
            throw new IllegalStateException("Invalid transition: " + this.status + " -> " + newStatus);
        this.status = newStatus;
    }

    private boolean isValidTransition(OrderStatus current, OrderStatus next) {
        switch (current) {
            case PENDING: return next == OrderStatus.PREPARING || next == OrderStatus.CANCELLED;
            case PREPARING: return next == OrderStatus.READY_FOR_PICKUP || next == OrderStatus.CANCELLED;
            case READY_FOR_PICKUP: return next == OrderStatus.COMPLETED || next == OrderStatus.PAID || next == OrderStatus.CANCELLED;
            case COMPLETED: return next == OrderStatus.PAID;
            case PAID: return false;
            case CANCELLED: return false;
            default: return false;
        }
    }

    public boolean isModifiable() { return this.status == OrderStatus.PENDING; }

    public String getOrderId() { return orderId; }
    public LocalDateTime getCreationTime() { return creationTime; }
    public OrderStatus getStatus() { return status; }
    public double getTotalAmount() { return totalAmount; }
    public User getUser() { return user; }
    public List<OrderItem> getItems() { return Collections.unmodifiableList(items); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() { return Objects.hash(orderId); }

    @Override
    public String toString() {
        return String.format("Order[id=%s, status=%s, total=%.2f, items=%d]",
                orderId, status, totalAmount, items.size());
    }
}
