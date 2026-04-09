public class MyQueue {
    Node head, tail;

    public void enqueue(BankAccount a) {
        Node newNode = new Node(a);
        if (tail == null) { head = tail = newNode; return; }
        tail.next = newNode;
        tail = newNode;
    }

    public BankAccount dequeue() {
        if (head == null) return null;
        BankAccount a = head.data;
        head = head.next;
        if (head == null) tail = null;
        return a;
    }
}