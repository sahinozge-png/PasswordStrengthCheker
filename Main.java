//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        scanner.close();

        String strengthFdb = checkPasswordStrength(password);
        System.out.println(strengthFdb);
    }

    public static String checkPasswordStrength(String password) {
        int idealLength = 8;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()_+[]{}|;:,.<>?~";

        if (password.length() >= idealLength) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                } else if (Character.isLowerCase(c)) {
                    hasLowercase = true;
                } else if (Character.isDigit(c)) {
                    hasNumber = true;
                } else if (specialChars.contains(String.valueOf(c))) {
                    hasSpecialChar = true;
                }
            }

            if (hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
                return "✅ It is a Strong Password!";
            } else {
                return "⚠️ It is a Weak Password.\nPlease include:\n- Uppercase letters\n- Lowercase letters\n- Numbers\n- Special characters.";
            }
        } else {
            return "🚫 Password length must be at least " + idealLength + " characters!";
        }
    }
}