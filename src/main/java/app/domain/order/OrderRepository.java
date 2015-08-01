package app.domain.order;

import java.util.UUID;

public interface OrderRepository {
    Order findById(UUID uuid);
    void persist(Order order);
}
