package app.domain.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Order extends Entity {

    private Klant klant;
    private List<OrderRegel> orderRegels;
    
    @Autowired
    private OrderRepository orderRepository;

    public Order() {
        orderRegels = new ArrayList<>();
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public void voegRegelToe(OrderRegel orderRegel) {
        orderRegels.add(orderRegel);
    }

    public void persist() {
        orderRepository.persist(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "klant=" + klant +
                ", orderRegels=" + orderRegels +
                ", orderRepository=" + orderRepository +
                "} " + super.toString();
    }
}
