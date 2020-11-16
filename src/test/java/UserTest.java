
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

   @Test
    public void testGeneratePass(){
        Users user = new Users();
        user.createUser("Bob");
        Integer actual = user.generatePas();
        user.setPassword(actual);

        Integer expected = user.getPassword();


        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUserName(){
        String actual = "Mike";
        Users user = new Users();
        user.createUser(actual);

        String expected = user.getUserName();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAddUser(){
        String actual = "Bob";
        Users user = new Users();
        UserBin bin = new UserBin();

        user.createUser(actual);
        bin.addUser(user);

        Users exp = bin.getUserList().get(0);

        String expected = exp.getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddUser2(){
        String actual = "Anita";
       UserBin bin = new UserBin();
       Users user1 = new Users();
        user1.createUser("Mike");
        bin.addUser(user1);
        user1.createUser("Joe");
        bin.addUser(user1);
        user1.createUser(actual);
        bin.addUser(user1);

        String expected = bin.getUserList().get(bin.getIndexByName(actual)).getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPassAuth(){
        Users users = new Users();
        UserBin bin = new UserBin();
        users.createUser("Jim");
        bin.addUser(users);

        Integer pass = users.getPassword();
        Boolean actual = true;

        Boolean expected = bin.checkPassword(pass);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNameAuth(){
        String name = "Doug";
        UserBin bin = new UserBin();
        Users users = new Users();
        users.createUser(name);
        bin.addUser(users);

        Boolean actual = true;

        Boolean expected = bin.checkUsername(name);

        Assert.assertEquals(expected, actual);
    }

}

