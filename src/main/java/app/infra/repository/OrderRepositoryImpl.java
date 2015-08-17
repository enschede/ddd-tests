package app.infra.repository;

import app.context.order.Order;
import app.context.order.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    
    private final Logger LOGGER = LoggerFactory.getLogger(OrderRepositoryImpl.class);
    
    private Map<UUID, Order> orders = new IdentityHashMap<>(100);

    @Override
    public Order findById(UUID uuid) {
        if(orders.containsKey(uuid)) {
            return orders.get(uuid);
        }
        
        return null;
    }

    @Override
    public void persist(Order order) {
        if(order.getUuid()==null)
            order.setUuid(UUID.randomUUID());

        orders.put(order.getUuid(), order);

        LOGGER.info("Persisted order:" + order.toString());
        LOGGER.info("{} orders in repository", orders.size());
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }


}
