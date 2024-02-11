package com.example.myfragmentapp.activities;

import java.util.HashMap;
import java.util.Map;

public class Users {

    private final Map<String, String> users;

    // Corrected the constructor name to match the class name
    public Users() {
        this.users = new HashMap<>();
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public void putUser(String userName, String password) {
        this.users.put(userName, password);
    }

    // Method to retrieve a user's password given their username
    public String getUserPassword(String userName) {
        return this.users.get(userName);
    }

    // Method to check if a user exists
    public boolean userExists(String userName) {
        return this.users.containsKey(userName);
    }

    // Method to verify a user's password
    public boolean verifyUser(String userName, String password) {
        String storedPassword = getUserPassword(userName);
        return storedPassword != null && storedPassword.equals(password);
    }
}
