package app.infra.mail;

import app.domain.order.Order;
import app.domain.order.OrderMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderMailServiceImpl implements OrderMailService {
    
    private final Logger LOGGER = LoggerFactory.getLogger(OrderMailServiceImpl.class);
    
    @Override
    public void sendOrderConfirmation(Order order) {
        LOGGER.info("Sending mail confirmation for: {}", order.toString());
    }
}
