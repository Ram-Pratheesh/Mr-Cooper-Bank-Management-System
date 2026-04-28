import java.util.ArrayList;

public class Customer {
    String customerId;
    String name;
    String phone;
    ArrayList<Account> accounts;

    Customer(String customerId, String name, String phone){
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        accounts = new ArrayList<>();
    }

    boolean authenticate(String accNumber, String enteredPin){
        for(Account acc : accounts){
            if(acc.accountNumber.equals(accNumber)){
                if(acc.pin.equals(enteredPin)){
                    acc.failedAttempts = 0; 
                    return true;
                }
                else{
                    acc.failedAttempts++;
                    if(acc.failedAttempts >= 3){
                        acc.freeze();
                        System.out.println("Account locked! Too many wrong attempts.");
                    }
                    else{
                        System.out.println("Wrong PIN. You have " + (3 - acc.failedAttempts) + " tries left.");
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
