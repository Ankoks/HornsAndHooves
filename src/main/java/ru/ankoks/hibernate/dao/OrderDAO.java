package ru.ankoks.hibernate.dao;

import ru.ankoks.model.Order;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
public interface OrderDAO {

    public void addOrder(Order order);

    public List getAllOrders();

    public void deleteOrder(Integer orderId);

    public Order updateOrder(Order order);

    public Order getOrder(int orderId);

    public Integer getLastOrder();

    List<Order> getOrdersByIds(List<Integer> orderIds);

    List<Order> getNonCompleteOrders();
}
