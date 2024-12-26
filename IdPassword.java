import java.util.HashMap;

public class IdPassword {
    HashMap<String,String> loginInfo = new HashMap<String,String>();
    IdPassword(){
        // login information
        loginInfo.put("Admin124","java124");
        loginInfo.put("Java","124");
    }
    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}