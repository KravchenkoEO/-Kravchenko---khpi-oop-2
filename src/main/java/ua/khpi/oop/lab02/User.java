package ua.khpi.oop.lab02;

import java.util.Objects;

public abstract class User {
    private final String userId;
    private final String username;
    private final String password;

    public User(String userId, String username, String password) {
        if (userId == null || userId.isEmpty()) throw new IllegalArgumentException("User ID cannot be null or empty.");
        if (username == null || username.isEmpty()) throw new IllegalArgumentException("Username cannot be null or empty.");
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public boolean login(String passwordAttempt) { return this.password.equals(passwordAttempt); }
    public String getUserId() { return userId; }
    public String getUsername() { return username; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() { return Objects.hash(userId); }

    @Override
    public String toString() {
        return String.format("User[id=%s, username=%s]", userId, username);
    }
}
