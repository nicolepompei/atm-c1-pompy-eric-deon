import java.util.*;

public class Users {

    private Integer password = 0;
    private HashMap<Users, ArrayList<Account>> userList = new HashMap<>();
    private String userName = "";
    private ArrayList<Account> userAccs;

    public Users(){
    }

    public void createUsers(String name, Users user){
        this.userName = name;
        this.password = generatePas();
        userList.put(user, userAccs);
    }

    public Integer generatePas(){
        Random rnd = new Random();
        int num = rnd.nextInt(999999);

        Integer pass = Integer.parseInt(String.format("%06d", num));

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

    public Optional<Users> getUserByName(String name){

        return userList.entrySet().stream().filter(e -> Objects.equals(e.getKey().getUserName(), name)).map(Map.Entry::getKey).findAny();
    }

    public void clearAccList(){
        userAccs.clear();
    }

    public HashMap<Users, ArrayList<Account>> getUserList(){
        return userList;
    }

    public Account getAccountById(Integer id, String currentUser){
        int iterator = 0;
        for(int i = 0; i < getUserList().get(getUserByName(currentUser)).size(); i++){
            if(userList.get(getUserByName(currentUser)).get(i).getAccountID().equals(id)){
                iterator = i;
            }
        }
        return userList.get(getUserByName(currentUser)).get(iterator);
    }

}
