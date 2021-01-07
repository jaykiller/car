package com.jay.car.enums;

public enum ActionEnum {

    RUN("run"),
    CLOCKWISE_ROTATION("clockwise rotation"),
    COUNTER_CLOCKWISE_ROTATION("counter clockwise rotation"),
    ;

    private String command;

    ActionEnum(String command) {
        this.command = command;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
