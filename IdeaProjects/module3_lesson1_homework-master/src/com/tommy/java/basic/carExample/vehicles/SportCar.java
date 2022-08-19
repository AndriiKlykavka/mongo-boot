package com.tommy.java.basic.carExample.vehicles;

import com.tommy.java.basic.carExample.details.Engine;
import com.tommy.java.basic.carExample.professions.Driver;


public class SportCar extends Car {
    private double speed;

    public SportCar(String producer, String aClass, double weight, Driver driver, Engine engine, double speed) {
        super(producer, aClass, weight, driver, engine);
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "speed=" + speed +
                "} " + super.toString();
    }
}