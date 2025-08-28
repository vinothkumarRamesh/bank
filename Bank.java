class BankAccount {
    int balance = 1000;
    synchronized void deposit(int amt) {
        balance += amt;
        System.out.println("Deposited: " + amt + " | Balance: " + balance);
    }
    synchronized void withdraw(int amt) {
        if(balance >= amt) {
            balance -= amt;
            System.out.println("Withdrew: " + amt + " | Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

public class Bank{
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        Thread t1 = new Thread(() -> acc.deposit(500));
        Thread t2 = new Thread(() -> acc.withdraw(700));
        t1.start(); t2.start();
    }
}
