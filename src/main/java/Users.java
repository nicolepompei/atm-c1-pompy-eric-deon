import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Users {

    private Integer password = 0;
    private ArrayList<Users> userList = new ArrayList<Users>();
    //private HashMap<Users, Accounts> userList =new HashMap<>()
    private String userName = "";
    //private ArrayList<Accounts> userAccs;

    public Users(String name){
        this.userName = name;
        this.password = generatePas();
    }

    public Integer generatePas(){
        Random rnd = new Random();
        int num = rnd.nextInt(999999);

        Integer pass = Integer.parseInt(String.format("%6d", num));

        return pass;
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

    public void addUser(Users user){
        userList.add(user);

    }

    public ArrayList<Users> getUserList() {
        return userList;
    }
    /*
    public void addAccounts(Accounts account){
        userAccs.add(account);
    }

    public void addToUserList(Users user){
        userList.map(user, userAccs);
    }
    */
}
