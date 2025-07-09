package purchaseRequest;


public class PurchaseRequest {
    private final String isbn;
    private final Integer quantity;     // Integer for nullability
    private final String email;
    private final String address;

    public PurchaseRequest(String isbn, Integer quantity, String email, String address) {
        this.isbn = isbn;
        this.quantity = quantity;
        this.email = email;
        this.address = address;
    }

    public String getISBN() { return this.isbn; }
    public Integer getQuantity() { return this.quantity; }
    public String getEmail() { return this.email; }
    public String getAddress() { return this.address; }
}
