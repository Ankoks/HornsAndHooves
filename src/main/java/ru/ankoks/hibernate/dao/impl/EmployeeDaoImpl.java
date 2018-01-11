package ru.ankoks.hibernate.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.ankoks.hibernate.dao.EmployeeDAO;
import ru.ankoks.model.Employee;
import ru.ankoks.model.FurnitureDepartment;
import ru.ankoks.model.dto.EmployeeOrderDto;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {

        return sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }

    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }

    }

    public Employee getEmployee(int empid) {
        return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, empid);
    }

    public Integer getRandomFreeEmployeeId() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);

        criteria.setProjection(Projections.id());

        criteria.add(Restrictions.eq("free", Boolean.TRUE));

        List list = criteria.list();

        return list.isEmpty() ? null : (Integer) list.get(0);
    }

    public void updateEmployeeWorkerStatus(Integer employeeId) {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("UPDATE employee SET is_free = false where id = :id");

        sqlQuery.setParameter("id", employeeId);

        sqlQuery.executeUpdate();
    }

    public List<Integer> getEmployeeIdsByDepartment(FurnitureDepartment furnitureDepartment) {

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);

        criteria.setProjection(Projections.id());
        criteria.add(Restrictions.eq("department", furnitureDepartment));

        return criteria.list();
    }

    public List<EmployeeOrderDto> getEmployeeOrders() {
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(
                "SELECT" +
                "  e.name        AS employeeName," +
                "  e.department  AS employeeDepartment," +
                "  of.name       AS orderName," +
                "  of.order_date AS orderDate," +
                "  of.status     AS orderStatus " +
                "FROM employee e" +
                "  JOIN employee_orders eo ON e.id = eo.employee_id" +
                "  JOIN order_furniture of ON eo.order_id = of.id");

        sqlQuery.addScalar("employeeName");
        sqlQuery.addScalar("employeeDepartment");
        sqlQuery.addScalar("orderName");
        sqlQuery.addScalar("orderDate");
        sqlQuery.addScalar("orderStatus");

        sqlQuery.setResultTransformer(Transformers.aliasToBean(EmployeeOrderDto.class));

        return sqlQuery.list();
    }

    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }
}
