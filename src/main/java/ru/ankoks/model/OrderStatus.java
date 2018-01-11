package ru.ankoks.model;

/**
 * Created by ankoks on 09.01.2018.
 */
public enum OrderStatus {

    NEW("Новый"),
    STARTED("В работе"),
    COMPLETE("Завершен");

    private String title;

    OrderStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
