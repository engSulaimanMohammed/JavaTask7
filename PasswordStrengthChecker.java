import java.util.Scanner;
public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        IO.print("Enter password: "); String password = input.nextLine();
        if (password.length() <= 0) IO.println("Invalid password.");
        int choice;
        do {
            IO.println("\n1. Enter Password\n2. Check Password Length\n3. Analyze Password Characters\n4. Check Password Strength\n5. Convert Password Format\n6. Display Password Report\n7. Exit");
            IO.print("Choice: "); choice = Integer.parseInt(input.nextLine());
            if (choice >= 2 && choice <= 6 && password.isEmpty()) { IO.println("Invalid password."); continue; }
            switch (choice) {
                case 1:
                    IO.print("Enter password: "); password = input.nextLine();
                    IO.println(password.isEmpty() ? "Invalid password." : "Password saved successfully."); break;
                case 2:
                    IO.println("Password length: " + password.length());
                    IO.println(password.length() < 8 ? "Password is too short." : "Password length is acceptable."); break;
                case 3: case 4: case 6:
                    int upper = 0, lower = 0, digits = 0, special = 0;
                    for (int i = 0; i < password.length(); i++) {
                        char c = password.charAt(i);
                        if (Character.isUpperCase(c)) upper++;
                        else if (Character.isLowerCase(c)) lower++;
                        else if (Character.isDigit(c)) digits++;
                        else special++;
                    }
                    int kinds = (upper > 0 ? 1 : 0) + (lower > 0 ? 1 : 0) + (digits > 0 ? 1 : 0) + (special > 0 ? 1 : 0);
                    String strength = password.length() >= 8 && kinds == 4 ? "Strong Password" : password.length() >= 8 && kinds >= 2 ? "Medium Password" : "Weak Password";
                    if (choice == 6) IO.println("Length: " + password.length() + "\nFirst character: " + password.charAt(0) + "\nLast character: " + password.charAt(password.length() - 1));
                    if (choice != 4) IO.println("Uppercase letters: " + upper + "\nLowercase letters: " + lower + "\nDigits: " + digits + "\nSpecial characters: " + special);
                    if (choice != 3) IO.println("Strength: " + strength); break;
                case 5:
                    IO.println("Uppercase: " + password.toUpperCase() + "\nLowercase: " + password.toLowerCase());
                    IO.println("Contains @: " + password.contains("@") + "\nEquals PASSWORD: " + password.equals("PASSWORD") + "\nStarts with A: " + password.startsWith("A") + "\nEnds with !: " + password.endsWith("!")); break;
                case 7: IO.println("Goodbye."); break;
                default: IO.println("Invalid choice.");
            }
        } while (choice != 7);
        input.close();
    }
}
