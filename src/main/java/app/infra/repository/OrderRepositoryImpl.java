package app.infra.repository;

import app.domain.order.Order;
import app.domain.order.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by marc on 31/07/15.
 */
@Component
public class OrderRepositoryImpl implements OrderRepository {
    
    private final Logger LOGGER = LoggerFactory.getLogger(OrderRepositoryImpl.class);
    
    private List<Order> orders = new ArrayList<>();

    @Override
    public Order findById(UUID uuid) {
        return orders.stream().filter(x -> x.getUuid().equals(uuid)).reduce(null, (order, order2) -> order2);
    }

    @Override
    public void persist(Order order) {
        orders.add(order);        
        LOGGER.info("Persisted order:" + order.toString());
        LOGGER.info("{} orders in repository", orders.size());
    }
    
    
}
