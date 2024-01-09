package com.solvd.storeDataBase.persistence;

import com.solvd.storeDataBase.domain.Order;
import com.solvd.storeDataBase.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository extends GeneralRepository<Order> {
    public List<Product> getProductsInOrder (Long id) throws SQLException; // retrieves a list of Products Ids that are part of an order    @Override
    public List<Integer> getQuantitiesInOrder (Long id) throws SQLException;
    public List<Long> getOrdersFromClient (Long clientId) throws SQLException;
    void updateById(@Param("id") Long id,@Param("order") Order order) throws SQLException;

    @Override
    Order getById(Long id) throws SQLException;

    @Override
    List<Order> getAll() throws SQLException;

    void deleteOrderProducts(Long orderId);
    void deleteOrderSpecificProduct(@Param("orderId") Long orderId,@Param("productId") Long productId);
    Integer getProductQuantity(@Param("orderId")Long orderId,@Param("productId") Long productId);
    void updateQuantitySpecificProduct(@Param("orderId")Long orderId,@Param("productId") Long productId,@Param("quantity") int newQuantity);
    void insertOrderProducts(@Param("id") Long orderId,@Param("product") Long productId ,@Param("quantity") Integer quantity);
}
