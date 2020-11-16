
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class Users {

    private Integer password = 0;
    private String userName = "";
    private ArrayList<Account> userAccs = new ArrayList<Account>();

    public Users(){
    }

    public void setUserName(String name){
        this.userName = name;
    }

    public void createUser(String name){
        this.userName = name;
        this.password = generatePas();
    }

    public Integer generatePas(){
        Random rnd = new Random();
        int num = rnd.nextInt(999999);
        Integer pass = Integer.parseInt(String.format("%06d", num));
        return pass;
    }
  
    public void getAccountIds(){
        for(int i = 0; i < userAccs.size(); i++) {
            System.out.println(userAccs.get(i).getAccountID());
        }
    }

    public ArrayList<Account> getUserAccs() {
        return userAccs;
    }

    public void setPassword(Integer password) {//Had to create setPassword for testing purposes
        this.password = password;
    }

    public Integer getPassword(){
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void addAccounts(Account acc){
        userAccs.add(acc);
    }

    public void clearAccList(){
        userAccs.clear();
    }

}

