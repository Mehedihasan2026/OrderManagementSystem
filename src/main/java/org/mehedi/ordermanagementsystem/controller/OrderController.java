package org.mehedi.ordermanagementsystem.controller;
import org.mehedi.ordermanagementsystem.dto.OrderDto;
import org.mehedi.ordermanagementsystem.model.GenericResponse;
import org.mehedi.ordermanagementsystem.model.Order;
import org.mehedi.ordermanagementsystem.model.OrderType;
import org.mehedi.ordermanagementsystem.service.OrderService;
import org.mehedi.ordermanagementsystem.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public GenericResponse createOrder(@RequestBody OrderDto orderDto) {
        return ResponseUtil.setSuccessResponse(201,orderService.createOrder(orderDto));
    }

    @PutMapping("/{uid}")
    public GenericResponse updateOrder(@RequestBody OrderDto orderDto, @PathVariable Long uid) {
        return ResponseUtil.setSuccessResponse(200,orderService.updateOrder(orderDto, uid));
    }

    @DeleteMapping("/{uid}")
    public void deleteOrder(@PathVariable Long uid) {
        orderService.deleteOrder(uid);
    }

    @GetMapping("/{uid}")
    public GenericResponse get(@PathVariable Long uid) {
        return ResponseUtil.setSuccessResponse(200,orderService.getOrder(uid));
    }

    @GetMapping("/all")
    public GenericResponse getAll() {
        return ResponseUtil.setSuccessResponse(200,orderService.getAllOrders());
    }
    @GetMapping("/all/{type}")
    public GenericResponse getByType(@PathVariable OrderType type) {
        return ResponseUtil.setSuccessResponse(200,orderService.getAllOrdersByType(type));
    }

}
