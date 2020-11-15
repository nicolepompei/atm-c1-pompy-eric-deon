import java.util.HashMap;

public class ConsoleIdeas {

   AccountMap accountMap = new AccountMap();
   private String currentUserName = "";

   //helper function in the console logic that helps to rertrieve the current user from the master list/map of users
    //in the master list of users we can iterate through it to find the id associated with their account
    //append their id and name of account to the output message for them to choose an account
    //they choose the account by inputting the id (id is generated when account is created so it is unique therefore the reason why we need to search for their account and output all of the ids and accounts they have
    public Integer promptAccount(){
        Integer accountId;
        StringBuilder message = new StringBuilder();

        User user = userList.getUserByUsername(currentUserName);

        for(Integer id : user.getAccountsById()){

            Account account = accountMap.getAccountById(id);
            message.append(String.format("%s : %s\n", id, Account.getName()));
        }

    }
        message.append("Choose an account to access: ");
        do {
        accountId = Console.getIntegerInput(message.toString());
    } while (!user.getAccountsIds().contains(accountId));
        return accountId;

    }



}
