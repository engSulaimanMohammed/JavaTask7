import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class PrintQueueManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        Integer count = IO.readInt(input, "Number of print jobs: ");
        if (count == null) { input.close(); return; }
        if (count <= 0) { IO.println("Invalid number of print jobs."); input.close(); return; }
        for (int i = 0; i < count; i++) { IO.print("Print job " + (i + 1) + ": "); queue.offer(input.nextLine()); }
        Integer choice;
        do {
            IO.println("\n1. Add Print Job\n2. Process Next Print Job\n3. View Next Print Job\n4. Search Print Job\n5. Remove Print Job\n6. Display All Print Jobs\n7. Display Queue Statistics\n8. Exit");
            choice = IO.readInt(input, "Choice: ");
            if (choice == null) break;
            switch (choice) {
                case 1: IO.print("Print job name: "); queue.offer(input.nextLine()); IO.println("Print job added successfully."); break;
                case 2: IO.println(queue.isEmpty() ? "No print jobs in the queue." : "Processed print job: " + queue.poll()); break;
                case 3: IO.println(queue.isEmpty() ? "No print jobs in the queue." : "Next print job: " + queue.peek()); break;
                case 4: IO.print("Print job name: "); IO.println(queue.contains(input.nextLine()) ? "Print job found in queue." : "Print job not found."); break;
                case 5: IO.print("Print job name: "); IO.println(queue.remove(input.nextLine()) ? "Print job removed successfully." : "Print job not found."); break;
                case 6: if (queue.isEmpty()) IO.println("No print jobs in the queue."); else for (String item : queue) IO.println(item); break;
                case 7:
                    String last = "None";
                    for (String item : queue) last = item;
                    IO.println("Total print jobs: " + queue.size() + "\nFirst: " + (queue.isEmpty() ? "None" : queue.peek()) + "\nLast: " + last + "\nQueue empty: " + queue.isEmpty()); break;
                case 8: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 8);
        input.close();
    }
}
