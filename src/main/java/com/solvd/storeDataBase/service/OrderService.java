package com.solvd.storeDataBase.service;

import com.solvd.storeDataBase.domain.Order;
import com.solvd.storeDataBase.domain.exceptions.CantDeleteInexistentProductException;

public interface OrderService extends GeneralService<Order>{
    void addProductToOrder(Long orderId, Long productId);
    void deleteProductFromOrder(Long orderId, Long productId) throws CantDeleteInexistentProductException;
}
