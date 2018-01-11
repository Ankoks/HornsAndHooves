package ru.ankoks.model.dto;

import javax.persistence.Transient;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by AntonK on 11.01.2018.
 */
public class EmployeeOrderDto {
    private String employeeName;
    private String employeeDepartment;
    private String orderName;
    private Date orderDate;
//    private OrderStatus orderStatus;
    private String orderStatus;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Transient
    public String getCompleteDays() {
        LocalDate localDate = orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        long l = Duration.between(localDate.atStartOfDay(), currentDate.atStartOfDay()).toDays();

        return String.valueOf(l);
    }
}
