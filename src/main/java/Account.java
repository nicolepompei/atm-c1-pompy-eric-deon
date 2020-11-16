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

    //verifies that the amount being deposited is greater than 0
    //updates the balance of the current account object by getting it's current balance and adding the amount
    public void deposit(Double amount) {
        if(amount > 0.0){
        this.setBalance(this.getBalance() + amount, String.format("Deposit to %s ", this.getAccountID()));
        System.out.println("Depositing " + "$" + amount + " into your " + this.getName() + " Account, ID:" + this.getAccountID());}
    else {System.out.println("You cannot deposit a negative number.");}}

//CORE FUNCTIONS OF AN ACCOUNT

    //transfer across accounts of users owned accounts. this method:
    //1.)verifies that the current account that money is leaving has more or as much money as the amount to transfer and that the amount to transfeer is greater than 0
    //2.) sets the new balance of the account money is leaving by subtracting the amount to transfer from its current balance
    //3.) sets the new balance of the account to transfer money to by adding the amount to transfer to the recieving accounts balance
    //4.) prints statements along the way about which account ID is having money transferred to it and which is recieving money
    //5.) if the verification of funds fails, print out insufficient funds
    public void transfer(Account transferAccount, Double amount) {
        if (this.balance >= amount && amount > 0) {
            this.setBalance(this.getBalance() - amount, String.format("Transfer to %s ", transferAccount.getAccountID()));
            transferAccount.setBalance(transferAccount.getBalance() + amount, String.format("Transfer from %s", this.getAccountID()));
            System.out.println("$" + amount + " has been transferred to your " + transferAccount.getName() + " Account ID: " + accountId);
         } else System.out.println("You cannot transfer more than you have in your account or transfer a negative number.");
    }

    //withdraw money from current account. this method:
    //1.) verifies that the amount to withdraw is greater than 0 and the amount is less than or equal to the balance of the current account
    //2.) sets the new balance of the current account by getting the current balance and subtracting the amount
    public Double withdraw(Double amount) {
        if(amount > 0 && amount <= this.getBalance()){
            this.setBalance(this.getBalance() - amount, String.format("Withdraw from %s ", this.getAccountID()));
            System.out.println("Withdrawing " + "$"+ amount + " from your account.");
        } else{System.out.println("You cannot withdraw more than you have in your account or withdraw a negative number. Please try again.");}
        return this.getBalance();
    }


    //account must be empty to be closed. get balance that is equal to 0.
    public boolean closeAccount() {
        return (getBalance() == 0.0);
    }


    //GETTERS AND SETTERS

    //ACCOUNT ID

    //get account ID
    public Integer getAccountID(){
        return accountId;
    }

    //set account ID
    public void setAccountId(Integer accountId){
        this.accountId = accountId;
    }

    //BALANCE

    //get balance
    public Double getBalance(){
    return balance;
    }

    //set balance
    public void setBalance(Double balance){
    this.balance = balance;
    }

    //balance
    public Double balance(){
    return balance;
    }



    //set balance enhanced that sets it by transaction type (two params, balance and transaction type)
    //the transactopnType parameter allows a description to be added to the transaction report so it's not just numbers (acts as a label)


    public void setBalance(Double balance, String transactionType){
    Double oldBalance = getBalance();
    this.setBalance(balance);
    Double amount = this.getBalance() - oldBalance;
    String report = buildTransactionReport(oldBalance, this.getBalance(), amount, transactionType);
    addTransactionReportToTransactionHistory(report);
    }

    //build transactopn report (generated per every transaction)
    //note: may need to reconsider doing tabs with \t
    public String buildTransactionReport(Double oldBalance, Double newBalance, Double amountTransferred, String transactionType){
    return String.format("Transaction: %s $.2f\n\tOld Balance:\t$.2f\n\tNew Balance:\t$.2f", transactionType, amountTransferred, oldBalance, newBalance);
    }


    //add transaction report to transaction history (master of all transaction history)
    public void addTransactionReportToTransactionHistory(String transactionReport){
        transactionHistory.add(transactionReport);
        //Console.println("\n\n" + transactionReport + "\n\n");
    }

    //get transaction history
    public ArrayList<String> getTransactionHistory(){
    return this.transactionHistory;
    }


    //get the printable version of the transaction history (aka master report of all user transactions)
    public String getPrintableTransactionHistory(){
        StringBuilder transactionHistory = new StringBuilder();
        transactionHistory.append("Transaction History:");
        for(String report : this.getTransactionHistory()){
            transactionHistory.append("\n" + report);
        }
        return transactionHistory.toString();
    }


    //string get name that says this class is an "Account"

    public String getName(){
    return "Account";
    }



}
