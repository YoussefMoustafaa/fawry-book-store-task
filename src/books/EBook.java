package books;

import mailService.MailService;
import purchaseRequest.PurchaseRequest;
import validators.BookValidator;
import validators.PurchaseRequestValidator;
import validators.UserValidator;

public class EBook extends Book {

    private String fileType;

    public EBook(String title, double price, int year, String fileType) {
        super(title, price, year);
        if (BookValidator.isValidFileType(fileType)) {
            this.fileType = fileType;
        }
    }

    @Override
    public double buy(PurchaseRequest request) {
        if (PurchaseRequestValidator.checkPurchaceRequest(request) && BookValidator.isValidFileType(fileType) && UserValidator.isValidEmail(request.getEmail())) {
            System.out.println("Buying e-book: " + title + " (ISBN: " + ISBN + ")");
            System.out.println("File type: " + fileType);
            System.out.println("Price: $" + price);
            MailService.sendEmail(this, request.getEmail());
        }
        return price;
    }

    public String getFileType() {
        return fileType;
    }
    
}
