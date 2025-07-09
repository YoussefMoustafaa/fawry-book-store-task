package validators;

public class UserValidator {

    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        // Simple regex for email validation
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return true;
    }


    public static boolean isValidAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Invalid address format! \nBook cannot be delivered to an empty address.");
        }
        return true;
    }
}
