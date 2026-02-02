package org.mehedi.ordermanagementsystem.repository;

import org.mehedi.ordermanagementsystem.model.Order;
import org.mehedi.ordermanagementsystem.model.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public interface OrderRepository extends JpaRepository<Order, Long> {


    Order getOrderByOrderId(Long orderId);

    void deleteOrderByOrderId(Long orderId);

    List<Order> findOrderByType(OrderType type);

}
