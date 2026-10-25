import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class CustomerQueueManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        Integer count = IO.readInt(input, "Number of customers: ");
        if (count == null) { input.close(); return; }
        if (count <= 0) { IO.println("Invalid number of customers."); input.close(); return; }
        for (int i = 0; i < count; i++) { IO.print("Customer " + (i + 1) + ": "); queue.offer(input.nextLine()); }
        Integer choice;
        do {
            IO.println("\n1. Add Customer\n2. Serve Customer\n3. View Next Customer\n4. Search Customer\n5. Display All Customers\n6. Display Queue Statistics\n7. Exit");
            choice = IO.readInt(input, "Choice: ");
            if (choice == null) break;
            switch (choice) {
                case 1: IO.print("Customer name: "); queue.offer(input.nextLine()); IO.println("Customer added successfully."); break;
                case 2: IO.println(queue.isEmpty() ? "No customers in the queue." : "Served customer: " + queue.poll()); break;
                case 3: IO.println(queue.isEmpty() ? "No customers in the queue." : "Next customer: " + queue.peek()); break;
                case 4: IO.print("Customer name: "); IO.println(queue.contains(input.nextLine()) ? "Customer found in queue." : "Customer not found."); break;
                case 5: if (queue.isEmpty()) IO.println("No customers in the queue."); else for (String item : queue) IO.println(item); break;
                case 6:
                    String last = "None";
                    for (String item : queue) last = item;
                    IO.println("Total customers: " + queue.size() + "\nFirst: " + (queue.isEmpty() ? "None" : queue.peek()) + "\nLast: " + last + "\nQueue empty: " + queue.isEmpty()); break;
                case 7: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 7);
        input.close();
    }
}
