package ua.khpi.oop.lab02;

public class Admin extends User {

    public Admin(String userId, String username, String password) {
        super(userId, username, password);
    }

    public void addToMenu(Cafe cafe, MenuItem item) {
        cafe.addMenuItem(item);
        System.out.printf("Admin %s added '%s' to menu.%n", getUsername(), item.getName());
    }

    public void viewReports(Cafe cafe) {
        System.out.printf("Admin %s viewing reports: %s%n", getUsername(), cafe);
    }

    @Override
    public String toString() {
        return String.format("Admin[id=%s, username=%s]", getUserId(), getUsername());
    }
}
