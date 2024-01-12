package com.solvd.storeDataBase.persistence.implementation.myBatis;

import com.solvd.storeDataBase.ConnectToDbMyBatis;
import com.solvd.storeDataBase.domain.Order;
import com.solvd.storeDataBase.domain.Product;
import com.solvd.storeDataBase.persistence.GeneralRepository;
import com.solvd.storeDataBase.persistence.OrderRepository;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class OrderRepositoryImplMB extends GeneralRepositoryImplMB<Order> implements OrderRepository {
    @Override
    public List<Long> getOrdersFromClient(Long clientId) throws SQLException {
        return null;
    }

    @Override
    public void deleteOrderProducts(Long orderId) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            repository.deleteOrderProducts(orderId);
        }
    }

    @Override
    public void deleteOrderSpecificProduct(Long orderId, Long productId) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            repository.deleteOrderProducts(orderId);
        }
    }

    @Override
    public Integer getProductQuantity(Long orderId, Long productId) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            if (repository.getProductQuantity(orderId, productId) == null) {
                return 0;
            } else {
                return repository.getProductQuantity(orderId, productId);
            }
        }
    }

    @Override
    public void updateQuantitySpecificProduct(Long orderId, Long productId, int newQuantity) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            repository.updateQuantitySpecificProduct(orderId, productId, newQuantity);
        }
    }

    @Override
    public void insertOrderProducts(Long orderId, Long productId, Integer quantity) {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            repository.insertOrderProducts(orderId, productId, quantity);
        }
    }

    @Override
    public List<Product> getProductsInOrder(Long id) throws SQLException {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            return repository.getProductsInOrder(id);
        }
    }

    @Override
    public List<Integer> getQuantitiesInOrder(Long id) throws SQLException {
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            return repository.getQuantitiesInOrder(id);
        }
    }

    @Override
    public void updateById(Long id, Order order) throws SQLException {
        super.updateById(id, order);
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            repository.deleteOrderProducts(order.getId());
            for (int i = 0; i < order.getProducts().size(); i++) {
                repository.insertOrderProducts(order.getId(), order.getProducts().get(i).getId(), order.getQuantities().get(i));
            }
        }

    }

    @Override
    public Long create(Order order) throws SQLException {

        Long orderId = super.create(order);
        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            for (int i = 0; i < order.getProducts().size(); i++) {
                repository.insertOrderProducts(order.getId(), order.getProducts().get(i).getId(), order.getQuantities().get(i));
            }
        }


        return orderId;
    }

    @Override
    public void deleteById(Long id) {

        try (SqlSession sqlSession = ConnectToDbMyBatis.getSessionFactory().openSession(true)) {
            OrderRepository repository = sqlSession.getMapper(OrderRepository.class);
            repository.deleteOrderProducts(id);
        }
        super.deleteById(id);

    }

    @Override
    public GeneralRepository<Order> getRepository(SqlSession session) {
        return session.getMapper(OrderRepository.class);
    }
}
