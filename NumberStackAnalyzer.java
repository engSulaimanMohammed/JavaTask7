import java.util.Scanner;
import java.util.Stack;
public class NumberStackAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> numbers = new Stack<>();
        Integer count = IO.readInt(input, "Number of values: ");
        if (count == null) { input.close(); return; }
        if (count <= 0) { IO.println("Invalid number of values."); input.close(); return; }
        for (int i = 0; i < count; i++) {
            Integer number = IO.readInt(input, "Number " + (i + 1) + ": ");
            if (number == null) { input.close(); return; }
            numbers.push(number);
        }
        Integer choice;
        do {
            IO.println("\n1. Add Number\n2. Remove Top Number\n3. View Top Number\n4. Display All Numbers\n5. Analyze Numbers\n6. Exit");
            choice = IO.readInt(input, "Choice: ");
            if (choice == null) break;
            switch (choice) {
                case 1:
                    Integer addedNumber = IO.readInt(input, "Number: ");
                    if (addedNumber == null) { input.close(); return; }
                    numbers.push(addedNumber);
                    IO.println("Number added successfully."); break;
                case 2: IO.println(numbers.isEmpty() ? "Stack is empty." : "Removed: " + numbers.pop()); break;
                case 3: IO.println(numbers.isEmpty() ? "Stack is empty." : "Top number: " + numbers.peek()); break;
                case 4: if (numbers.isEmpty()) IO.println("Stack is empty."); else for (int number : numbers) IO.println(number); break;
                case 5:
                    if (numbers.isEmpty()) { IO.println("Stack is empty."); break; }
                    long sum = 0; int largest = numbers.get(0), smallest = numbers.get(0);
                    int even = 0, odd = 0, positive = 0, negative = 0, zeros = 0;
                    for (int number : numbers) {
                        sum += number;
                        if (number > largest) largest = number;
                        if (number < smallest) smallest = number;
                        if (number % 2 == 0) even++; else odd++;
                        if (number > 0) positive++; else if (number < 0) negative++; else zeros++;
                    }
                    IO.println("Total: " + numbers.size() + "\nSum: " + sum + "\nAverage: " + ((double) sum / numbers.size()) + "\nLargest: " + largest + "\nSmallest: " + smallest + "\nEven: " + even + "\nOdd: " + odd + "\nPositive: " + positive + "\nNegative: " + negative + "\nZeros: " + zeros); break;
                case 6: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 6);
        input.close();
    }
}
