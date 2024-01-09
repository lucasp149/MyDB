package com.solvd.storeDataBase.service.impl;

import com.solvd.storeDataBase.domain.Order;
import com.solvd.storeDataBase.exceptions.CantDeleteInexistentProductException;
import com.solvd.storeDataBase.persistence.OrderRepository;
import com.solvd.storeDataBase.persistence.implementation.myBatis.GeneralRepositoryImplMB;
import com.solvd.storeDataBase.persistence.implementation.myBatis.OrderRepositoryImplMB;
import com.solvd.storeDataBase.service.GeneralServiceImpl;
import com.solvd.storeDataBase.service.OrderService;

import java.math.BigDecimal;
import java.util.HashMap;

public class OrderServiceImpl extends GeneralServiceImpl<Order> implements OrderService {
    @Override
    public GeneralRepositoryImplMB<Order> getRepository() {
        return new OrderRepositoryImplMB();
    }

    // Those methods are very important when adding or deleting products from orders. With those methods
    // we can avoid deleting and creating new Orders when changing products
    public void addProductToOrder(Long orderId, Long productId) {
        OrderRepository orderRep = new OrderRepositoryImplMB();
        int currentQ = orderRep.getProductQuantity(orderId, productId);
        if (currentQ == 0) {
            orderRep.insertOrderProducts(orderId,productId,1);
        } else {
            orderRep.updateQuantitySpecificProduct(orderId,productId,currentQ+1);
        }

    }
    @Override
    public void deleteProductFromOrder(Long orderId, Long productId) throws CantDeleteInexistentProductException {
        OrderRepository orderRep = new OrderRepositoryImplMB();
        int currentQ = orderRep.getProductQuantity(orderId, productId);
        if(currentQ == 0){
            throw new CantDeleteInexistentProductException("This product doesn't exist on this order");
        }
        else if (currentQ == 1){
            orderRep.deleteOrderSpecificProduct(orderId,productId);
        }
        else{
            orderRep.updateQuantitySpecificProduct(orderId,productId,currentQ-1);
        }
    }

    public BigDecimal createAndReturnTotal(Order order) {
        super.create(order);
        return order.getTotal();
    }

    public HashMap<Order, BigDecimal> getOrderWithTotal(Long id) {
        Order order = super.get(id);
        HashMap<Order, BigDecimal> ticket = new HashMap<>();
        ticket.put(order, order.getTotal());
        return ticket;
    }
}
