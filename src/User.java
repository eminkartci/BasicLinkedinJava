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
	// 2    - About ++
	// 3    - Profession++
	// 4    - Company++
	// 5    - Email++
	// 6    - Phone No++
	// 7    - isOpen2Job++
	// 8    - reviewCount??
	// 9    - experience--
	// 10   - education
	// 11   - skills ++
	// 12   - interests
	// 13   - Birthday--
    // 14   - Company Class -> Expreinces - Company attribute


	public class User {

	    // CONSTANTS
	    static String USERS_PATH = "src/users.txt";
		static String DELIMINATOR = ",";

	    // MAIN
	    public static void main(String[] args) {
	        
			manuel_users();
	        

	    }

		public static void load_users_fromUSERS_PATH(){
			ArrayList<User> users = User.load_users();
			User.save_users(users);
	        System.out.println(users);
		}

		public static void manuel_users(){
			// // User Instance
	        ArrayList<User> users = new ArrayList<User>();

			//int ID,String name,String surname,String username,String password, String about, String profesion, String company, String e_mail, String phone_num, Boolean open2job
	        User user1 = new User(0,"Emin","Kartci","eminkartci","123123","I'm an software and electrical engineer","Energy Polyicymaker","ACELEREX - AMEAN","emin.kartci@ozu.edu.tr","05516094250",false);
	        User user2 = new User(1,"Cem","Özkul","cemozkul","321321","I'm a student and currently an intern","Student - Intern","FIGO Para","cem.ozkul@ozu.edu.tr","05302869090",true);
	        

	        Skill[] commonSkills = new Skill[3];
	        commonSkills[0] = new Skill(1,"Java");
	        commonSkills[1] = new Skill(2,"English");
	        commonSkills[2] = new Skill(3,"Python");

	        user1.addSkill(commonSkills[0]);
	        user1.addSkill(commonSkills[1]);
	        user1.addSkill(commonSkills[2]);

	        user2.addSkill(commonSkills[0]);
	        user2.addSkill(commonSkills[1]);

			Experience[] commonExpreinces = new Experience[3];
			commonExpreinces[0] = new Experience(1, "Working for ACELEREX");
			commonExpreinces[1] = new Experience(2, "Working for FIGO Para");
			commonExpreinces[2] = new Experience(3, "Studying in OzU");

			user1.addExperience(commonExpreinces[0]);
			user1.addExperience(commonExpreinces[2]);
			user2.addExperience(commonExpreinces[1]);
			user2.addExperience(commonExpreinces[2]);

	        System.out.println(user1);
	        System.out.println(user2);

	        users.add(user1);
	        users.add(user2);
	        User.save_users(users);
		}

	    // STATIC METHODS
	    public static ArrayList<User> load_users(){

	        ArrayList<User> users = new ArrayList<User>();

	        try {
	            
	            BufferedReader br = new BufferedReader(new FileReader(new File(USERS_PATH)));
	            String line = "";

	            while((line = br.readLine()) != null ){
	                
	                String[] userInfo = line.split(DELIMINATOR);
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
	    String about;
	    String profesion, company;
	    String e_mail, phone_num;
	    Boolean open2job = false;
	    Birthday birthday;
	    ArrayList<Skill> skills;
	    ArrayList<Experience> experiences;

	    // Constructor
	    public User(int ID,String username,String password){
	        
	        this.ID = ID;
	        this.username = username;
	        this.password = password;
	        skills        = new ArrayList<Skill>();
	        experiences   = new ArrayList<Experience>();

	    }

	    public User(int ID,String name,String surname,String username,String password){
	        
	        this(ID,username,password);
	        this.name       = name;
	        this.surname    = surname;

	    }

        public User(int ID,String name,String surname,String username,String password, String about){
                
                this(ID,name,surname,username,password);
                this.about = about;
        }

        public User(int ID,String name,String surname,String username,String password, String about, String profesion, String company){
            
            this(ID,name,surname,username,password,about);
            this.profesion = profesion;
            this.company = company;
        }

        public User(int ID,String name,String surname,String username,String password, String about, String profesion, String company, String e_mail, String phone_num){
            
            this(ID,name,surname,username,password,about,profesion,company);
            this.e_mail = e_mail;
            this.phone_num = phone_num;
        }

        public User(int ID,String name,String surname,String username,String password, String about, String profesion, String company, String e_mail, String phone_num, Boolean open2job){  
            this(ID,name,surname,username,password,about,profesion,company,e_mail,phone_num);
            this.open2job = open2job;
        }
   
	    // Behaviours
	    public void addSkill(Skill s){
	        this.skills.add(s);
	    }
	    
        public void addExperience(Experience e) {
                this.experiences.add(e);
        }

	    public String saveString(){

	        String content = "";

	        content += this.ID + DELIMINATOR + this.username + DELIMINATOR + this.password;

	        if(this.name != null){
	            content+= DELIMINATOR + this.name;
	        }

	        if(this.surname != null){
	            content+= DELIMINATOR + this.surname;
	        }
	        if(this.about != null) {
	        	content += DELIMINATOR + this.about;
	        }
	        if(this.profesion != null) {
	        	content += DELIMINATOR + this.profesion ;
	        }
	        if(this.company != null) {
	        	content += DELIMINATOR + this.company ;
	        }
	        if(this.e_mail != null) {
	        	content += DELIMINATOR + this.e_mail ;
	        }
	        if(this.phone_num != null) {
	        	content += DELIMINATOR + this.phone_num ;
	        }
	        if(this.open2job) {
	        	content += DELIMINATOR + this.open2job ;
	        }

	        // Skills
	        content+= DELIMINATOR;
	        for(int i = 0 ; i < this.skills.size() ; i++){
	            content+= this.skills.get(i).ID + "x";
	        }

	        return content;
	    }

	    public String toString(){

	        String content = "----- USER " + this.ID + " -----" + "\n"
	                        +"| Username: " + this.username + "\n"
	                        +"| Password: " + "****" +"\n";
	        if(this.name != null){
	            content += "| Name   : " + this.name +"\n";
	        }

	        if(this.surname != null){
	            content += "| Surname   : " + this.surname +"\n";
	        }
	        if(this.about != null) {
	        	content += "| About     : " + this.about + "\n";
	        }
	        if(this.profesion != null) {
	        	content += "| Profesion     : " + this.profesion + "\n";
	        }
	        if(this.company != null) {
	        	content += "| Company     : " + this.company + "\n";
	        }
	        if(this.e_mail != null) {
	        	content += "| E-Mail     : " + this.e_mail + "\n";
	        }
	        if(this.phone_num != null) {
	        	content += "| Phone Number    : " + this.phone_num + "\n";
	        }
	        if(this.open2job) {
	        	content += "| Open to Job    : Yes\n";
	        }else{
	        	content += "| Open to Job    : No\n";
	        }

	        // Skills
	        if(this.skills.size() > 0){

	            content += "--------- SKILLS ---------" +"\n";

	            for(Skill x: this.skills){
	                content += " * " + x.toString() + "\n";
	            }

	        }

			// Experience
	        if(this.experiences.size() > 0){

	            content += "--------- Experiences ---------" +"\n";

	            for(Experience x: this.experiences){
	                content += " + " + x.toString() + "\n";
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
	
class Experience{

    // Attributes
    int ID;
    String title;
    String description;
    float rating;
    
    // Constructor
    public Experience(int ID, String title) {
        this.ID     = ID;
        this.title  = title;
    }


    // Behaviours
    public String toString(){
        return this.title;
    }

    
}

class Birthday{

    // Attributes
    int user_id;
    String day, month, year;

    // Constructor
    public Birthday(int user_id, String day, String month, String year) {
        
        this.user_id     = user_id;
        this.day = day;
        this.month     = month;
        this.year     = year;
    }

    // Behavior
    public String toString(){
        return day +" / " + month + " / " + year;
    }

}