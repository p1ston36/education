package pages;

public class UserData {

    private String userAcsk;
    private String pathKey;
    private String pass;

    public UserData(){
        this.userAcsk = " АЦСК ІДД ДФС ";
        this.pathKey = "/home/yurii/Documents/my/Work/Project/RVS/Doc/09.2109/Key-6.dat";
        this.pass = "tect4";
    }

    public UserData(String userAcsk, String pathKey, String pass){
        this.userAcsk = userAcsk;
        this.pathKey = pathKey;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getPathKey() {
        return pathKey;
    }

    public String getUserAcsk() {
        return userAcsk;
    }
}
