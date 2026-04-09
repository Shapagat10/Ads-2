import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount[] db = new BankAccount[5];
        db[0] = new BankAccount("Ali", 1000);
        db[1] = new BankAccount("Sara", 2000);
        MyQueue queue = new MyQueue();
        MyStack stack = new MyStack();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Register 2.Approve 3.Deposit 4.Undo 5.Show All 6.Exit");
            int choice = sc.nextInt(); sc.nextLine();

            if (choice == 1) {
                System.out.print("Name: ");
                queue.enqueue(new BankAccount(sc.nextLine(), 0));
            } else if (choice == 2) {
                BankAccount a = queue.dequeue();
                if (a != null) {
                    for(int i=0; i<5; i++) if(db[i]==null) { db[i]=a; break; }
                    System.out.println("Approved: " + a.name);
                }
            } else if (choice == 3) {
                System.out.print("Name: ");
                String n = sc.nextLine();
                for (BankAccount a : db) {
                    if (a != null && a.name.equalsIgnoreCase(n)) {
                        System.out.print("Sum: ");
                        double sum = sc.nextDouble();
                        a.balance += sum;
                        stack.push(a);
                        break;
                    }
                }
            } else if (choice == 4) {
                BankAccount a = stack.pop();
                if (a != null) System.out.println("Undo for: " + a.name);
            } else if (choice == 5) {
                for (BankAccount a : db) if (a != null) System.out.println(a);
            } else break;
        }
    }
}