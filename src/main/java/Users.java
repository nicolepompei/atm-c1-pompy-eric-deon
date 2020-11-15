import java.util.ArrayList;
import java.util.Random;

public class Users {

    private Integer password = 0;
    private ArrayList<Users> userList = new ArrayList<Users>();
    private String userName = "";
    //private ArrayList<Accounts> userAcc;

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




}
