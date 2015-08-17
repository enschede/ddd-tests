package app.context.order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    Order findById(UUID uuid);
    void persist(Order order);
    List<Order> findAll();
}
