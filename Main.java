import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank("National Bank");

        
        Account a1 = bank.createAccount("1001", "Rahul", 5000, "1234");
        Account a2 = bank.createAccount("1002", "Priya", 8000, "5678");

        Customer c1 = new Customer("C001", "Rahul", "9876543210");
        c1.accounts.add(a1);
        bank.customers.add(c1);

        Customer c2 = new Customer("C002", "Priya", "9123456780");
        c2.accounts.add(a2);
        bank.customers.add(c2);

        System.out.println("=== " + bank.name + " ===");

        while(true) {
            System.out.println("\n1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if(ch == 2) break;

            System.out.print("Enter Account Number: ");
            String accNum = sc.nextLine();
            Account acc = bank.findAccount(accNum);

            if(acc == null){
                System.out.println("Account not found!");
                continue;
            }
            if(acc.status.equals("FROZEN")){
                System.out.println("This account is frozen. Contact bank.");
                continue;
            }

            Customer cust = null;
            for(Customer c : bank.customers){
                for(Account a : c.accounts){
                    if(a.accountNumber.equals(accNum)){
                        cust = c;
                    }
                }
            }

            System.out.print("Enter PIN: ");
            String pin = sc.nextLine();
            if(!cust.authenticate(accNum, pin)) continue;

            System.out.println("Welcome " + cust.name + "!");
            System.out.println("Your balance: Rs." + acc.getBalance());

            boolean loggedIn = true;
            while(loggedIn) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Mini Statement");
                System.out.println("5. Check Balance");
                System.out.println("6. Logout");
                System.out.println("7. Close Account");
                System.out.print("Choice: ");
                int op = sc.nextInt();
                sc.nextLine();

                switch(op) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depAmt = sc.nextDouble();
                        acc.deposit(depAmt);
                        bank.transactions.add(new Transaction(accNum, accNum, depAmt, "DEPOSIT"));
                        System.out.println("Deposited Rs." + depAmt + ". New balance: Rs." + acc.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wdAmt = sc.nextDouble();
                        if(acc.withdraw(wdAmt)){
                            bank.transactions.add(new Transaction(accNum, accNum, wdAmt, "WITHDRAW"));
                            System.out.println("Withdrawn Rs." + wdAmt + ". Balance: Rs." + acc.getBalance());
                        } else {
                            System.out.println("Not enough balance!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter recipient account number: ");
                        String toAccNum = sc.nextLine();
                        Account toAcc = bank.findAccount(toAccNum);
                        if(toAcc == null){
                            System.out.println("That account does not exist.");
                            break;
                        }
                        System.out.print("Enter amount: ");
                        double transferAmt = sc.nextDouble();
                        if(acc.withdraw(transferAmt)){
                            toAcc.deposit(transferAmt);
                            bank.transactions.add(new Transaction(accNum, toAccNum, transferAmt, "TRANSFER"));
                            System.out.println("Sent Rs." + transferAmt + " to account " + toAccNum);
                        } else {
                            System.out.println("Not enough balance for transfer!");
                        }
                        break;

                    case 4:
                        MiniStatement ms = new MiniStatement(accNum, bank.transactions);
                        ms.generate();
                        break;

                    case 5:
                        System.out.println("Current balance: Rs." + acc.getBalance());
                        break;

                    case 6:
                        loggedIn = false;
                        System.out.println("Logged out successfully.");
                        break;

                    case 7:
                        System.out.print("Are you sure you want to close this account? (Y/N): ");
                        String confirm = sc.nextLine();
                        if(confirm.equalsIgnoreCase("Y")){
                            if(bank.closeAccount(accNum)){
                                System.out.println("Account closed successfully.");
                                loggedIn = false;
                            } else {
                                System.out.println("Failed to close account.");
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid choice, try again.");
                }
            }
        }
        System.out.println("Thank you for using " + bank.name + "!");
        sc.close();
    }
}
