package ru.ankoks.hibernate.service;

import ru.ankoks.model.Order;
import ru.ankoks.model.OrderStatus;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
public interface OrderService {
    public void addOrder(Order order);

    public List<Order> getAllOrders();

    public void deleteOrder(Integer orderId);

    public Order getOrder(int orderid);

    public Order updateOrder(Order order);

    public Integer getLastOrder();

    List<Order> getOrdersByIds(List<Integer> orderIds);

    List<Order> getNonCompleteOrders();

    void updateOrderStatus(int orderId, OrderStatus status);
}
