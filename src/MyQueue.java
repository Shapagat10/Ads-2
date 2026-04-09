public class MyQueue {
    private java.util.LinkedList<BankAccount> list = new java.util.LinkedList<>();

    public void enqueue(BankAccount account) {
        list.addLast(account);
    }

    public BankAccount dequeue() {
        return list.pollFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}