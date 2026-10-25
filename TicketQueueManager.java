import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class TicketQueueManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        IO.print("Number of customers: "); int count = Integer.parseInt(input.nextLine());
        if (count <= 0) { IO.println("Invalid number of customers."); input.close(); return; }
        for (int i = 0; i < count; i++) { IO.print("Customer " + (i + 1) + ": "); queue.add(input.nextLine()); }
        int choice;
        do {
            IO.println("\n1. Add Customer\n2. Serve Customer\n3. View Next Customer\n4. Search Customer\n5. Display All Customers\n6. Display Queue Statistics\n7. Exit");
            IO.print("Choice: "); choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1: IO.print("Customer name: "); queue.add(input.nextLine()); IO.println("Customer added successfully."); break;
                case 2: IO.println(queue.isEmpty() ? "Queue is empty." : "Served customer: " + queue.remove()); break;
                case 3: IO.println(queue.isEmpty() ? "Queue is empty." : "Next customer: " + queue.element()); break;
                case 4: IO.print("Customer name: "); IO.println(queue.contains(input.nextLine()) ? "Customer found in queue." : "Customer not found."); break;
                case 5: if (queue.isEmpty()) IO.println("Queue is empty."); else for (String item : queue) IO.println(item); break;
                case 6:
                    String last = "None";
                    for (String item : queue) last = item;
                    IO.println("Total customers: " + queue.size() + "\nFirst: " + (queue.isEmpty() ? "None" : queue.element()) + "\nLast: " + last + "\nQueue empty: " + queue.isEmpty()); break;
                case 7: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 7);
        input.close();
    }
}
