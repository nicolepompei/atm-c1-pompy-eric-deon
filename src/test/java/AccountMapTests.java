import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AccountMapTests{

    @Test
    public void accountMapConstructor(){
        AccountMap newAccountMap = new AccountMap();
        Integer expectedId = 0;

        Map<Integer, Account> actualAccount = newAccountMap.getAccounts();
        Integer actualId = newAccountMap.getNextId();

        Assert.assertTrue(actualAccount.isEmpty());
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void createAccountTest(){
        AccountMap newAccountMap = new AccountMap();
        Integer expectedSize = newAccountMap.getAccounts().size() + 1;
        newAccountMap.createAccount(100.0, 1);

        Integer actualSize = newAccountMap.getAccounts().size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getAccountByIdTest(){
        AccountMap newAccountMap = new AccountMap();
        Double expectedBalance = 100.0;
        Integer expectedAccountId = 1;
        Account account = newAccountMap.createAccount(100.00, 1);

        Integer actualAccountId = newAccountMap.getAccountById(1).getAccountID();

        Assert.assertEquals(expectedAccountId, actualAccountId);
    }

    @Test
    public void getAccountByIdBalanceTest(){
        AccountMap newAccountMap = new AccountMap();
        Double expectedBalance = 100.0;
        Integer expectedAccountId = 1;
        Account account = newAccountMap.createAccount(100.00, 1);

        Double accountBalance = newAccountMap.getAccountById(1).getBalance();
        Integer actualAccountId = newAccountMap.getAccountById(1).getAccountID();

        Assert.assertEquals(expectedBalance, accountBalance);
    }

    @Test
    public void getAccounts(){
        AccountMap newAccountMap = new AccountMap();
        newAccountMap.createAccount(100.00, 1);
        Map<Integer, Account> accounts = newAccountMap.getAccounts();

        Assert.assertTrue(accounts.size() == 1);

    }

    @Test
    public void getNextIdTest(){
        AccountMap newAccountMap = new AccountMap();
        Integer actual = newAccountMap.getNextId();
        Integer expected = 0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNextIdTest(){
        AccountMap newAccountMap = new AccountMap();
        Integer expected = 3;

        newAccountMap.setNextId(3);
        Integer actual = newAccountMap.getNextId();

        Assert.assertEquals(expected, actual);
    }
}