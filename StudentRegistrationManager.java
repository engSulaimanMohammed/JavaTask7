import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class StudentRegistrationManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<String> waiting = new LinkedList<>();
        Stack<String> completed = new Stack<>();
        IO.print("Number of students: "); int count = Integer.parseInt(input.nextLine());
        if (count <= 0) { IO.println("Invalid number of students."); input.close(); return; }
        for (int i = 0; i < count; i++) { IO.print("Student " + (i + 1) + ": "); waiting.add(input.nextLine()); }
        int choice;
        do {
            IO.println("\n1. Add Student to Queue\n2. Process Student Registration\n3. View Next Student\n4. Undo Last Registration\n5. Search Student\n6. Display Waiting Students\n7. Display Registered Students\n8. Display Statistics\n9. Exit");
            IO.print("Choice: "); choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1: IO.print("Student name: "); waiting.add(input.nextLine()); IO.println("Student added to registration queue successfully."); break;
                case 2:
                    if (waiting.isEmpty()) IO.println("No students waiting for registration.");
                    else { String person = waiting.remove(); completed.push(person); IO.println("Student registration completed."); }
                    break;
                case 3: IO.println(waiting.isEmpty() ? "No students in the queue." : "Next: " + waiting.element()); break;
                case 4: IO.println(completed.isEmpty() ? "No registrations to undo." : "Undone for: " + completed.pop()); break;
                case 5:
                    IO.print("Student name: "); String searched = input.nextLine();
                    if (waiting.contains(searched)) IO.println("Waiting for registration");
                    else if (completed.search(searched) != -1) IO.println("Already registered");
                    else IO.println("Student not found.");
                    break;
                case 6:
                    if (waiting.isEmpty()) IO.println("No waiting students.");
                    else for (String item : waiting) IO.println(item);
                    break;
                case 7:
                    if (completed.isEmpty()) IO.println("No registered students.");
                    else for (String item : completed) IO.println(item);
                    break;
                case 8:
                    IO.println("Total waiting students: " + waiting.size() + "\nTotal registered students: " + completed.size() + "\nNext waiting: " + (waiting.isEmpty() ? "None" : waiting.element()) + "\nLast completed: " + (completed.isEmpty() ? "None" : completed.peek()) + "\nQueue empty: " + waiting.isEmpty() + "\nStack empty: " + completed.isEmpty());
                    break;
                case 9: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 9);
        input.close();
    }
}
