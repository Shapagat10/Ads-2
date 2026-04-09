public class MyStack {
    Node top;

    public void push(BankAccount a) {
        Node newNode = new Node(a);
        newNode.next = top;
        top = newNode;
    }

    public BankAccount pop() {
        if (top == null) return null;
        BankAccount a = top.data;
        top = top.next;
        return a;
    }
}