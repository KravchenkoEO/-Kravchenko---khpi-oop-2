package ua.khpi.oop.lab02;

import java.util.Objects;

public class OrderItem {
    private final MenuItem item;
    private int quantity;
    private final double priceAtOrder;

    public OrderItem(MenuItem item, int quantity) {
        Objects.requireNonNull(item, "Menu item cannot be null.");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        this.item = item;
        this.quantity = quantity;
        this.priceAtOrder = item.getPrice();
    }

    public double getCost() { return priceAtOrder * quantity; }

    public void addQuantity(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive.");
        this.quantity += amount;
    }

    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getPriceAtOrder() { return priceAtOrder; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem oi = (OrderItem) o;
        return quantity == oi.quantity &&
               Double.compare(oi.priceAtOrder, priceAtOrder) == 0 &&
               Objects.equals(item, oi.item);
    }

    @Override
    public int hashCode() { return Objects.hash(item, quantity, priceAtOrder); }

    @Override
    public String toString() {
        return String.format("OrderItem[item=%s, qty=%d, price=%.2f, cost=%.2f]",
                item.getName(), quantity, priceAtOrder, getCost());
    }
}
