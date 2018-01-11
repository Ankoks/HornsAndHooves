package ru.ankoks.model;

import javax.persistence.*;

/**
 * Created by ankoks on 09.01.2018.
 */
@Entity
@Table(name = "employee_orders")
public class EmployeeOrder {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "order_id")
    private Integer orderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
