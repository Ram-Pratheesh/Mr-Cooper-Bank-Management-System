import java.util.ArrayList;
public class Bank {
    String name;
    ArrayList<Account> accounts;
    ArrayList<Customer> customers;
    ArrayList<Transaction> transactions;

    Bank(String name){
        this.name = name;
        accounts = new ArrayList<>();
        customers = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    Account createAccount(String accNo, String holder, double bal, String pin){
        Account acc = new Account(accNo, holder, bal, pin);
        accounts.add(acc);
        return acc;
    }

    Account findAccount(String accNo){
        for(Account a : accounts){
            if(a.accountNumber.equals(accNo))
                return a;
        }
        return null;
    }

    boolean closeAccount(String accNo){
        Account acc = findAccount(accNo);
        if(acc != null){
            accounts.remove(acc);
            for(Customer c : customers){
                c.accounts.remove(acc);
            }
            return true;
        }
        return false;
    }
}
