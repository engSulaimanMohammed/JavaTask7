import java.util.Scanner;
public class StudentNameManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer count = IO.readInt(input, "Number of students: ");
        if (count == null) { input.close(); return; }
        if (count <= 0) { IO.println("Invalid number of students."); input.close(); return; }
        String[] names = new String[count];
        for (int i = 0; i < count;) {
            String name = IO.readLine(input, "Student " + (i + 1) + ": ");
            if (name == null) { input.close(); return; }
            boolean duplicate = false;
            for (int j = 0; j < i; j++) if (names[j].equals(name)) duplicate = true;
            if (duplicate) IO.println("Student name already exists.");
            else { names[i] = name; i++; }
        }
        Integer choice;
        do {
            IO.println("\n1. Add Student Name\n2. Search Student Name\n3. Update Student Name\n4. Display All Student Names\n5. Analyze Names\n6. Compare Two Names\n7. Exit");
            choice = IO.readInt(input, "Choice: ");
            if (choice == null) break;
            switch (choice) {
                case 1:
                    String added = IO.readLine(input, "New name: ");
                    if (added == null) { input.close(); return; }
                    boolean duplicate = false;
                    for (int i = 0; i < count; i++) if (names[i].equals(added)) duplicate = true;
                    if (duplicate) IO.println("Student name already exists.");
                    else { String[] expanded = new String[count + 1]; for (int i = 0; i < count; i++) expanded[i] = names[i]; expanded[count++] = added; names = expanded; IO.println("Student name added successfully."); }
                    break;
                case 2:
                    String search = IO.readLine(input, "Search name: ");
                    if (search == null) { input.close(); return; }
                    boolean found = false;
                    for (int i = 0; i < count; i++) if (names[i].equals(search)) found = true;
                    IO.println(found ? "Student found." : "Student not found."); break;
                case 3:
                    String oldName = IO.readLine(input, "Existing name: ");
                    if (oldName == null) { input.close(); return; }
                    String newName = IO.readLine(input, "New name: ");
                    if (newName == null) { input.close(); return; }
                    int index = -1; boolean exists = false;
                    for (int i = 0; i < count; i++) { if (names[i].equals(oldName)) index = i; if (names[i].equals(newName)) exists = true; }
                    if (index < 0) IO.println("Student not found.");
                    else if (exists && !oldName.equals(newName)) IO.println("Student name already exists.");
                    else { names[index] = newName; IO.println("Student name updated successfully."); } break;
                case 4:
                    for (int i = 0; i < count; i++) IO.println((i + 1) + ". " + names[i]); break;
                case 5:
                    int total = 0, startsA = 0, endsA = 0;
                    String longest = names[0], shortest = names[0];
                    for (String name : names) {
                        total += name.length();
                        if (name.length() > longest.length()) longest = name;
                        if (name.length() < shortest.length()) shortest = name;
                        if (name.startsWith("A")) startsA++;
                        if (name.endsWith("a")) endsA++;
                    }
                    IO.println("Students: " + count + "\nLongest: " + longest + "\nShortest: " + shortest + "\nCharacters: " + total + "\nAverage: " + ((double) total / count) + "\nStarting with A: " + startsA + "\nEnding with a: " + endsA);
                    break;
                case 6:
                    String first = IO.readLine(input, "First name: ");
                    if (first == null) { input.close(); return; }
                    String second = IO.readLine(input, "Second name: ");
                    if (second == null) { input.close(); return; }
                    IO.println("equals: " + first.equals(second) + "\nequalsIgnoreCase: " + first.equalsIgnoreCase(second) + "\ncompareTo: " + first.compareTo(second));
                    IO.println("First uppercase: " + first.toUpperCase() + "\nSecond lowercase: " + second.toLowerCase());
                    if (!first.isEmpty()) IO.println("First character: " + first.charAt(0) + "\nFirst substring: " + first.substring(0, 1));
                    break;
                case 7: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 7);
        input.close();
    }
}
