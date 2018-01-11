package ru.ankoks.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ankoks.hibernate.dao.EmployeeOrderDAO;
import ru.ankoks.model.EmployeeOrder;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Repository
public class EmployeeOrderDaoImpl implements EmployeeOrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployeeOrder(EmployeeOrder employeeOrder) {
        sessionFactory.getCurrentSession().saveOrUpdate(employeeOrder);
    }

    public void deleteOrderOperationByOrderId(int orderId) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM employee_orders WHERE order_id = :order_id");
        sqlQuery.setParameter("order_id", orderId);

        sqlQuery.executeUpdate();
    }

    public void updateOperationEmployeeId(int employeeId, Integer newEmployeeId) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("UPDATE employee_orders SET employee_id = :new_employee_id WHERE employee_id = :old_employee_id");
        sqlQuery.setParameter("old_employee_id", employeeId);
        sqlQuery.setParameter("new_employee_id", newEmployeeId);

        sqlQuery.executeUpdate();
    }

    public List<Integer> getOrderIdsByEmployeeIds(List<Integer> employeeIds) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeOrder.class);

        criteria.setProjection(Projections.property("orderId"));
        criteria.add(Restrictions.in("employeeId", employeeIds));

        return criteria.list();
    }

    public void deleteOperationByEmployeeId(int employeeId) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM employee_orders WHERE employee_id = :employee_id");
        sqlQuery.setParameter("employee_id", employeeId);

        sqlQuery.executeUpdate();
    }
}
