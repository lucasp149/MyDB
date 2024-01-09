package com.solvd.storeDataBase.persistence.implementation;

import com.solvd.storeDataBase.domain.Order;
import com.solvd.storeDataBase.domain.Product;
import com.solvd.storeDataBase.persistence.OrderRepository;

import java.sql.*;
import java.util.List;

import static com.solvd.storeDataBase.ConnectToDb.connectToDb;

public class OrderRepositoryImplementation extends GeneralRepositoryImplementation<Order> implements OrderRepository {

    public final static String TABLE_NAME = "orders";


    @Override
    public Long create(Order order) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO orders(date,payment_id,client_id,store_id) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(order.getDate().getTime()));
            ps.setLong(2, order.getPayment().getId());
            ps.setLong(3, order.getClient().getId());
            ps.setLong(4, order.getStore().getId());

            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            System.out.println(keys);
            keys.next();
            return keys.getLong(1);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProductsInOrder(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Integer> getQuantitiesInOrder(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Long> getOrdersFromClient(Long clientId) throws SQLException {
        return null;
    }

    @Override
    public void updateById(Long id, Order order) throws SQLException {
        try (Connection conn = connectToDb()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE stores set date = ? payment_id = ? client_id = ? store_id = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new java.sql.Date(order.getDate().getTime()));
            ps.setLong(2, order.getPayment().getId());
            ps.setLong(3, order.getClient().getId());
            ps.setLong(4, order.getStore().getId());
            ps.setLong(5,id);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteOrderProducts(Long orderId) { }

    @Override
    public void deleteOrderSpecificProduct(Long orderId, Long productId) {

    }

    @Override
    public Integer getProductQuantity(Long orderId, Long productId) {
        return null;
    }

    @Override
    public void updateQuantitySpecificProduct(Long orderId, Long productId, int newQuantity) {

    }

    @Override
    public void insertOrderProducts(Long orderId, Long productId, Integer quantity) {

    }


    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Order mapOneObject(ResultSet resultSet) {
        try {
            return new Order(resultSet.getLong("id"), resultSet.getDate("date"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
