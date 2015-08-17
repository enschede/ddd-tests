package app.context.order;

import app.context.EventSourcingEntity;
import app.context.order.factories.OrderRegelFactory;
import app.context.order.valueobjects.Klant;
import app.domainevents.InvoiceOrderDomainEvent;
import app.domainevents.offer.CreateOrderDomainEvent;
import app.domainevents.DomainEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Order extends EventSourcingEntity {

    private Klant klant;
    private List<OrderRegel> orderRegels;
    
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderRegelFactory orderRegelFactory;
    @Autowired
    private OrderInvoiceService orderInvoiceService;

    public Order() {
        orderRegels = new ArrayList<>();
    }

    public void processEvent(DomainEvent domainEvent) {

        if(domainEvent instanceof CreateOrderDomainEvent) {
            processCreateOrderDomainEvent((CreateOrderDomainEvent) domainEvent);
        }
        
        if(domainEvent instanceof InvoiceOrderDomainEvent) {
            proccessInvoiceOrderDomainEvent((InvoiceOrderDomainEvent)domainEvent);
        }
        
        addEvent(domainEvent);
        persist();
    }

    private void proccessInvoiceOrderDomainEvent(InvoiceOrderDomainEvent domainEvent) {
        orderInvoiceService.invoiceOrder(this);
    }

    private void processCreateOrderDomainEvent(CreateOrderDomainEvent createOrderDomainEvent) {
        this.klant = createOrderDomainEvent.getKlant();
        
        for(CreateOrderDomainEvent.Line line : createOrderDomainEvent.getLines()) {
            OrderRegel orderRegel = orderRegelFactory.createOrderRegel(line.description, line.price);
            orderRegels.add(orderRegel);
        }
    }

    public Klant getKlant() {
        return klant;
    }

    public List<OrderRegel> getOrderRegels() {
        return orderRegels;
    }

    public void persist() {
        orderRepository.persist(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "klant=" + klant +
                ", orderRegels=" + orderRegels +
                "} " + super.toString();
    }

}
