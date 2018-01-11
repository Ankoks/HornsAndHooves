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

    public String getStatusName() {
        switch (this) {
            case NEW:
                return "NEW";
            case STARTED:
                return "STARTED";
            case COMPLETE:
                return "COMPLETE";
            default:
                return "NEW";
        }
    }
}
