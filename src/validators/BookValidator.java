package validators;

import books.Book;
import books.PaperBook;

public class BookValidator {

    public static boolean isValidISBN(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("Invalid ISBN!");
        }
        // Check if the ISBN is 13 characters long
        if (isbn.length() != 13) {
            throw new IllegalArgumentException("Invalid ISBN!");
        }
        return true;
    }


    public static boolean checkQuantity(Integer quantity) {
        if (quantity == null) {
            throw new IllegalArgumentException("Quantity is null!");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative!");
        }
        return true;
    }


    public static boolean checkStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative!");
        }
        return true;
    }


    public static boolean checkQuantityWithStock(int quantity, int stock) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock to sell " + quantity + " items");
        }
        return true;
    }


    public static boolean isValidYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative!");
        }
        int currentYear = java.time.Year.now().getValue();
        if (year > currentYear) {
            throw new IllegalArgumentException("Published year cannot be in the future!");
        }
        return true;
    }


    public static boolean isValidPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        return true;
    }


    public static boolean isValidTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Invalid book title!");
        }
        return true;
    }


    public static boolean isValidFileType(String fileType) {
        if (fileType == null || fileType.isEmpty()) {
            throw new IllegalArgumentException("Invalid file type: " + fileType);
        }
        return true;
    }


    public static boolean doesBookExist(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book does not exist!");
        }
        return true;
    }


    public static boolean isBookAvailable(PaperBook paperBook) {
        if (paperBook.getStock() <= 0) {
            throw new IllegalArgumentException("Cannot buy " + paperBook.getTitle() + ": out of stock");
        }
        return true;
    }
}
