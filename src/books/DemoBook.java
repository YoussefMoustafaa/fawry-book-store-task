package books;

import purchaseRequest.PurchaseRequest;

public class DemoBook extends Book {

    public DemoBook(String title, double price, int year) {
        super(title, price, year);
    }

    @Override
    public double buy(PurchaseRequest request) {
        throw new UnsupportedOperationException("This is a demo book and cannot be purchased.");
    }
    
}
