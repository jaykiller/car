package com.jay.car.enums;

public enum OrientationEnum {

    SOUTH("South"), NORTH("North"), WEST("West"), EAST("East"),
    ;

    private String name;

    OrientationEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
