import java.util.Scanner;
public class StudentNameManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IO.print("Number of students: ");
        int count = Integer.parseInt(input.nextLine());
        if (count <= 0) { IO.println("Invalid number of students."); input.close(); return; }
        String[] names = new String[count];
        for (int i = 0; i < count; i++) { IO.print("Student " + (i + 1) + ": "); names[i] = input.nextLine(); }
        int choice;
        do {
            IO.println("\n1. Add Student Name\n2. Search Student Name\n3. Update Student Name\n4. Display All Student Names\n5. Analyze Names\n6. Compare Two Names\n7. Exit");
            IO.print("Choice: "); choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    IO.print("New name: "); String added = input.nextLine();
                    boolean duplicate = false;
                    for (int i = 0; i < count; i++) if (names[i].equals(added)) duplicate = true;
                    if (duplicate) IO.println("Student name already exists.");
                    else { String[] expanded = new String[count + 1]; for (int i = 0; i < count; i++) expanded[i] = names[i]; expanded[count++] = added; names = expanded; IO.println("Student name added successfully."); }
                    break;
                case 2:
                    IO.print("Search name: "); String search = input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) if (names[i].equals(search)) found = true;
                    IO.println(found ? "Student found." : "Student not found."); break;
                case 3:
                    IO.print("Existing name: "); String oldName = input.nextLine();
                    IO.print("New name: "); String newName = input.nextLine();
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
                    IO.print("First name: "); String first = input.nextLine();
                    IO.print("Second name: "); String second = input.nextLine();
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
