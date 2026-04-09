import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount[] initialData = new BankAccount[5];

        initialData[0] = new BankAccount("101", "Ali", 150000);
        initialData[1] = new BankAccount("102", "Sara", 220000);

        MyQueue accountRequests = new MyQueue();
        MyStack history = new MyStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- BANK SYSTEM (Custom ADS) ---");
            System.out.println("1. Submit Account Request (Queue)");
            System.out.println("2. Admin: Process Request (Queue -> Database)");
            System.out.println("3. ATM: Deposit (Update Balance & History)");
            System.out.println("4. ATM: Undo Last Action (Stack)");
            System.out.println("5. Display All Bank Accounts (Array Traversal - Task 6)");
            System.out.println("6. Exit");

            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter name for new account: ");
                String name = sc.nextLine();
                accountRequests.enqueue(new BankAccount("REQ", name, 0));
                System.out.println("Request added to Queue successfully.");

            } else if (choice == 2) {
                if (!accountRequests.isEmpty()) {
                    BankAccount approved = accountRequests.dequeue();

                    boolean added = false;
                    for (int i = 0; i < initialData.length; i++) {
                        if (initialData[i] == null) {
                            initialData[i] = approved;
                            System.out.println("Admin approved: " + approved.username + " (Added to DB)");
                            added = true;
                            break;
                        }
                    }
                    if (!added) System.out.println("Error: Database is full!");
                } else {
                    System.out.println("Queue is empty. No requests to process.");
                }

            } else if (choice == 3) {
                System.out.print("Enter username to deposit: ");
                String searchName = sc.nextLine();
                boolean found = false;

                for (BankAccount acc : initialData) {
                    if (acc != null && acc.username.equalsIgnoreCase(searchName)) {
                        System.out.print("Enter amount: ");
                        double amount = sc.nextDouble();
                        acc.balance += amount;
                        history.push(acc);
                        System.out.println("Deposit successful for " + acc.username);
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Customer not found in Database.");

            } else if (choice == 4) {
                if (!history.isEmpty()) {
                    BankAccount lastAcc = history.pop();
                    System.out.println("Undoing last operation for: " + lastAcc.username);
                } else {
                    System.out.println("No history to undo.");
                }

            } else if (choice == 5) {
                System.out.println("\n--- Current Bank Database ---");
                boolean hasData = false;
                for (int i = 0; i < initialData.length; i++) {
                    if (initialData[i] != null) {
                        System.out.println("[" + i + "] " + initialData[i]);
                        hasData = true;
                    }
                }
                if (!hasData) System.out.println("Database is currently empty.");

            } else if (choice == 6) {
                System.out.println("Exiting system...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        sc.close();
    }
}