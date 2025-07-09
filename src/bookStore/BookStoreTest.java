package bookStore;
import books.PaperBook;
import books.EBook;
import books.DemoBook;

public class BookStoreTest {
    public static void main(String[] args) {
        System.out.println("=== BookStore Functionality Test ===\n");

        BookStore store = new BookStore();


        System.out.println("Adding books...");
        store.addBook("The Alchemist", 80.0, 2005, 3); // PaperBook
        store.addBook("Atomic Habits", 60.0, 2018, "EPUB"); // EBook
        store.addBook("Clean Code", 40.0, 2022); // DemoBook
        System.out.println("Books added!\n");


        System.out.println("Current Available Books:");
        store.getBooks().forEach(book ->
            System.out.println(book.getTitle() + " (ISBN: " + book.getISBN() + ")")
        );
        System.out.println();


        System.out.println("Buying a paper book...");
        try {
            PaperBook paperBook = (PaperBook) store.findBookByISBN(store.getBooks().get(0).getISBN());
            store.buy(paperBook.getISBN(), 1, "youssef@gmail.com", "Nasr City");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        System.out.println("Buying an ebook...");
        try {
            EBook ebook = (EBook) store.findBookByISBN(store.getBooks().get(1).getISBN());
            store.buy(ebook.getISBN(), 1, "adam@hotmail.com", null);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        System.out.println("Trying to buy a demo book...");  // this should give an error
        try {
            DemoBook demoBook = (DemoBook) store.findBookByISBN(store.getBooks().get(2).getISBN());
            store.buy(demoBook.getISBN(), 1, "mohamed@gmail.com", "Smart Village");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        System.out.println();

        
        System.out.println("Removing a book...");
        try {
            EBook ebook = (EBook) store.findBookByISBN(store.getBooks().get(1).getISBN());
            store.removeBook(ebook);
            System.out.println("Removed '" + ebook.getTitle() + "' Book.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();


        System.out.println("BookStore after removal:");
        store.getBooks().forEach(book ->
            System.out.println(book.getTitle() + " (ISBN: " + book.getISBN() + ")")
        );
        System.out.println();

        System.out.println("=== Test Complete ===");
    }
}
