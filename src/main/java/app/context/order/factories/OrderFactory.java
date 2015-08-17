package app.context.order.factories;

import app.context.order.Order;
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
    
    public Order createEmptyOrder() {
        Order order = new Order();
        
        beanFactory.autowireBean(order);
        
        LOGGER.info("Created order:" + order.toString());
        
        return order;
    }
}
