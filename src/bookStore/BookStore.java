package bookStore;
import java.util.ArrayList;
import java.util.List;

import books.Book;
import books.DemoBook;
import books.EBook;
import books.PaperBook;

import java.time.Year;

import purchaseRequest.PurchaseRequest;
import validators.BookValidator;


public class BookStore {
    List<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }

    // Add any type of book
    public void addBook(Book book) {
        if (BookValidator.doesBookExist(book)) {
            books.add(book);
        }
    }

    // Add DemoBook
    public void addBook(String title, double price, int year) {
        Book newBook = new DemoBook(title, price, year);
        addBook(newBook);
    }

    // Add PaperBook
    public void addBook(String title, double price, int year, int stock) {
        Book newBook = new PaperBook(title, price, year, stock);
        addBook(newBook);
    }

    // Add EBook
    public void addBook(String title, double price, int year, String fileType) {
        Book newBook = new EBook(title, price, year, fileType);
        addBook(newBook);
    }

    public void removeBook(Book book) {
        String isbn = book.getISBN();
        books.removeIf(b -> b.getISBN().equals(isbn));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByISBN(String isbn) {
        if (BookValidator.isValidISBN(isbn)) {
            for (Book book : books) {
                if (book.getISBN().equals(isbn)) {
                    return book;
                }
            }
        }
        throw new IllegalArgumentException("Book with ISBN " + isbn + " not found");
    }

    public List<Book> removeOutdatedBooks(int passedYears) {
        List<Book> outdatedBooks = new ArrayList<>();
        List<Book> updatedBooks = new ArrayList<>(books);
        if (BookValidator.isValidYear(passedYears)) {
            int currentYear = Year.now().getValue();
            for (Book book : books) {
                if (passedYears < currentYear - book.getYear()) {
                    outdatedBooks.add(book);
                    updatedBooks.remove(book);
                }
            }
        }
        this.books = updatedBooks;
        return outdatedBooks;
    }

    public void buy(String isbn, Integer quantity, String email, String address) {
        if (BookValidator.isValidISBN(isbn)) {
            Book book = findBookByISBN(isbn);
            if (BookValidator.doesBookExist(book)) {
                PurchaseRequest request = new PurchaseRequest(isbn, quantity, email, address);
                book.buy(request);
            }
        }
    }
}
