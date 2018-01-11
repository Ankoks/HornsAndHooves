package ru.ankoks.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ankoks.hibernate.dao.OrderDAO;
import ru.ankoks.model.Order;
import ru.ankoks.model.OrderStatus;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Repository
public class OrderDaoImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    public List<Order> getAllOrders() {

        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }

    public void deleteOrder(Integer employeeId) {
        Order order = (Order) sessionFactory.getCurrentSession().load(
                Order.class, employeeId);
        if (null != order) {
            this.sessionFactory.getCurrentSession().delete(order);
        }

    }

    public Order getOrder(int orderId) {
        return (Order) sessionFactory.getCurrentSession().get(
                Order.class, orderId);
    }

    public Order updateOrder(Order order) {
        sessionFactory.getCurrentSession().update(order);
        return order;
    }

    public Integer getLastOrder() {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("SELECT id FROM order_furniture ORDER BY id desc LIMIT 1");

        return (Integer) sqlQuery.uniqueResult();
    }

    public List<Order> getOrdersByIds(List<Integer> orderIds) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);

        criteria.add(Restrictions.in("id", orderIds));
        return criteria.list();
    }

    public List<Order> getNonCompleteOrders() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Order.class);

        criteria.add(Restrictions.ne("status", OrderStatus.COMPLETE));

        return criteria.list();
    }

    public void updateOrderStatus(int orderId, OrderStatus status) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("UPDATE order_furniture SET status = :status where id = :id");

        sqlQuery.setParameter("status", status.getStatusName());
        sqlQuery.setParameter("id", orderId);

        sqlQuery.executeUpdate();
    }
}
