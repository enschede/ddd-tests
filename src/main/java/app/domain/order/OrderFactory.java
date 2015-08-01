package app.domain.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderFactory {
    
    private final Logger LOGGER = LoggerFactory.getLogger(OrderFactory.class); 
    
    @Autowired
    private AutowireCapableBeanFactory beanFactory;
    
    public Order createOrder(Klant klant) {
        Order order = new Order();
        order.setKlant(klant);
        
        beanFactory.autowireBean(order);
        
        LOGGER.info("Created order:" + order.toString());
        
        return order;
    }
}
