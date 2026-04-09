public class BankAccount {
    String name;
    double balance;

    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String toString() {
        return "User: " + name + " | Balance: $" + balance;
    }
}