import java.io.Console;
import java.util.ArrayList;

public class Account {
    private Double balance;
    private Integer accountId;
    private ArrayList<String> transactionHistory = new ArrayList<>();



//Counstructors



    public Account(Double balance, Integer accountId){
        this.accountId = accountId;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public Account(Double balance){
        this.balance = balance;
        this.accountId = accountId;
        this.transactionHistory = new ArrayList<>();
    }

    //balance setter (deposit)
    public void deposit(Double amount) {
        if(amount > 0.0)
        this.setBalance(this.getBalance() + amount, INSERT STRING FORMAT HERE "Deposit to %s", this.getAccountID())
    }


    //transfer across accounts of users owned accounts
    public void transfer(Account account, Double amount) {
        if (this.balance >= amount && amount > 0) {
            this.setBalance(this.getBalance() - amount, String.format("Transfer to %s," too.getAcountID()));
            too.setBalance(too.getBalance() + amount, String.format("Transfer from %s", this.getAccountID()));
         } else Console.println("Sorry, not enough currency to transfer.");
    }


    public Double withdraw(Double amount) {
        if(amount > 0 && amount <= this.getBalance()){
            this.setBalance(this.getBalance()) - amount, String.format("Withdraw from %s," this.getAccountID());
        }
    }


    //clear arraylist
    public boolean closeAccount() {
        return (get balance or something)
    }

    public void addTransactionReportToTransactionHistory(String transactionReport){
        transactionHistory.add(transactionReport);
        Console.println("\n\n" + transactionReport + "\n\n");
    }

    public ArrayList<String> getTransactionHistory(){
        StringBuilder transactionHistory = new StringBuilder();
        history.append("Transaction History:");
        for(String report : this.getTransactionHistory()){
            history.append("\n" + report);
        }
        return history.toString();
    }


    //GETTERS AND SETTERS

    //need to add:

    //get balance

    //set balance

    //balance

    //get account ID

    //set account ID

    //set balance enhanced that sets it by transaction type (two params, double and transaction type)

    //build transactopn report (generated per every transaction)

    //add transaction report to transaction history (master of all transaction history)

    //get printable history

    //string get name that says this class is an "Account"






}
