package book;
import java.time.LocalDate;
import java.time.Year;
import java.util.Random;

public class Book {
    private final String ISBN;
    private String title;
    private double price;
    private int quantity;
    private Year year;
    
    // Composition with behaviors
    private DemoBook demoBook;
    private PaperBook paperBook;
    private EBook eBook;

    public Book(String title, double price, Year year, int quantity) {
        this.ISBN = generateISBN();
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.year = year;
    }

    private String generateISBN() {
        Random random = new Random();

        StringBuilder sb = new StringBuilder("978");

        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    // public void setExpirableBehavior(IPaperBook iExpirableProduct) {
    //     this.expirableProduct = iExpirableProduct;
    // }

    // public IPaperBook getExpirableProduct() {
    //     return this.expirableProduct;
    // }

    // public void setShippableBehavior(IShippable iShippableProduct) {
    //     this.shippableProduct = iShippableProduct;
    // }

    // public IShippable getShippableProduct() {
    //     return this.shippableProduct;
    // }

    // public double getWeight() {
    //     return this.shippableProduct.getWeight();
    // }

    // public void setWeight(double weight) {
    //     this.shippableProduct.setWeight(weight);
    // }

    // public boolean checkExpiry() {
    //     return this.expirableProduct.isExpired();
    // }

    // public LocalDate getExpirationDate() {
    //     return this.expirableProduct.getExpirationDate();
    // }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
