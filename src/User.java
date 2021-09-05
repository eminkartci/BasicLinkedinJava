import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class User {

    // CONSTANTS
    static String USERS_PATH = "src/users.txt";

    // MAIN
    public static void main(String[] args) {
        // User Instance
        // User user1 = new User(0,"eminkartci","123123");
        // User user2 = new User(1,"cemozkul","321321");
        // System.out.println(user1);
        // System.out.println(user2);

        User.load_users();

    }

    // STATIC METHODS
    public static void load_users(){

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(new File(USERS_PATH)));
            String line = "";

            while((line = br.readLine()) != null ){
                System.out.println(line);
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

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
