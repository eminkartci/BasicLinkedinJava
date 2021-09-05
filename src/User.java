
public class User {

    // CONSTANTS
    String USERS_PATH = "src/users.txt";

    // MAIN
    public static void main(String[] args) {
        // User Instance
        User user1 = new User(0,"eminkartci","123123");
        User user2 = new User(1,"cemozkul","321321");
        System.out.println(user1);
        System.out.println(user2);
    }

    // STATIC METHODS
    public static void load_users(){



    }
    
    // Attribute
    int ID;
    String username;
    String password;

    // Constructor
    public User(int ID,String username,String password){
        
        this.ID = ID;
        this.username = username;
        this.password = password;

    }

    // Behaviours
    public String toString(){
        String content = "----- USER " + this.ID + " -----" + "\n"
                        +"| Username: " + this.username + "\n"
                        +"| Password: " + "**********" ;

        return content;
    }

}
