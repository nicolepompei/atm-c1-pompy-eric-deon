import java.util.ArrayList;

public class UserBin {

    private ArrayList<Users> userList = new ArrayList<Users>();


    public UserBin(){
    }

    public void addUser(Users users) {
        userList.add(users);
    }

    public void removeById(Integer id,String name){
        int iter = 0;

        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUserName().equals(name)){
                iter = i;
            }
        }

        for(int x = 0; x < userList.get(iter).getUserAccs().size(); x++){
            if(userList.get(iter).getUserAccs().get(x).getAccountID().equals(id)){
                userList.get(iter).getUserAccs().remove(x);
            }
        }

    }

    public Integer getIndexByName(String name){
        int iter = 0;

        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUserName().equals(name)){
                iter = i;
            }
        }
        return iter;
    }

    public ArrayList<Users> getUserList(){
        return userList;
    }

    public Boolean checkUsername(String name){

        for(Users u : userList){
            if(u.getUserName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getAccountIdList(String name){
        ArrayList<Integer> list = new ArrayList<>();

        int iter = 0;
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUserName().equals(name)){
                iter = i;
            }
        }

        for(int x = 0; x < userList.get(iter).getUserAccs().size(); x++){
            list.add(userList.get(iter).getUserAccs().get(x).getAccountID());
        }
        return list;
    }

    public Boolean checkPassword(Integer pass){

        for(Users u : userList){
            if(u.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }

    public Account getAccountById(Integer id, String name){
        int iter = 0;

        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUserName().equals(name)){
                iter = i;
            }
        }
        int z = 0;
        for(int x = 0; x < userList.get(iter).getUserAccs().size(); x++){
            if(userList.get(iter).getUserAccs().get(x).getAccountID().equals(id)){
                z = x;
            }
        }

        return userList.get(iter).getUserAccs().get(z);
    }

}
