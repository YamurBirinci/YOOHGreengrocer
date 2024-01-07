import domain.users;

public class userManager {
    private static userManager instance;
    private users loggedInUser;

    private userManager() {
    }

    public static synchronized userManager getInstance() {
        if (instance == null) {
            instance = new userManager();
        }
        return instance;
    }

    public boolean loginUser(String username, String userPassword) {
        // Burada kullanıcı doğrulama işlemleri gerçekleştirilebilir
        // Örnek olarak, bir veritabanında kullanıcı bilgileri kontrol edilebilir

        // Örnekte doğrudan başarılı login varsayıldı
        loggedInUser = new users();
        loggedInUser.setUsername(username);
        loggedInUser.setUser_password(userPassword);

        return true;
    }

    public void logoutUser() {
        loggedInUser = null;
    }

    public users getLoggedInUser() {
        return loggedInUser;
    }
}
