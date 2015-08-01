package app.domain.order;

/**
 * Created by marc on 01/08/15.
 */
public interface OrderMailService {
    
    void sendOrderConfirmation(Order order);
    
}
