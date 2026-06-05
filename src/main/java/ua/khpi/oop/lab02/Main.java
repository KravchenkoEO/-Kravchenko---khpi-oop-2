package ua.khpi.oop.lab02;

public class Main {
    public static void main(String[] args) {

        Cafe cafe = new Cafe("Coffee Break", "Main Street 10");
        Admin admin = new Admin("A001", "Max", "adminpass");
        Barista barista = new Barista("B001", "Anna", "pass123");

        MenuItem espresso  = new Beverage("BM001", "Espresso",  2.50, "Strong coffee",      0.05, "Coffee");
        MenuItem latte     = new Beverage("BM002", "Latte",     3.80, "Coffee with milk",   0.25, "Coffee");
        MenuItem croissant = new Dish    ("DM001", "Croissant", 2.00, "Freshly baked",      "Flour, butter", "Pastry");

        admin.addToMenu(cafe, espresso);
        admin.addToMenu(cafe, latte);
        admin.addToMenu(cafe, croissant);

        System.out.println(cafe);

        System.out.println("\n--- Order 1 ---");
        Order order1 = cafe.createOrder(barista);
        barista.takeOrder(order1, espresso, 2);
        barista.takeOrder(order1, croissant, 1);
        System.out.println(order1);

        barista.updateOrderStatus(order1, OrderStatus.PREPARING);
        barista.updateOrderStatus(order1, OrderStatus.READY_FOR_PICKUP);

        try {
            barista.takeOrder(order1, latte, 1);
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        cafe.completeOrder(order1);
        cafe.payOrder(order1);
        System.out.println("Final: " + order1);

        admin.viewReports(cafe);
    }
}
