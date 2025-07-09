import bookStore.BookStore;
import books.PaperBook;
import books.EBook;
import books.DemoBook;

public class App {
    public static void main(String[] args) {

        BookStore store = new BookStore();

        System.out.println("Adding some books...");
        store.addBook("The Art of Computer Programming", 100.0, 2010, 5); // PaperBook
        store.addBook("Clean Code", 50.0, 2015, "PDF"); // EBook
        store.addBook("Showcase Book", 0.0, 2020); // DemoBook

        
        System.out.println("\nCurrent inventory:");
        store.getBooks().forEach(book -> 
            System.out.println(book.getTitle() + " (ISBN: " + book.getISBN() + ")")
        );

        
        System.out.println("\nBuying a paper book...");
        try {
            PaperBook paperBook = (PaperBook) store.findBookByISBN(store.getBooks().get(0).getISBN());
            store.buy(paperBook.getISBN(), 1, "youssef@gmail.com", "123 Main St");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        System.out.println("\nBuying an ebook...");
        try {
            EBook ebook = (EBook) store.findBookByISBN(store.getBooks().get(1).getISBN());
            store.buy(ebook.getISBN(), 1, "ali@hotmail.com", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Try to buy a demo book (should throw)
        System.out.println("\nTrying to buy a demo book...");
        try {
            DemoBook demoBook = (DemoBook) store.findBookByISBN(store.getBooks().get(2).getISBN());
            store.buy(demoBook.getISBN(), 1, "mohamed@gmail.com", "Smart Village");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        System.out.println("\nRemoving outdated books older than 10 years...");
        store.removeOutdatedBooks(10);


        System.out.println("\nInventory after removing outdated books:");
        store.getBooks().forEach(book -> 
            System.out.println(book.getTitle() + " (ISBN: " + book.getISBN() + ")")
        );
    }
}