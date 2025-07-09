package mailService;

import books.EBook;
import validators.BookValidator;
import validators.UserValidator;

public class MailService {
    public static void sendEmail(EBook ebook, String email) {
        if (BookValidator.doesBookExist(ebook) && UserValidator.isValidEmail(email)) {
            System.out.println("Sending Book: " + ebook.getTitle());
            System.out.println("via email to: " + email);
        }
    }
}
