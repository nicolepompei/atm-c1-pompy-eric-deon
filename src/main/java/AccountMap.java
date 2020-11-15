import java.util.HashMap;
import java.util.Map;


//This class creates accounts and generates their ID and then files them into a map
//which allows easy access to return. chose map b/c of key value pair for Id and
// account pairing functionality


public class AccountMap {
        private Map<Integer, Account> accounts;
        private  Integer nextId;


        //the collection of accounts in the ATM is stored in a hashmap. it's responsibility is to maintain a collection of accounts for the bank.
        //an account number is a unique key used to access the account
        //main function: maintain a collection of things and provide an interface for adding and getting access to those things
        public AccountMap(){
            this.accounts = new HashMap<>();
            this.nextId = 0;
        }

        public Account createAccount(Double balance, Integer accountType){
            nextId += 1;
            Account account =  null;
            switch(accountType){
                case 1:
                    account = new Checking(balance, nextId);
                break;
                case 2:
                    account = new Savings(balance, nextId);
                break;
                case 3:
                    account = new Investment(balance, nextId);
                break;
            }

            if(account != null){
                this.accounts.put(nextId, account);
            }
            return account;
        }

        Account getAccountById(Integer id){
            return this.accounts.get(id);
        }

        //GETTER SETTERS & ACCESSORS MUTATORS

    public Map<Integer, Account>getAccounts(){
            return accounts;
    }

    public Integer getNextId(){
            return nextId;
    }

    public void setNextId(Integer nextId){
            this.nextId = nextId;
    }

}

