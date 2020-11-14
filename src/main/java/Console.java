import java.util.Scanner;

public class Console {
// Trying to fix this

    public void startAtm() {
        Scanner scanner = new Scanner(System.in);
        boolean atmRunning = true;

        while (atmRunning) {
            System.out.println("Welcome to our ATM! \n" +
                    "Choose an option from the menu below! \n"
                    + "\n 1: Open New Account"  //Create password and ID
                    + "\n 2: Check Balance" // Enter Password + ID -> Goes to Account Types after entering Password (Checking, Savings, Investment)
                    + "\n 3: Deposit to Account" // Enter password and ID after to continue
                    + "\n 4: Withdrawal from Account" // Enter password and ID after to continue
                    + "\n 5: Transfer to Account" // Enter password + ID
                    + "\n 6: Close Account" // Enter password + ID -> Which Account would you like to close?
                    + "\n 7: Print Receipt"); // Enter password + ID -> Press 1, 2, or 3 for which account you want receipt for.
            // If they don't pick a valid number --- "Invalid option, please try again"

            Integer choice = scanner.nextInt(); // assigning the user's input

            switch (choice) {
                // Opening New Account options
                case 1:
                    System.out.println("\n Select \n (1) to create password \n (2) to create ID \n (3) to add funds (4) to go back to Main Menu");
                    Integer optionSelection = scanner.nextInt(); // enters option

                    if (optionSelection == 1) {
                        System.out.println("\n Enter your password here: ");
                        Integer newPassword = scanner.nextInt();
                        // newAccount.newPassword(newPassword);

                    } else if (optionSelection == 2) {
                        System.out.println("\n Enter your ID number here: ");
                        Integer idNumber = scanner.nextInt();
                        // newAccount.idNumber(idNumber);

                    } else if (optionSelection == 3) {
                        System.out.println("\n Deposit amount in your account: ");
                        Double depositMoney = scanner.nextDouble();
                        // newAccount.depositMoney(depositMoney);
                    } else if (optionSelection == 4) {
                        // Takes you back to Main Menu
                    }
                    break;
                //Checking Balance
                case 2:
                    System.out.println("\n Checking Balance for: \n (1) Checking Account \n (2) Savings Account \n (3) Investment Account \n (4) Go back to Main Menu");
                    Integer balanceCheckingOption = scanner.nextInt(); // enters option

                    if (balanceCheckingOption == 1) {
                        System.out.println("\n Your Checking Account Balance is: " + "$" + currentCheckingBalance);

                    } else if (balanceCheckingOption == 2) {
                        System.out.println("\n Your Savings Account Balance is: " + "$" + currentSavingsBalance);

                    } else if (balanceCheckingOption == 3) {
                        System.out.println("\n Your Investment Account Balance is: " + "$" + currentInvestmentBalance);

                    } else if (balanceCheckingOption == 4) {
                        // Takes you back to Main Menu
                    }
                    break;
                //Deposit to Account
                case 3:
                    System.out.println("\n Deposit money to: \n (1) Checking Account \n (2) Savings Account \n (3) Investment Account \n (4) Go back to Main Menu");
                    Integer depositOption = scanner.nextInt(); // enters option

                    if (depositOption == 1) {
                        System.out.println("\n How much would you like to deposit into your checking account?");
                        Double depositMoney = scanner.nextDouble();
                        // depositToAccount.depositMoney(depositMoney);
                        System.out.println("\n Your Checking Account Balance is now: " + "$" + currentCheckingBalance);

                    } else if (depositOption == 2) {
                        System.out.println("\n How much would you like to deposit into your savings account?");
                        Double depositMoney = scanner.nextDouble();
                        // depositToAccount.depositMoney(depositMoney);
                        System.out.println("\n Your Savings Account Balance is now: " + "$" + currentSavingsBalance);

                    } else if (depositOption == 3) {
                        System.out.println("\n How much would you like to deposit into your investment account?");
                        Double depositMoney = scanner.nextDouble();
                        // depositToAccount.depositMoney(depositMoney);
                        System.out.println("\n Your Investment Account Balance is now: " + "$" + currentInvestmentBalance);
                    } else if (depositOption == 4) {
                        // Takes you back to Main Menu
                    }
                    break;
                //Withdrawal from Account
                case 4:
                    System.out.println("\n Withdrawal money from: \n (1) Checking Account \n (2) Savings Account \n (3) Investment Account \n (4) Go back to Main Menu ");
                    Integer withdrawalOption = scanner.nextInt();

                    if (withdrawalOption == 1) {
                        System.out.println("\n Your current Checking account balance is: " + "$" + currentCheckingBalance);
                        System.out.println("\n How much would you like to withdrawal?");
                        Double withdrawalMoney = scanner.nextDouble();
                        // withdrawalToAccount.withdrawalMoney(withdrawalMoney);
                        System.out.println("\n Your Checking Account Balance is now: " + "$" + currentCheckingBalance);

                    } else if (withdrawalOption == 2) {
                        System.out.println("\n Your current Savings account balance is: " + "$" + currentSavingsBalance);
                        System.out.println("\n How much would you like to withdrawal?");
                        Double withdrawalMoney = scanner.nextDouble();
                        // withdrawalToAccount.withdrawalMoney(withdrawalMoney);
                        System.out.println("\n Your Savings Account Balance is now: " + "$" + currentSavingsBalance);

                    } else if (withdrawalOption == 3) {
                        System.out.println("\n Your current Investment account balance is: " + "$" + currentInvestmentBalance);
                        System.out.println("\n How much would you like to withdrawal?");
                        Double withdrawalMoney = scanner.nextDouble();
                        // withdrawalToAccount.withdrawalMoney(withdrawalMoney);
                        System.out.println("\n Your Investment Account Balance is now: " + "$" + currentInvestmentBalance);

                    } else if (withdrawalOption == 4) {
                        // Takes you back to Main Menu
                    }
                    break;
                //Transfer across accounts
                case 5:
                    System.out.println("\n Transfer money from: \n (1) Checking to Savings Account \n (2) Checking to Investment Account \n (3) Savings to Checking Account \n (4) Savings to Investment Account \n (5) Investment to Checking Account \n (6) Investment to Savings Account \n (7) Go back to Main Menu");
                    Integer transferOptions = scanner.nextInt();

                    if (transferOptions == 1) {
                        System.out.println("\n You current Checking account balance is: " + "$" + currentCheckingBalance);
                        System.out.println("\n How much would you like to transfer to Savings Account?");
                        Double transferMoney = scanner.nextDouble();
                        // transferToAccount.transferMoney(transferMoney);
                        System.out.println("\n Your Savings Account Balance is now: " + "$" + currentSavingsBalance);

                    } else if (transferOptions == 2) {
                        System.out.println("\n You current Checking account balance is: " + "$" + currentCheckingBalance);
                        System.out.println("\n How much would you like to transfer to Investment Account?");
                        Double transferMoney = scanner.nextDouble();
                        // transferToAccount.transferMoney(transferMoney);
                        System.out.println("\n Your Investment Account Balance is now: " + "$" + currentInvestmentBalance);

                    } else if (transferOptions == 3) {
                        System.out.println("\n Your current Savings account balance is: " + "$" + currentSavingsBalance);
                        System.out.println("\n How much would you like to transfer to Checking Account?");
                        Double transferMoney = scanner.nextDouble();
                        // transferToAccount.transferMoney(transferMoney);
                        System.out.println("\n Your Checking Account Balance is now: " + "$" + currentCheckingBalance);

                    } else if (transferOptions == 4) {
                        System.out.println("\n You current Savings account balance is: " + "$" + currentSavingsBalance);
                        System.out.println("\n How much would you like to transfer to Investment Account?");
                        Double transferMoney = scanner.nextDouble();
                        // transferToAccount.transferMoney(transferMoney);
                        System.out.println("\n Your Investment Account Balance is now: " + "$" + currentInvestmentBalance);

                    } else if (transferOptions == 5) {
                        System.out.println("\n You current Investment account balance is: " + "$" + currentInvestmentBalance);
                        System.out.println("\n How much would you like to transfer to Checking Account?");
                        Double transferMoney = scanner.nextDouble();
                        // transferToAccount.transferMoney(transferMoney);
                        System.out.println("\n Your Checking Balance is now: " + "$" + currentCheckingBalance);
                    } else if (transferOptions == 6) {
                        System.out.println("\n You current Investment account balance is: " + "$" + currentInvestmentBalance);
                        System.out.println("\n How much would you like to transfer to Savings Account?");
                        Double transferMoney = scanner.nextDouble();
                        // transferToAccount.transferMoney(transferMoney);
                        System.out.println("\n Your Savings Account Balance is now: " + "$" + currentSavingsBalance);

                    } else if (transferOptions == 7) {
                        // Takes you back to Main Menu
                    }


            }
        }
    }
}



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

