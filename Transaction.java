import java.time.LocalDateTime;

public class Transaction {
    String txnId;
    String fromAccount;
    String toAccount;
    double amount;
    String type;
    String timestamp;
    String status;
    static int counter = 100; 

    Transaction(String from, String to, double amount, String type){
        this.txnId = "TXN" + (++counter);
        this.fromAccount = from;
        this.toAccount = to;
        this.amount = amount;
        this.type = type;
        this.timestamp = LocalDateTime.now().toString();
        this.status = "SUCCESS";
    }
    String getReceipt(){
        return txnId + " | " + type + " | Rs." + amount + " | " + status + " | " + timestamp;
    }
}
