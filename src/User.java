import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


// TODO:
// 1    - Name Surname ++
// 2    - About
// 3    - Profession
// 4    - Company
// 5    - Email
// 6    - Phone No
// 7    - isOpen2Job
// 8    - reviewCount
// 9    - experience
// 10   - education
// 11   - skills --
// 12   - interests
// 13   - Birthday


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

            br.close();
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

            bw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // Attribute
    int ID;
    String username;
    String password;
    String name,surname;
    ArrayList<Skill> skills;

    // Constructor
    public User(int ID,String username,String password){
        
        this.ID = ID;
        this.username = username;
        this.password = password;
        skills        = new ArrayList<Skill>();

    }

    public User(int ID,String name,String surname,String username,String password){
        
        this(ID,username,password);
        this.name       = name;
        this.surname    = surname;

    }

    // Behaviours
    public String toString(){
        String content = "----- USER " + this.ID + " -----" + "\n"
                        +"| Username: " + this.username + "\n"
                        +"| Password: " + "**********" ;

        return content;
    }

}


class Skill{

    // Attribute
    int ID;
    String title;
    String description;
    float rating;

    // Constructor
    public Skill(int ID,String title){
        this.ID     = ID;
        this.title  = title;
    }

}