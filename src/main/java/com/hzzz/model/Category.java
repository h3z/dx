package com.hzzz.model;

import java.util.Optional;

/**
 * Created by hzzzxc on 2017/4/27.
 */
public enum Category {
    ELECTRONIC(Optional.empty()),
    COMPUTER(Optional.of(ELECTRONIC)),
    LAPTOP(Optional.of(COMPUTER)),
    MACBOOKS(Optional.of(LAPTOP)),
    LENOVO(Optional.of(LAPTOP)),
    DELL(Optional.of(LAPTOP)),
    TABLET(Optional.of(COMPUTER)),
    TV(Optional.of(ELECTRONIC)),
    TV3D(Optional.of(TV)),
    SMART_TV(Optional.of(TV)),
    LED_TV(Optional.of(TV)),
    CAMERA(Optional.of(ELECTRONIC)),
    CELLPHONE(Optional.of(ELECTRONIC)),
    BOOKS(Optional.empty());

    private final Optional<Category> parentCategory;

    Category(Optional<Category> parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Optional<Category> getParentCategory() {
        return parentCategory;
    }
}
