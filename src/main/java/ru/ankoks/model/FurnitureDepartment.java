package ru.ankoks.model;

import java.util.EnumSet;

/**
 * Created by ankoks on 09.01.2018.
 */
public enum FurnitureDepartment {

    SOFT("Мягкая мебель"),
    STORAGE("Системы хранения"),
    OFFICE("Офисная мебель");

    private String title;
    private FurnitureDepartment name;

    FurnitureDepartment(String title) {
        this.title = title;
        this.name = this;
    }

    public String getTitle() {
        return title;
    }

    public FurnitureDepartment getName() {
        return name;
    }

    public static final EnumSet<FurnitureDepartment> ALL = EnumSet.of(SOFT, STORAGE, OFFICE);
}
