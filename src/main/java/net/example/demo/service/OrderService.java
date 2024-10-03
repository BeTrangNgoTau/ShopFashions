package net.example.demo.service;

import net.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.example.demo.entity.Order;
import net.example.demo.exception.OrderNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now()); // Set date when order is created
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrderById(id);
        order.setTotalAmount(orderDetails.getTotalAmount());
        order.setOrderItems(orderDetails.getOrderItems());
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}
