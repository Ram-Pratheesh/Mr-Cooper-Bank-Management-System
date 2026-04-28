import java.util.ArrayList;
public class MiniStatement {
    String accountNumber;
    ArrayList<Transaction> transactions;

    MiniStatement(String accountNumber, ArrayList<Transaction> allTxns){
        this.accountNumber = accountNumber;
        transactions = new ArrayList<>();

        for(Transaction t : allTxns){
            if(t.fromAccount.equals(accountNumber) || t.toAccount.equals(accountNumber))
                transactions.add(t);
        }
    }

    void generate(){
        System.out.println("\n--- Mini Statement for " + accountNumber + " ---");
        if(transactions.isEmpty()){
            System.out.println("No transactions yet.");
            return;
        }
        for(Transaction t : transactions)
            System.out.println(t.getReceipt());
    }
}
