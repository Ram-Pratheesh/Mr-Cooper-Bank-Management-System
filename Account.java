public class Account {
    String accountNumber;
    String holderName;
    double balance;
    String status;
    String pin;
    int failedAttempts;

    Account(String accountNumber, String holderName, double balance, String pin){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
        status = "ACTIVE";
        failedAttempts = 0;
    }

    void deposit(double amount){
        balance = balance + amount;
    }

    boolean withdraw(double amount){
        if(balance >= amount){
            balance = balance - amount;
            return true;
        }
        return false;
    }

    double getBalance(){
        return balance;
    }

    void freeze(){
        status = "FROZEN";
    }
}
