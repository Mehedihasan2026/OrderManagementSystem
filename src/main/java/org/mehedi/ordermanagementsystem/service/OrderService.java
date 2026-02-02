package org.mehedi.ordermanagementsystem.service;

import org.mehedi.ordermanagementsystem.dto.OrderDto;
import org.mehedi.ordermanagementsystem.model.Order;
import org.mehedi.ordermanagementsystem.model.OrderType;
import org.mehedi.ordermanagementsystem.model.PaymentMethod;
import org.mehedi.ordermanagementsystem.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order getOrder(Long orderId) {
        return orderRepository.getOrderByOrderId(orderId);
    }

    public Order createOrder(OrderDto orderDto) {
        Order newOrder = Order.builder()
                .orderTime(LocalDateTime.now())
                .type(orderDto.getType())
                .paymentMethod(orderDto.getPaymentMethod())
                .instruction(orderDto.getInstruction())
                .tableNumber(orderDto.getTableNumber())
                .billAmount(orderDto.getBillAmount())
                .build();
        return  orderRepository.save(newOrder);

    }

    public Order updateOrder(OrderDto orderDto,Long uid) {
        Order oldOrder = orderRepository.getOrderByOrderId(uid);
        if(oldOrder!=null){
            //oldOrder.setOrderTime(LocalDateTime.now());
            List<LocalDateTime> updatedTime = oldOrder.getUpdatedTime();
            if(updatedTime == null){
                updatedTime = new ArrayList<>();
            }
            updatedTime.add(LocalDateTime.now());
            oldOrder.setUpdatedTime(updatedTime);
            if(orderDto.getPaymentMethod()!=null){
                oldOrder.setPaymentMethod(orderDto.getPaymentMethod());
            }
            if(orderDto.getInstruction()!=null){
                oldOrder.setInstruction(orderDto.getInstruction());
            }
            if(orderDto.getType()!=null){
                oldOrder.setType(orderDto.getType());
            }
            if(orderDto.getTableNumber() != null){
                oldOrder.setTableNumber(orderDto.getTableNumber());
            }
            if(orderDto.getBillAmount()!=null){
                oldOrder.setBillAmount(orderDto.getBillAmount());
            }
        }
        return orderRepository.save(oldOrder);
    }

    public void deleteOrder(Long orderId) {
         orderRepository.deleteOrderByOrderId(orderId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public List<Order> getAllOrdersByType(OrderType type) {
        return orderRepository.findOrderByType(type);
    }
}
