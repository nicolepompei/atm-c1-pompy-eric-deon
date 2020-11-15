
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testGeneratePass(){
        Users user = new Users();
        user.createUsers("Rob", user);
        Integer actual = user.generatePas();
        user.setPassword(actual);

        Integer expected = user.getPassword();


        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUserName(){
        String actual = "Mike";
        Users user = new Users();
        user.createUsers(actual, user);

        String expected = user.getUserName();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testAddUser(){
        String actual = "Bob";
        Users user = new Users();
        user.createUsers(actual, user);

        user.updateUserAcc(user);

        Users exp = user.getUserByName(actual);

        String expected = exp.getUserName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddUser2(){
        Users user1 = new Users();
        user1.createUsers("Mike", user1);
        Users user2 = new Users();
        user2.createUsers("Joe", user2);
        Users user3 = new Users();
        user3.createUsers("Anita", user3);

        user1.updateUserAcc(user1);
        user1.updateUserAcc(user2);
        user1.updateUserAcc(user3);

        Boolean actual = true;


        Boolean expected = user1.checkUserName("Joe");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPassAuth(){
        Users users = new Users();
        users.createUsers("Jim", users);
        users.updateUserAcc(users);

        Integer pass = users.getPassword();
        Boolean actual = true;

        Boolean expected = users.checkPassword(pass);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNameAuth(){
        String name = "Doug";
        Users users = new Users();
        users.createUsers(name, users);
        users.updateUserAcc(users);

        Boolean actual = true;

        Boolean expected = users.checkUserName(name);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetById(){
        String name = "Joe";
        Double actual = 3.00;
        Users users = new Users();
        Users user = new Users();
        users.createUsers(name, users);
        Account account = new Account(8000.00, 1);
        Account account2 = new Account(actual, 2);
        users.addAccounts(account);
        users.addAccounts(account2);
        users.updateUserAcc(users);

        user.createUsers("Mark", user);
        Account accountM = new Account(800.00, 1);
        user.clearAccList();
        user.addAccounts(accountM);
        user.updateUserAcc(user);

        Account acc = users.getAccountById(2, name);

        Double expected = acc.getBalance();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetByUsername(){
        String name = "Im Crying Inside";
        Users users = new Users();
        users.createUsers(name, users);
        users.createUsers("Im Dying Inside", users);

        String expected = users.getUserByName(name).getUserName();

        Assert.assertEquals(expected, name);
    }


}
