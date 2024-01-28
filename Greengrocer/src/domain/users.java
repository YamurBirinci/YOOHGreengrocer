package domain;
public class users {
    public static users loggedIN;
    private int user_id;
    private String user_name;
    private String user_surname;
    private String username;
    private String user_password;
    private String user_role;
    private String user_address;
    private String user_phone;

    public users() {

	}

    public users(String userName2, String userPassword) {

	}
    

    public users(String user_name, String user_surname, String username, String user_password) {
		this.user_name = user_name;
		this.user_surname = user_surname;
		this.username = username;
		this.user_password = user_password;
	}
    
    public int getUser_id() {
        return user_id;
    }
    

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUser_password() {
        return user_password;
    }


    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_role() {
        return user_role;
    }


    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getUser_address() {
        return user_address;
    }


    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }


    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public static users getloggedIN() {
        return loggedIN;
    }

    public static void setloggedIN(users newLoggedIn) {
        loggedIN = newLoggedIn;
    }


}
