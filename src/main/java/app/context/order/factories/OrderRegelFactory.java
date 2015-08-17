package app.context.order.factories;

import app.context.order.valueobjects.Bedrag;
import app.context.order.OrderRegel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderRegelFactory {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderRegelFactory.class);

    public OrderRegel createOrderRegel(String omschrijving, BigDecimal bedrag) {
        OrderRegel orderRegel = new OrderRegel(omschrijving, new Bedrag(bedrag));

        return orderRegel;
    }
}
