package app.infra.mail;

import app.context.order.Order;
import app.context.order.OrderMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMailServiceAdapter implements OrderMailService {
    
    private final Logger LOGGER = LoggerFactory.getLogger(OrderMailServiceAdapter.class);
    
    @Autowired
    private MailService mailService;
    
    @Override
    public void sendOrderConfirmation(Order order) {
        mailService.sendMail(order.toString());
    }
}
