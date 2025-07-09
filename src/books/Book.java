package books;

import java.util.Random;

import validators.BookValidator;
import purchaseRequest.PurchaseRequest;

public abstract class Book {
    protected final String ISBN;
    protected String title;
    protected double price;
    protected int year;

    public Book(String title, double price, int year) {
        this.ISBN = generateISBN();
        if (BookValidator.isValidTitle(title)) {
            this.title = title;
        }
        if (BookValidator.isValidPrice(price)) {
            this.price = price;
        }
        if (BookValidator.isValidYear(year)) {
            this.year = year;
        }
    }

    private String generateISBN() {
        Random random = new Random();

        StringBuilder sb = new StringBuilder("978");

        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    public abstract double buy(PurchaseRequest request);

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }
}
