import java.util.Scanner;

public class IO {
    public static void print(Object value) { System.out.print(value); }
    public static void println(Object value) { System.out.println(value); }

    public static String readLine(Scanner input, String prompt) {
        print(prompt);
        if (!input.hasNextLine()) {
            println("Input ended.");
            return null;
        }
        return input.nextLine();
    }

    public static Integer readInt(Scanner input, String prompt) {
        while (true) {
            String value = readLine(input, prompt);
            if (value == null) return null;
            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException exception) {
                println("Invalid number. Please enter a whole number from -2147483648 to 2147483647.");
            }
        }
    }
}
