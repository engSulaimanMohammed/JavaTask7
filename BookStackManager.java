import java.util.Scanner;
import java.util.Stack;
public class BookStackManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> books = new Stack<>();
        Integer count = IO.readInt(input, "Number of books: ");
        if (count == null) { input.close(); return; }
        if (count <= 0) { IO.println("Invalid number of books."); input.close(); return; }
        for (int i = 0; i < count; i++) {
            String value = IO.readLine(input, "Book " + (i + 1) + ": ");
            if (value == null) { input.close(); return; }
            books.push(value);
        }
        Integer choice;
        do {
            IO.println("\n1. Add Book\n2. Remove Top Book\n3. View Top Book\n4. Search Book\n5. Display All Books\n6. Display Stack Statistics\n7. Exit");
            choice = IO.readInt(input, "Choice: ");
            if (choice == null) break;
            switch (choice) {
                case 1:
                    String addedValue = IO.readLine(input, "Book title: ");
                    if (addedValue == null) { input.close(); return; }
                    books.push(addedValue);
                    IO.println("Book added successfully."); break;
                case 2: IO.println(books.isEmpty() ? "No books available." : "Removed book: " + books.pop()); break;
                case 3: IO.println(books.isEmpty() ? "No books available." : "Top book: " + books.peek()); break;
                case 4:
                    String searchedValue = IO.readLine(input, "Book title: ");
                    if (searchedValue == null) { input.close(); return; }
                    int position = books.search(searchedValue);
                    IO.println(position < 0 ? "Book not found." : "Position from top: " + position); break;
                case 5: if (books.isEmpty()) IO.println("No books available."); else for (String book : books) IO.println(book); break;
                case 6: IO.println("Total books: " + books.size() + "\nTop book: " + (books.isEmpty() ? "None" : books.peek()) + "\nStack empty: " + books.isEmpty()); break;
                case 7: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 7);
        input.close();
    }
}
