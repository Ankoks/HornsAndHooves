package ru.ankoks.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by ankoks on 09.01.2018.
 */
@Entity
@Table(name = "order_furniture")
public class Order {

    private static final long serialVersionUID = -2L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "ITEM")
    private FurnitureItem item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public FurnitureItem getItem() {
        return item;
    }

    public void setItem(FurnitureItem item) {
        this.item = item;
    }


    @Transient
    public String getCompleteDays() {
        LocalDate localDate = orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        long l = Duration.between(localDate.atStartOfDay(), currentDate.atStartOfDay()).toDays();

        return String.valueOf(l);
    }
}
