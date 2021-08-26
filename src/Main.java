import java.util.Scanner;

class Main{

    public String version = "V.1.1";
    public String[] devs = {"Emin Kartci","Cem Özkul"};
    public String[] menuOptions = {"Login","Register","Exit"};
    public String state = "";

    Scanner scanInt = new Scanner(System.in);

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


    }

}