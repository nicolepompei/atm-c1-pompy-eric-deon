
import org.junit.Assert;
import org.junit.Test;

public class UsersTest{

    @Test
    public void testGeneratePass(){
        Users user = new Users("Rob");
        Integer actual = user.generatePas();
        user.setPassword(actual);

        Integer expected = user.getPassword();


        Assert.assertEquals(actual, expected);

    }

    @Test
    public void estUserName(){
        String actual = "Mike";
        Users user = new Users(actual);

        String expected = user.getUserName();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAddUser(){
        String actual = "Bob";
        Users user = new Users(actual);

        user.addUser(user);

        Users exp = user.getUserList().get(0);

        String expected = exp.getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddUser2(){
        Users user1 = new Users("Mike");
        Users user2 = new Users("Joe");
        Users user3 = new Users("Anita");

        user1.addUser(user1);
        user1.addUser(user2);
        user1.addUser(user3);

        String actual = "Joe";
        String expected = "";

        for(Users user : user1.getUserList()){
            if(user.getUserName().equals(actual)) {
                expected = user.getUserName();
            }
        }

        Assert.assertEquals(expected, actual);
    }

}
