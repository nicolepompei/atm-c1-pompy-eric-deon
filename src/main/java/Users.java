import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Users {

    private Integer password = 0;
    private HashMap<Users, ArrayList<Account>> userList = new HashMap<>();
    private String userName = "";
    private ArrayList<Account> userAccs;

    public Users(){

    }
    public void setUserName(String name){
        this.userName = name;

    }

    public void createUser(String name, Users user){
        this.userName = name;
        this.password = generatePas();
        userList.put(user, userAccs);

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

    public void updateUserAcc(Users user){
        userList.put(user, userAccs);
    }

    public void addAccounts(Account acc){
        userAccs.add(acc);
    }

    public Boolean checkUserName(String name){//I dont understand how return true wont work but I guess java hates me
        Boolean[] truthy = {false};

        userList.forEach((users, acc) -> {
            if(users.getUserName().equals(name)) {
                truthy[0] = true;
            }
        });
        return truthy[0];
    }

    public Boolean checkPassword(Integer pass){
        Boolean[] truthy = {false};

        userList.forEach((users, acc) -> {
            if(users.getPassword().equals(pass)) {
                truthy[0] = true;
            }
        });
        return truthy[0];
    }

    public Users getUserByName(String name){
        Users[] output = new Users[1];

        userList.forEach((users, acc) -> {
            if(users.getUserName().equals(name)) {
                output[0] = users;
            }
        });
        return output[0];
    }

    public void clearAccList(){
        userAccs.clear();
    }

}