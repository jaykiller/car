package com.jay.car.impl;

import com.jay.car.Car;
import com.jay.car.enums.ActionEnum;
import com.jay.car.enums.OrientationEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * Driverless Car
 */
public class DriverLessCar implements Car {

    private int endPoint;
    private int startingPoint;
    // Abscissa
    private int positionX;
    // Ordinate
    private int positionY;
    // North by default
    private OrientationEnum orientation;

    public DriverLessCar() {
        this.endPoint = 4;
        this.startingPoint = 1;
        this.positionX = startingPoint;
        this.positionY = startingPoint;
        this.orientation = OrientationEnum.NORTH;
    }


    public DriverLessCar(OrientationEnum orientation, int positionX, int positionY) {
        this(4, 1, positionX, positionY, orientation);
    }

    public DriverLessCar(int endPoint, int startingPoint, int positionX, int positionY, OrientationEnum orientation) {
        this.endPoint = endPoint;
        this.startingPoint = startingPoint;
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    @Override
    public void move(String command) {
        try {
            if (StringUtils.isBlank(command)) {
                throw new NullPointerException();
            }
            if (command.equalsIgnoreCase(ActionEnum.RUN.getCommand())) {
                // run
                moveByRun();
            } else if (command.equalsIgnoreCase(ActionEnum.CLOCKWISE_ROTATION.getCommand())) {
                // clockwise rotation
                moveByClockwiseRotation();
            } else if (command.equalsIgnoreCase(ActionEnum.COUNTER_CLOCKWISE_ROTATION.getCommand())) {
                // counter clockwise rotation
                moveByCounterClockwiseRotation();
            } else {
                throw new IllegalAccessError("This command is error!");
            }
        } finally {
            checkOutOfBoundary();
        }

    }

    protected void moveByRun() {
        switch (orientation) {
            case EAST:
                moveByPositionX(1);
                break;
            case WEST:
                moveByPositionX(-1);
                break;
            case NORTH:
                moveByPositionY(1);
                break;
            case SOUTH:
                moveByPositionY(-1);
                break;
        }
    }

    protected void moveByPositionX(int posX) {
        this.positionX = this.positionX + posX;
    }

    protected void moveByPositionY(int posY) {
        this.positionY = this.positionY + posY;
    }

    protected void moveByClockwiseRotation() {
        switch (orientation) {
            case EAST:
                orientation = OrientationEnum.SOUTH;
                break;
            case SOUTH:
                orientation = OrientationEnum.WEST;
                break;
            case WEST:
                orientation = OrientationEnum.NORTH;
                break;
            case NORTH:
                orientation = OrientationEnum.EAST;
                break;
        }
    }

    protected void moveByCounterClockwiseRotation() {
        switch (orientation) {
            case EAST:
                orientation = OrientationEnum.NORTH;
                break;
            case SOUTH:
                orientation = OrientationEnum.EAST;
                break;
            case WEST:
                orientation = OrientationEnum.SOUTH;
                break;
            case NORTH:
                orientation = OrientationEnum.WEST;
                break;
        }
    }

    /**
     * Check if it's outside the parking lot boundary, If so, an exception is thrown
     */
    protected void checkOutOfBoundary() {
        if (this.positionX < startingPoint || this.positionY < startingPoint
                || this.positionX > endPoint || this.positionY > endPoint)
            throw new IllegalAccessError("You can't leave the parking lot");
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public String getOrientation() {
        return orientation.getName();
    }

    @Override
    public String toString() {
        return String.format("At present, it is located at x = %d and y = %d, and the direction is %s",
                positionX, positionY, orientation.getName());
    }
}
