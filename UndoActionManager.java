import java.util.Scanner;
import java.util.Stack;
public class UndoActionManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> actions = new Stack<>();
        Integer count = IO.readInt(input, "Number of actions: ");
        if (count == null) { input.close(); return; }
        if (count <= 0) { IO.println("Invalid number of actions."); input.close(); return; }
        for (int i = 0; i < count; i++) {
            String value = IO.readLine(input, "Action " + (i + 1) + ": ");
            if (value == null) { input.close(); return; }
            actions.push(value);
        }
        Integer choice;
        do {
            IO.println("\n1. Add Action\n2. Undo Last Action\n3. View Last Action\n4. Search Action\n5. Display All Actions\n6. Display Action Statistics\n7. Clear All Actions\n8. Exit");
            choice = IO.readInt(input, "Choice: ");
            if (choice == null) break;
            switch (choice) {
                case 1:
                    String addedValue = IO.readLine(input, "Action: ");
                    if (addedValue == null) { input.close(); return; }
                    actions.push(addedValue);
                    IO.println("Action added successfully."); break;
                case 2: IO.println(actions.isEmpty() ? "No actions to undo." : "Undone: " + actions.pop()); break;
                case 3: IO.println(actions.isEmpty() ? "No actions available." : "Last action: " + actions.peek()); break;
                case 4:
                    String searchedValue = IO.readLine(input, "Action: ");
                    if (searchedValue == null) { input.close(); return; }
                    int position = actions.search(searchedValue);
                    IO.println(position < 0 ? "Action not found." : "Position from top: " + position); break;
                case 5: if (actions.isEmpty()) IO.println("No actions available."); else for (String action : actions) IO.println(action); break;
                case 6: IO.println("Total actions: " + actions.size() + "\nMost recent action: " + (actions.isEmpty() ? "None" : actions.peek()) + "\nStack empty: " + actions.isEmpty()); break;
                case 7: actions.clear(); IO.println("All actions have been cleared."); break;
                case 8: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 8);
        input.close();
    }
}
