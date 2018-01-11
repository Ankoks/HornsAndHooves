package ru.ankoks.model;

import java.util.EnumSet;

/**
 * Created by AntonK on 10.01.2018.
 */
public enum FurnitureItem {

    /* Мягкая мебель */
    BED("Кровать"),
    SOFA("Диван"),
    ARMCHAIR("Кресло"),
    /* Системы хранения */
    WARDROBE("Шкаф"),
    CURBSTONE("Тумба"),
    SHELF("Полка"),
    /* Офисная мебель*/
    TABLE("Стол"),
    CHAIR("Стул"),
    ROCKING_CHAIR("Кресло-качалка")
    ;

    private String title;
    private FurnitureItem name;

    FurnitureItem(String title) {
        this.title = title;
        this.name = this;
    }

    public String getTitle() {
        return title;
    }

    public FurnitureItem getName() {
        return name;
    }

    public static final EnumSet<FurnitureItem> ALL = EnumSet.of(
            BED, SOFA, ARMCHAIR,
            WARDROBE, CURBSTONE, SHELF,
            TABLE, CHAIR, ROCKING_CHAIR
            );
}
