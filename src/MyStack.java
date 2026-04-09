public class MyStack {
    private Node top;

    public void push(BankAccount account) {
        Node newNode = new Node(account);
        newNode.next = top;
        top = newNode;
    }

    public BankAccount pop() {
        if (top == null) return null;
        BankAccount data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}