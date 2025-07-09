package shippingService;

import books.PaperBook;
import validators.BookValidator;
import validators.UserValidator;

public class ShippingService {
    public static void shipBook(PaperBook paperBook, int quantity, String address) {
        if (BookValidator.checkQuantity(quantity) && BookValidator.isBookAvailable(paperBook) && UserValidator.isValidAddress(address)) {
            System.out.println("Shipping " + quantity + " copies of paper book: " + paperBook.getTitle() +
                    "\nTo address: " + address);
            System.out.println("Remaining stock after shipping: " + (paperBook.getStock() - quantity));
        }
    }
}
