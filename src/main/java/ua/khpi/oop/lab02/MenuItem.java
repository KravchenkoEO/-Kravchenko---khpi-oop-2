package ua.khpi.oop.lab02;

import java.util.Objects;

public abstract class MenuItem {
    private final String itemId;
    private String name;
    private double price;
    private String description;
    private boolean available;

    public MenuItem(String itemId, String name, double price, String description) {
        if (itemId == null || itemId.isEmpty()) throw new IllegalArgumentException("Item ID cannot be null or empty.");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
        if (price <= 0) throw new IllegalArgumentException("Price must be positive.");
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = true;
    }

    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Price must be positive.");
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem m = (MenuItem) o;
        return Objects.equals(itemId, m.itemId);
    }

    @Override
    public int hashCode() { return Objects.hash(itemId); }

    @Override
    public String toString() {
        return String.format("MenuItem[id=%s, name=%s, price=%.2f]", itemId, name, price);
    }
}
