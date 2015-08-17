package app.context.invoice;

import app.context.order.Order;
import app.context.order.OrderInvoiceService;
import app.infra.mail.OrderMailServiceAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderInvoiceAdapter implements OrderInvoiceService {

    private final Logger LOGGER = LoggerFactory.getLogger(OrderInvoiceAdapter.class);

    @Override
    public void invoiceOrder(Order order) {
        LOGGER.info("An invoice is created for order {}", order.getUuid());
    }
}
