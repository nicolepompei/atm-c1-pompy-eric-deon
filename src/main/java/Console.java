import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class Console {
    private String currentUser = "";
    private AccountMap accountMap = new AccountMap();
    private Users users = new Users();
    private UserBin bin = new UserBin();
    private ArrayList<String> transactionHistory = new ArrayList<>();


    public void startUpMenu(){
        while (true) {
            loginMenu(Console.getIntegerInput("Welcome to Toucan Sam's ATM!\n" +
                    "1: Log in \n" +
                    "2: Create Account \n" +
                    "3: Quit"));

        }
    }

    public void loginMenu(Integer userInput){
        switch (userInput){
            case 1:
                String userName = Console.getStringInput("Enter username: ");
                if (bin.checkUsername(userName)){
                    Integer password = Console.getIntegerInput("Enter password: ");
                    if (bin.checkPassword(password)){
                        this.currentUser = userName;
                        atmMenu();

                    } else {
                        Console.print("Incorrect password, please start over.");
                        break;
                    }
                }  else {
                    Console.print(("Username is incorrect or does not exist, please start over."));
                    break;
                }
                break;
            case 2:
                userName = Console.getStringInput("Please enter a username to create your profile.");
                if (!bin.checkUsername(userName)){
                    users.createUser(userName);
                    Console.print("Here is your password: " + users.getPassword());
                    this.currentUser = userName;
                    bin.addUser(users);
                    atmMenu();

                } else {
                    Console.print("Username already exists, please log in.");
                }
                break;
            case 3:
                System.exit(0);
            default:
                Console.print("Please enter a valid option.");
            break;
        }

    }


    public void atmMenu(){
        Boolean looping = true;
        while (looping) {
            Console.print(" 1: Open New Account"
                    + "\n 2: Check Balance"
                    + "\n 3: Deposit to Account"
                    + "\n 4: Withdrawal from Account"
                    + "\n 5: Transfer to Account"
                    + "\n 6: Close Account"
                    + "\n 7: Print Receipt"
                    + "\n 8: Print Account Ids"
                    + "\n 9: Logout/Switch User");
            Integer choice = Console.getIntegerInput("Choose an option.");
            switch (choice) {
                case 1:
                    createBankAccount();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdrawal();
                    break;
                case 5:
                    transfer();
                    break;
                case 6:
                    closeAccount();
                    break;
                case 7:
                    printHistory();
                    break;
                case 8:
                    if(!bin.getAccountIdList(currentUser).isEmpty()){
                    bin.getUserList().get(bin.getIndexByName(currentUser)).getAccountIds();}
                    else{Console.print("No bank account IDs found please try again.");}
                    break;
                case 9:
                    clearHistory();
                    looping = false;
                    break;
                default:
                    Console.print("Please choose a valid option");
                    break;
            }
        }
    }

    public void createBankAccount(){
        Integer accountType = Console.getIntegerInput("Which type of account? \n" +
                "1: Checking Account \n" +
                "2: Savings Account \n" +
                "3: Investment Account");
        Double amount = Console.getDoubleInput("How much would you like to deposit?");
        if(amount > 0){Account account = accountMap.createAccount(amount, accountType);
        bin.getUserList().get(bin.getIndexByName(currentUser)).addAccounts(account);
        Console.print(String.format("%s Account was created %s ", account.getName(), currentUser));
        addTransactionHistory(account.getName() + " Account has been created and $" + amount + " has been added to this account.");
        } else{Console.print("You cannot deposit a negative amount. Please try that again.");}}

    public void checkBalance() {
        Integer id = promptAccount();

        System.out.println(bin.getAccountById(id, currentUser).getBalance());
    }

    public void newBalancePrompt(Integer id){
        System.out.println("Balance: " + "$" + accountMap.getAccountById(id).getBalance() + "\n\n");
    }

    public void deposit(){
        Integer id = promptAccount();

        Double deposit = Console.getDoubleInput("Please enter the amount you would like to deposit. ");
        bin.getAccountById(id, currentUser).deposit(deposit);
        newBalancePrompt(id);
        addTransactionHistory("$" + deposit + " has been added to this " + bin.getAccountById(id, currentUser).getName()+ " Account: " + id);
    }

    public void withdrawal(){
        Integer id = promptAccount();

        Double withdrawal = Console.getDoubleInput("Please enter the amount you would like to withdraw. ");
        bin.getAccountById(id, currentUser).withdraw(withdrawal);

        newBalancePrompt(id);
        addTransactionHistory("$" + withdrawal + " has been removed from your " + bin.getAccountById(id, currentUser).getName() + " Account ID: " + id);
    }

    public void transfer(){
        Integer id = promptAccount();

        Double transferAmount = Console.getDoubleInput("How much would you like to transfer?");
        Integer targetAccountId = Console.getIntegerInput("Select the ID of the account to transfer to:");
        bin.getAccountById(id, currentUser).transfer(bin.getAccountById(targetAccountId, currentUser), transferAmount);
        newBalancePrompt(targetAccountId);
        addTransactionHistory("$" + transferAmount + " has been transferred to your " + bin.getAccountById(id, currentUser).getName() + " Account ID:" + targetAccountId);
    }

    public void closeAccount(){
        Integer accountId = promptAccount();
        if(!accountMap.getAccountById(accountId).closeAccount()){
            Console.print("Please remove all funds from this account.");}
            else {
            bin.removeById(accountId, currentUser);

            Console.print("Account successfully removed, sorry not sorry.\n" + "      \\/)/)    \n    _'  oo(_.-.\n  /'.     .---'\n/'-./    (     \n)     ; __\\    \n" +
                    "\\_.'\\ : __|    \n     )  _/     \n    (  (,.     \n     '-.-'");
        }
    }

    public void printHistory(){
       for(String s : transactionHistory){
           System.out.println(s);
       }
    }

    public void clearHistory(){
        transactionHistory.clear();
    }

    public Integer promptAccount(){
            Integer accountId = Console.getIntegerInput("Please enter the account id you would like to access. ");
            StringBuilder message = new StringBuilder();

            for(Integer id : bin.getAccountIdList(currentUser)){
                Account account = accountMap.getAccountById(id);
                message.append(String.format("%s : %s\n", id, account.getName()));
            }

        message.append("Choose an account to access: ");
        do {
            accountId = Console.getIntegerInput(message.toString());
        } while (!bin.getAccountIdList(currentUser).contains(accountId));

        return accountId;
    }


    public static Integer getIntegerInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        print(prompt);
        Integer userInput = scanner.nextInt();
        return userInput;
    }

    public static Double getDoubleInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        print(prompt);
        Double userInput = scanner.nextDouble();
        return userInput;
    }

    public static void print(String output){
        System.out.println(output);
    }

    public static String getStringInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        print(prompt);
        String userInput = scanner.next();
        return userInput;
    }

    public void addTransactionHistory(String transaction){
        transactionHistory.add(transaction);
    }
}





