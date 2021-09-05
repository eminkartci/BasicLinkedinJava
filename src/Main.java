import java.util.ArrayList;
import java.util.Scanner;

class Main{

    public String version = "V.1.1";
    public String[] devs = {"Emin Kartci","Cem Özkul"};
    public String[] menuOptions = {"Login","Register","Exit"};
    public String state = "";
    public ArrayList<User> users = new ArrayList<User>();
    public User cUser = null;

    Scanner scanInt = new Scanner(System.in);
    Scanner scanStr = new Scanner(System.in);

    public static void main(String[] args) {
        
        Main app = new Main();
        app.welcome();
        app.menu();

    }

    public void welcome(){
        
        String content =    "|------------------------------|"+ "\n"+
                            "|--- Welcome Basic Linkedin ---|"+ "\n"+
                            "| Version   : " + version +          "\n";
        
        for(String x : devs){
            content += "| Developer : " + x +"\n";
        }

        content += "|------------------------------|"+ "\n";

        System.out.println(content);
    }

    public void menu(){

        String menuContent =    "|||        MENU        |||"   + "\n";
        int menuIndex = 1;

        for(String x : menuOptions){
            menuContent += "| "+menuIndex+" : " + x +"\n";
            menuIndex++;
        }
        menuContent += "|------------------------------|"+ "\n";
        menuContent += "Select an option: ";

        System.out.println(menuContent);

        int option = scanInt.nextInt();

        this.state = this.menuOptions[option - 1];
        
        System.out.println("Selected Page: " + this.state);
        render_state();


    }

    public void render_state(){

        if( this.state.equals("Login")){
            login();
        }else if (this.state.equals("Register")){

        }else if (this.state.equals("Exit")){

        }

    }

    public void init(){
        this.users = User.load_users();
    }

    public void login(){
        
        String username = "";
        String password = "";
        
        System.out.println(loginContent(username,password));
        username = scanStr.nextLine();
        System.out.println(loginContent(username,password));
        password = scanStr.nextLine();
        System.out.println(loginContent(username,password));

        User tempUser = new User(-1,username,password);


    }


    private void checkUserPassword(User u){

        for(int i = 0 ; i < this.users.size() ; i++){

            if(this.users.get(i).username.equals(u.username) && this.users.get(i).password.equals(u.password)){

                System.out.println("Login Successfull !!\n Welcome " + u.username);
                this.cUser = u;
                return;
            }

        }

        System.out.println("There is no such a user or your password is wrong !!");
        this.cUser = null;
        
    }

    public String loginContent(String username,String password){
        return "\n\n\n|||        Login        |||"   + "\n" +
        "| Username: "  + username   + "\n" +
        "| Password: "  + password  +"\n";
    }



}