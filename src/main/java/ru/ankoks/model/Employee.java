package ru.ankoks.model;

import javax.persistence.*;

/**
 * Created by AntonK on 09.01.2018.
 */
@Entity
@Table(name = "employee")
public class Employee {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private FurnitureDepartment department;

    @Column(name = "is_free")
    private Boolean free;

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

    public FurnitureDepartment getDepartment() {
        return department;
    }

    public void setDepartment(FurnitureDepartment department) {
        this.department = department;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
