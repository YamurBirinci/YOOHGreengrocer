package controller;
import domain.users;

public class loggedIn {
    private static loggedIn instance;
    private users loggedInUser;

    private loggedIn() {
    }

    public static loggedIn getInstance() {
        if (instance == null) {
            instance = new loggedIn();
        }
        return instance;
    }

    public void setLoggedInUser(users user) {
        this.loggedInUser = user;
    }

    public users getLoggedInUser() {
        return loggedInUser;
    }
}
