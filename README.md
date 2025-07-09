# Bookstore System

This BookStore System is a simple Java application that simulates a digital bookstore, supporting multiple book types, purchase operations, stock management, and validation. The system is designed with modularity and maintainability in mind, following SOLID principles and clear separation of concerns.

## Features & Functionalities

### 1. Book Types
- **PaperBook**: Physical books with stock management and shipping.
- **EBook**: Digital books with file type validation and email delivery.
- **DemoBook**: Showcase books that cannot be purchased.

### 2. Book Management
- **Add Books**: Add PaperBook, EBook, or DemoBook to the store using overloaded methods.
- **Remove Books**: Remove books by ISBN or by reference.
- **List Books**: View all books currently in the store.
- **Remove Outdated Books**: Remove books older than a specified number of years.

### 3. Purchase Operations
- **Buy PaperBook**: Checks stock, validates address, decrements stock, and triggers shipping.
- **Buy EBook**: Validates email, sends the book via email.
- **Buy DemoBook**: Throws an exception (cannot be purchased).
- **Validation**: All purchase requests are validated for correctness (ISBN, email, address, quantity, etc.).

### 4. Stock Management
- **Restock**: Increase the stock of PaperBooks.
- **Sell**: Decrease stock when a PaperBook is sold.
- **Check Stock**: Prevents selling more than available.

### 5. Validation
- **BookValidator**: Validates ISBN, title, price, year, file type, stock, and quantity.
- **UserValidator**: Validates email and address.
- **PurchaseRequestValidator**: Validates purchase requests.

### 6. Services
- **MailService**: Handles sending eBooks via email.
- **ShippingService**: Handles shipping of PaperBooks to addresses.

### 7. Testing
- **BookStoreTest**: A dedicated class to test adding, removing, and buying books, including error cases and edge scenarios.

## Design Approach

### Object-Oriented Principles
- **Encapsulation**: Each class encapsulates its own data and behavior (e.g., Book, PaperBook, EBook).
- **Inheritance & Polymorphism**: Book is an abstract class; PaperBook, EBook, and DemoBook extend Book and implement their own `buy` logic.
- **Single Responsibility Principle**: Validators and services are separated by concern (e.g., BookValidator, UserValidator, MailService).
- **Open/Closed Principle**: New book types or validation rules can be added with minimal changes to existing code.

### Modularity
- **Packages**: Code is organized into packages by domain: `books`, `bookStore`, `validators`, `mailService`, `shippingService`, `purchaseRequest`.
- **Validation**: All input and business logic is validated before actions are performed, ensuring robustness.

### Error Handling
- Uses exceptions to handle invalid operations (e.g., buying a demo book, invalid email, out-of-stock situations).

## Folder Structure

- `src/` - Source code
  - `books/` - Book classes (Book, PaperBook, EBook, DemoBook)
  - `bookStore/` - BookStore logic and test class
  - `validators/` - Validation classes
  - `mailService/` - Email delivery logic
  - `shippingService/` - Shipping logic
  - `purchaseRequest/` - Purchase request model
- `lib/` - External dependencies (if any)
- `bin/` - Compiled output

## How to Run

1. **Compile the project:**
   - Open a terminal in the project root.
   - Run: `javac -d bin src/**/*.java`

2. **Run the main application:**
   - Run: `java -cp bin App`

3. **Run the test class:**
   - Run: `java -cp bin BookStoreTest`

## Example Usage

```
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
```

Example Output:

```
=== BookStore Functionality Test ===

Adding books...
Books added!

Current Available Books:
The Alchemist (ISBN: 9787438112761)
Atomic Habits (ISBN: 9783332570212)
Clean Code (ISBN: 9786549619828)

Buying a paper book...
Buying paper book: The Alchemist (ISBN: 9787438112761)
Price: 80.0
Year: 2005
Remaining stock: 2
Shipping 1 copies of paper book: The Alchemist
To address: Nasr City
Remaining stock after shipping: 1

Buying an ebook...
Buying e-book: Atomic Habits (ISBN: 9783332570212)
File type: EPUB
Price: $60.0
Sending Book: Atomic Habits
via email to: adam@hotmail.com

Trying to buy a demo book...
Expected error: This is a demo book and cannot be purchased.
Removing a book...
Removed 'Atomic Habits' Book.

BookStore after removal:
The Alchemist (ISBN: 9787438112761)
Clean Code (ISBN: 9786549619828)

=== Test Complete ===
```

## Extending the System

- To add new book types, extend the `Book` class and implement the `buy` method.
- To add new validation rules, update or add new validator classes in the `validators` package.
- To add new services (e.g., notifications), create a new service class and integrate where needed.

## Authors

- Designed and implemented by Youssef Moustafa.

---
This project is a demonstration of clean Java OOP design, validation, and modularity for a simple bookstore system.
