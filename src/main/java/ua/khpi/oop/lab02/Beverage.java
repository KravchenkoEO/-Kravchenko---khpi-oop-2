package ua.khpi.oop.lab02;

public class Beverage extends MenuItem {
    private double volume;
    private String type;

    public Beverage(String itemId, String name, double price, String description, double volume, String type) {
        super(itemId, name, price, description);
        if (volume <= 0) throw new IllegalArgumentException("Volume must be positive.");
        if (type == null || type.isEmpty()) throw new IllegalArgumentException("Type cannot be null or empty.");
        this.volume = volume;
        this.type = type;
    }

    public double getVolume() { return volume; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("Beverage[id=%s, name=%s, price=%.2f, volume=%.2f, type=%s]",
                getItemId(), getName(), getPrice(), volume, type);
    }
}
