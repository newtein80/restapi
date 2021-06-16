package com.nile.apiservice.item.model.enums;

public enum ItemMetaType {
    // https://cla9.tistory.com/96?category=869583
    ITEM_ID("itemId"),
    TITLE("title");

    private String name;
    ItemMetaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
