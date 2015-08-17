package app.infra.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by marc on 01/08/15.
 */
@Service
public class MailService {
    private final Logger LOGGER = LoggerFactory.getLogger(OrderMailServiceAdapter.class);

    public void sendMail(String text) {
        LOGGER.info("Sending mail confirmation for: {}", text);
        
    }
}