//
//        //Sub Menu after password
//        System.out.println("Welcome back Mr. or Mrs Something! \n" +
//                "Choose an option from the menu below! \n"
//        + "\n 1: Checking Account" // Withdrawal, Deposit, Transfer
//        + "\n 2: Savings Account" // Withdrawal, Deposit, Transfer
//        + "\n 3: Investment Account" // Withdrawal, Deposit, Transfer
//        + "\n 4: Back to Main Menu"); // Takes you back to Main Menu
//
//        Integer input = scanner.nextInt();
//        scanner.nextLine();


        /* Checking Balance Button
        "Your balance is " + "$" + balance" (Your balance is $10,000.00)
         */



        /* Withdrawal from Account button
        "How much would you like to withdrawal?"
        -> $100.00
        "Balance now is: " + "$" + currentBalance" (Balance now is: $9,900.00)
         */



        /* Deposit to Account button
        "How much would you like to deposit?"
        -> $1,000.00
        "Balance now is: " + "$" + currentBalance" (Balance now is: $10,900.00)
         */



        /* Transfer to Account button
        1. Checking to Savings
        2. Checking to Investments
        3. Savings to Checking
        4. Savings to Investments
        5. Investments to Checking
        6. Investments to Savings
        7. Back to Main Menu
         */

// Have a warning sign when below $200 or something?