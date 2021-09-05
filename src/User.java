

public class User {

    // MAIN
    public static void main(String[] args) {
        // User Instance
        User user1 = new User("eminkartci","123123");
        System.out.println(user1);
    }
    
    // Attribute
    String username;
    String password;

    // Constructor
    public User(String username,String password){

        this.username = username;
        this.password = password;

    }

    // Behaviours


}
