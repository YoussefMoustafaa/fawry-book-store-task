package books;

import purchaseRequest.PurchaseRequest;
import shippingService.ShippingService;
import validators.BookValidator;
import validators.PurchaseRequestValidator;
import validators.UserValidator;

public class PaperBook extends Book {

    private int stock;

    public PaperBook(String title, double price, int year, int stock) {
        super(title, price, year);
        if (BookValidator.checkStock(stock)) {
            this.stock = stock;
        }
    }

    @Override
    public double buy(PurchaseRequest request) {
        if (PurchaseRequestValidator.checkPurchaceRequest(request) && BookValidator.isBookAvailable(this) && BookValidator.checkQuantity(request.getQuantity())) {
            stock--;
            System.out.println("Buying paper book: " + title + " (ISBN: " + ISBN + ")" +
                    "\nPrice: " + price + "\nYear: " + year + "\nRemaining stock: " + stock);
        }
        if (UserValidator.isValidAddress(request.getAddress())) {
            ShippingService.shipBook(this, request.getQuantity(), request.getAddress());
        }
        return price * request.getQuantity();
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (BookValidator.checkStock(stock)) {
            this.stock = stock;
        }
    }

    public void restock(int quantity) {
        if (BookValidator.checkQuantity(quantity)) {
            this.stock += quantity;
        }
    }

    public void sell(int quantity) {
        if (BookValidator.checkQuantity(quantity) && BookValidator.checkQuantityWithStock(quantity, this.stock)) {
            this.stock -= quantity;
        }
    }

    public boolean isOutOfStock() {
        return stock <= 0;
    }
    
}
