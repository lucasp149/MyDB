package org.solved.persistence;

import org.solved.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository extends GeneralRepository<Order> {
    public List<Long> getProductsInOrder (Long id) throws SQLException; // retrieves a list of Products Ids that are part of an order
}
