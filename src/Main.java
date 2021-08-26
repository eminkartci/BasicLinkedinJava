

class Main{

    public String version = "V.1.1";
    public String[] devs = {"Emin Kartci","Cem Özkul"};

    public static void main(String[] args) {
        
        Main app = new Main();
        app.welcome();

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

    

}