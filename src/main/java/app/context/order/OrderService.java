package app.context.order;

import app.context.order.factories.OrderFactory;
import app.context.order.factories.OrderRegelFactory;
import app.domainevents.InvoiceOrderDomainEvent;
import app.domainevents.offer.Offer;
import app.domainevents.offer.CreateOrderDomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    
    public Order createOrderFromOffer(Offer offer) {
        Order newOrder = orderFactory.createEmptyOrder();
        
        CreateOrderDomainEvent createOrderDomainEvent = new CreateOrderDomainEvent(offer);
        newOrder.processEvent(createOrderDomainEvent);
        
        InvoiceOrderDomainEvent invoiceOrderDomainEvent = new InvoiceOrderDomainEvent();
        newOrder.processEvent(invoiceOrderDomainEvent);
        
        
        return newOrder;
    }
}
