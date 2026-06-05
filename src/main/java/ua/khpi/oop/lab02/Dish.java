package ua.khpi.oop.lab02;

public class Dish extends MenuItem {
    private String ingredients;
    private String category;

    public Dish(String itemId, String name, double price, String description, String ingredients, String category) {
        super(itemId, name, price, description);
        if (ingredients == null || ingredients.isEmpty()) throw new IllegalArgumentException("Ingredients cannot be null or empty.");
        if (category == null || category.isEmpty()) throw new IllegalArgumentException("Category cannot be null or empty.");
        this.ingredients = ingredients;
        this.category = category;
    }

    public String getIngredients() { return ingredients; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Dish[id=%s, name=%s, price=%.2f, category=%s]",
                getItemId(), getName(), getPrice(), category);
    }
}
