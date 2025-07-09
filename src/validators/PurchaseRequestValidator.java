package validators;

import purchaseRequest.PurchaseRequest;

public class PurchaseRequestValidator {
    
    public static boolean checkPurchaceRequest(PurchaseRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Invalid purchase request!");
        }
        return true;
    }
}
