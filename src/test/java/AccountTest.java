
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


// Test the expected Account class from ATM.
public class AccountTest {

    @Test
    public void testConstructor1() {
        Account a = new Account(0.0);
        assertEquals(0.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testConstructor2() {
        Account a = new Account(10.0);
        assertEquals(10.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testConstructorBalance1() {
        Account a = new Account(0.0);
        assertEquals(true, a.closeAccount());
    }

    @Test
    public void testConstructorBalance2() {
        Account a = new Account(10.0);
        assertEquals(false, a.closeAccount());
    }

    @Test
    public void testDeposit1() {
        Account a = new Account(0.0);
        a.deposit(100.0);
        assertEquals(100.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testDeposit2() {
        Account a = new Account(10.0);
        a.deposit(100.0);
        assertEquals(110.0, a.getBalance(), 0.0001);
    }

    @Test
    public void testWithdraw1() {
        Account a = new Account(200.0);
        Double actual = a.withdraw(100.0);
        assertEquals(100.0, actual, 0.0001);
    }

    @Test
    public void testWithdraw2() {
        Account a = new Account(0.0);
        Double actual = a.withdraw(1.0);
        assertEquals(0.0, actual, 0.0001);
    }

    @Test
    public void testTransfer1() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 10.0);
        assertEquals(0.0, a.getBalance(), 0.0001);
        assertEquals(10.0, b.getBalance(), 0.0001);
    }

    @Test
    public void testTransfer2() {
        Account a = new Account(10.0);
        Account b = new Account(0.0);
        a.transfer(b, 100.0); // nothing should happen
        assertEquals(10.0, a.getBalance(), 0.0001);
        assertEquals(0.0, b.getBalance(), 0.0001);
    }


}
