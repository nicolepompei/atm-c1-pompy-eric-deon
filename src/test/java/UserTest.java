
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testGeneratePass(){
        Users user = new Users("Rob");
        Integer actual = user.generatePas();
        user.setPassword(actual);

        Integer expected = user.getPassword();


        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUserName(){
        String actual = "Mike";
        Users user = new Users(actual);

        String expected = user.getUserName();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAddUser(){
        String actual = "Bob";
        Users user = new Users(actual);

        user.updateUserAcc(user);

        Users exp = user.getUserByName(actual);

        String expected = exp.getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddUser2(){
        Users user1 = new Users("Mike");
        Users user2 = new Users("Joe");
        Users user3 = new Users("Anita");

        user1.updateUserAcc(user1);
        user1.updateUserAcc(user2);
        user1.updateUserAcc(user3);

        Boolean actual = true;


        Boolean expected = user1.checkUserName("Joe");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPassAuth(){
        Users users = new Users("Jim");
        users.updateUserAcc(users);

        Integer pass = users.getPassword();
        Boolean actual = true;

        Boolean expected = users.checkPassword(pass);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNameAuth(){
        String name = "Doug";
        Users users = new Users(name);
        users.updateUserAcc(users);

        Boolean actual = true;

        Boolean expected = users.checkUserName(name);

        Assert.assertEquals(expected, actual);
    }

}
