package org.example.models.users;

public class User {
    String username;
    String password;
    String FirstName;
    String LastName;
    int houseNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public User(String username, String password, String firstName, String lastName, int houseNumber) {
        this.username = username;
        this.password = password;
        FirstName = firstName;
        LastName = lastName;
        this.houseNumber = houseNumber;
    }



}
