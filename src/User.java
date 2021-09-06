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
// 11   - skills ++
// 12   - interests
// 13   - Birthday


public class User {

    // CONSTANTS
    static String USERS_PATH = "src/users.txt";

    // MAIN
    public static void main(String[] args) {
        // // User Instance
        // ArrayList<User> users = new ArrayList<User>();
        // User user1 = new User(0,"eminkartci","123123");
        // User user2 = new User(1,"Cem","Özkul","cemozkul","321321");
        

        // Skill[] commonSkills = new Skill[3];
        // commonSkills[0] = new Skill(1,"Java");
        // commonSkills[1] = new Skill(2,"English");
        // commonSkills[2] = new Skill(3,"Python");

        // user1.addSkill(commonSkills[0]);
        // user1.addSkill(commonSkills[1]);
        // user1.addSkill(commonSkills[2]);

        // user2.addSkill(commonSkills[0]);
        // user2.addSkill(commonSkills[1]);

        // System.out.println(user1);
        // System.out.println(user2);

        // users.add(user1);
        // users.add(user2);
        // User.save_users(users);
        ArrayList<User> users = User.load_users();
        System.out.println(users);

    }

    // STATIC METHODS
    public static ArrayList<User> load_users(){

        ArrayList<User> users = new ArrayList<User>();

        try {
            
            BufferedReader br = new BufferedReader(new FileReader(new File(USERS_PATH)));
            String line = "";

            while((line = br.readLine()) != null ){
                
                String[] userInfo = line.split(" ");
                User tempUser = null;

                if(userInfo.length  == 4){
                    tempUser = new User(Integer.parseInt(userInfo[0]), userInfo[1],userInfo[2]);
                }else if(userInfo.length == 6){
                    tempUser = new User(Integer.parseInt(userInfo[0]),userInfo[3],userInfo[4], userInfo[1],userInfo[2]);
                }
                
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
            for(User x : users){
                bw.write(x.saveString() + "\n");
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
    public void addSkill(Skill s){
        this.skills.add(s);
    }

    public String saveString(){

        String content = "";

        content += this.ID + " " + this.username + " " + this.password;

        if(this.name != null){
            content+= " " + this.name;
        }

        if(this.surname != null){
            content+= " " + this.surname;
        }

        // Skills
        content+= " ";
        for(int i = 0 ; i < this.skills.size() ; i++){
            content+= this.skills.get(i).ID + "x";
        }

        return content;
    }

    public String toString(){

        String content = "----- USER " + this.ID + " -----" + "\n"
                        +"| Username: " + this.username + "\n"
                        +"| Password: " + "**********" +"\n";
        if(this.name != null){
            content += "| Name   : " + this.name +"\n";
        }

        if(this.surname != null){
            content += "| Surname   : " + this.surname +"\n";
        }


        // Skills
        if(this.skills.size() > 0){

            content += "--------- SKILLS ---------" +"\n";

            for(Skill x: this.skills){
                content += " * " + x.toString() + "\n";
            }

        }

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

    // Behaviour

    public String toString(){
        return this.title;
    }

}