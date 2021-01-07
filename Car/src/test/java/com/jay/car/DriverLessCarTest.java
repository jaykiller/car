package com.jay.car;


import com.jay.car.enums.ActionEnum;
import com.jay.car.enums.OrientationEnum;
import com.jay.car.impl.DriverLessCar;
import org.junit.Test;

public class DriverLessCarTest {

    private Car car = new DriverLessCar();

    @Test
    public void moveByRun() {

        car.move(ActionEnum.RUN.getCommand());
        System.out.println(car);
    }

    @Test
    public void moveByRunTwice() {
        for (int i = 0; i < 2; i++) {
            car.move(ActionEnum.RUN.getCommand());
        }
        System.out.println(car);
    }

    @Test
    public void moveByClockwiseRotation() {
        car.move(ActionEnum.CLOCKWISE_ROTATION.getCommand());
        System.out.println(car);
    }

    @Test
    public void moveByCounterClockwiseRotation() {
        car.move(ActionEnum.COUNTER_CLOCKWISE_ROTATION.getCommand());
        System.out.println(car);
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing North, when the Car turns clockwise, then the Car is still in the same position but is now facing East
     */
    @Test
    public void testByScene1() {
        car.move(ActionEnum.CLOCKWISE_ROTATION.getCommand());
        System.out.println(car);
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing North, when the Car moves forward, then the Car is still facing North but is now in position X = 1 and Y = 2
     */
    @Test
    public void testByScene2() {
        car.move(ActionEnum.RUN.getCommand());
        System.out.println(car);
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward, then the Car is still facing East but is now in position X = 2 and Y = 1
     */
    @Test
    public void testByScene3() {
        Car car = new DriverLessCar(OrientationEnum.EAST, 1, 1);
        car.move(ActionEnum.RUN.getCommand());
        System.out.println(car);
    }

    /**
     * Given the Car is in position X = 1 and Y = 1 and facing West, when the Car moves forward, then an exception is thrown
     */
    @Test
    public void testByScene4() {
        Car car = new DriverLessCar(OrientationEnum.WEST, 1, 1);
        car.move(ActionEnum.RUN.getCommand());
        System.out.println(car);
    }


    /**
     * Given the Car is in position X = 1 and Y = 1 and facing East, when the Car moves forward twice, then the Car is still facing East but is now in position X = 3 and Y = 1
     */
    @Test
    public void testByScene5() {
        Car car = new DriverLessCar(OrientationEnum.EAST, 1, 1);
        for (int i = 0; i < 2; i++) {
            car.move(ActionEnum.RUN.getCommand());
        }
        System.out.println(car);
    }
}
