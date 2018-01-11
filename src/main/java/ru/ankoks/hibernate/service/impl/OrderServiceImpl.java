package ru.ankoks.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ankoks.hibernate.dao.OrderDAO;
import ru.ankoks.hibernate.service.OrderService;
import ru.ankoks.model.Order;
import ru.ankoks.model.OrderStatus;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Transactional
    public void deleteOrder(Integer orderId) {
        orderDAO.deleteOrder(orderId);
    }

    public Order getOrder(int orderId) {
        return orderDAO.getOrder(orderId);
    }

    public Order updateOrder(Order order) {
        return orderDAO.updateOrder(order);
    }

    public Integer getLastOrder() {
        return orderDAO.getLastOrder();
    }

    public List<Order> getOrdersByIds(List<Integer> orderIds) {
        return orderDAO.getOrdersByIds(orderIds);
    }

    public List<Order> getNonCompleteOrders() {
        return orderDAO.getNonCompleteOrders();
    }

    public void updateOrderStatus(int orderId, OrderStatus status) {
        orderDAO.updateOrderStatus(orderId, status);
    }
}
