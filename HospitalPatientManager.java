import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class HospitalPatientManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> waiting = new LinkedList<>();
        Stack<String> completed = new Stack<>();
        IO.print("Number of patients: "); int count = Integer.parseInt(input.nextLine());
        if (count <= 0) { IO.println("Invalid number of patients."); input.close(); return; }
        for (int i = 0; i < count; i++) { IO.print("Patient " + (i + 1) + ": "); waiting.offer(input.nextLine()); }
        int choice;
        do {
            IO.println("\n1. Add Patient\n2. Treat Patient\n3. View Next Patient\n4. Undo Last Treatment\n5. Search Patient\n6. Display Waiting Patients\n7. Display Treated Patients\n8. Display Hospital Statistics\n9. Exit");
            IO.print("Choice: "); choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1: IO.print("Patient name: "); waiting.offer(input.nextLine()); IO.println("Patient added successfully."); break;
                case 2:
                    if (waiting.isEmpty()) IO.println("No patients waiting for treatment.");
                    else { String person = waiting.poll(); completed.push(person); IO.println("Patient treatment completed successfully."); }
                    break;
                case 3: IO.println(waiting.isEmpty() ? "No patients available." : "Next: " + waiting.peek()); break;
                case 4: IO.println(completed.isEmpty() ? "No completed treatments available." : "Undone for: " + completed.pop()); break;
                case 5:
                    IO.print("Patient name: "); String searched = input.nextLine();
                    if (waiting.contains(searched)) IO.println("Patient is waiting for treatment.");
                    else if (completed.search(searched) != -1) IO.println("Patient treatment completed.");
                    else IO.println("Patient not found.");
                    break;
                case 6:
                    if (waiting.isEmpty()) IO.println("No waiting patients.");
                    else for (String item : waiting) IO.println(item);
                    break;
                case 7:
                    if (completed.isEmpty()) IO.println("No treated patients.");
                    else for (String item : completed) IO.println(item);
                    break;
                case 8:
                    IO.println("Total waiting patients: " + waiting.size() + "\nTotal treated patients: " + completed.size() + "\nNext waiting: " + (waiting.isEmpty() ? "None" : waiting.peek()) + "\nLast completed: " + (completed.isEmpty() ? "None" : completed.peek()) + "\nQueue empty: " + waiting.isEmpty() + "\nStack empty: " + completed.isEmpty());
                    break;
                case 9: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 9);
        input.close();
    }
}
