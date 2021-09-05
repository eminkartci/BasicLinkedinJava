import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    public static ArrayList<User> load_users(){

        ArrayList<User> users = new ArrayList<User>();

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(new File(USERS_PATH)));
            String line = "";

            while((line = br.readLine()) != null ){
                
                String[] userInfo = line.split(" ");
                User tempUser = new User(Integer.parseInt(userInfo[0]), userInfo[1],userInfo[2]);
                users.add(tempUser);

            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        // System.out.println(users);
        return users;

    }
    
    public static void save_users(ArrayList<User> users){

        try {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(USERS_PATH)));
            String line = "";
            for(User x : users){
                line = x.ID + " " + x.username + " " + x.password + "\n";
                bw.write(line);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
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
