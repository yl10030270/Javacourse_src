package lab9;

import java.util.Random;

//************************************************************
//Account.java
//
//A bank account class with methods to deposit to, withdraw from,
//change the name on, and get a String representation
//of the account.
//************************************************************
public class Account {
    private double balance;
    private String name;
    private long acctNum;
    private static int numAccounts;

    // -------------------------------------------------
    // Constructor -- initializes balance, owner, and account number
    // -------------------------------------------------
    public Account(double initBal, String owner, long number) {
        balance = initBal;
        name = owner;
        acctNum = number;
        numAccounts++;
    }

    // -------------------------------------------------
    // Constructor -- initializes balance, owner and a random account number
    // -------------------------------------------------
    public Account(double initBal, String owner) {
        balance = initBal;
        name = owner;
        Random generator = new Random();
        acctNum = generator.nextLong();
        numAccounts++;
    }

    // -------------------------------------------------
    // Constructor -- initializes balance equal 0, owner and a random account
    // number
    // -------------------------------------------------
    public Account(String owner) {
        balance = 0;
        name = owner;
        Random generator = new Random();
        acctNum = generator.nextLong();
        numAccounts++;
    }

    public String getName() {
        return name;
    }

    public long getAcctNum() {
        return acctNum;
    }

    // -------------------------------------------------
    // Returns balance.
    // -------------------------------------------------
    public double getBalance() {
        return balance;
    }

    // -------------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    // -------------------------------------------------
    public void withdraw(double amount) {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient funds");
    }

    // -------------------------------------------------
    // takes a fee and deducts that fee from the account.
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    // -------------------------------------------------
    public void withdraw(double amount, double fee) {

        if (balance >= amount + fee)
            balance = balance - amount - fee;
        else
            System.out.println("Insufficient funds");
    }

    // -------------------------------------------------
    // Adds deposit amount to balance.
    // -------------------------------------------------

    public void deposit(double amount) {
        balance += amount;
    }

    // -------------------------------------------------
    // Returns a string containing the name, account number, and balance.
    // -------------------------------------------------
    public String toString() {
        return "Name:" + name + "\nAccount Number: " + acctNum + "\nBalance: "
                + balance;
    }

    public static int getNumAccounts() {
        return numAccounts;
    }

    public void close() {
        name += "-CLOSED";
        balance = 0;
        numAccounts--;
    }

    public static Account consolidate(Account acct1, Account acct2) {
        if (acct1.getName().equalsIgnoreCase(acct2.getName())
                && acct1.getAcctNum() != acct2.getAcctNum()) {
            Account newAcct = new Account(acct1.getBalance()
                    + acct2.getBalance(), acct1.getName());
            acct1.close();
            acct2.close();
            return newAcct;
        } else {
            System.out.println();
            System.out.println("Account " + acct1.getName() + " and "
                    + acct2.getName() + " are not consolidatable.");
            System.out.println();
            return null;
        }
    }
}
