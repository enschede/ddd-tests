package app.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by marc on 31/07/15.
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderFactory orderFactory;
    
    @Autowired
    private OrderRegelFactory orderRegelFactory;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderMailService orderMailService;
    
    public Order maakOrder(Klant klant) {
        Order order = orderFactory.createOrder(klant);
        
        order.persist();
        orderMailService.sendOrderConfirmation(order);
        
        return order;
    }
    
    public Order voegOrderRegelToe(Order order, String omschrijving, BigDecimal bedrag) {

        OrderRegel orderRegel = orderRegelFactory.createOrderRegel(omschrijving, bedrag);
        
        order.voegRegelToe(orderRegel);
        
        order.persist();
        
        return order;
    }

    public Order toonOrder(UUID uuid) {
        return orderRepository.findById(uuid);
    }
}
