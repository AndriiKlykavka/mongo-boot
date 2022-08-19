package com.tommy.java.basic.carExample.vehicles;


import com.tommy.java.basic.carExample.details.Engine;
import com.tommy.java.basic.carExample.professions.Driver;

public class Car {
    private String producer;
    private String aClass;
    private double weight;
    private Driver driver;
    private Engine engine;
    private boolean lightsOn = false;
    private boolean backlightsOn = false;
    private boolean turnsOn = false;
    private boolean trunkOpen = false;
    private String mode = "City";

    public Car(String producer, String aClass, double weight, Driver driver, Engine engine, boolean lightsOn, boolean backlightsOn, boolean turnsOn, boolean trunkOpen, String mode) {
        this.producer = producer;
        this.aClass = aClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
        this.lightsOn = lightsOn;
        this.backlightsOn = backlightsOn;
        this.turnsOn = turnsOn;
        this.trunkOpen = trunkOpen;
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        if(mode == "City" || mode == "Sport") {
            this.mode = mode;
        } else {
            throw new IllegalArgumentException("impossible mode");
        }
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public void setLightsOn(boolean lightsOn) {
        this.lightsOn = lightsOn;
    }

    public boolean isBacklightsOn() {
        return backlightsOn;
    }

    public void setBacklightsOn(boolean backlightsOn) {
        this.backlightsOn = backlightsOn;
    }

    public boolean isTurnsOn() {
        return turnsOn;
    }

    public void setTurnsOn(boolean turnsOn) {
        this.turnsOn = turnsOn;
    }

    public boolean isTrunkOpen() {
        return trunkOpen;
    }

    public void setTrunkOpen(boolean trunkOpen) {
        this.trunkOpen = trunkOpen;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getaClass() {
        return aClass;
    }

    public void setaClass(String aClass) {
        this.aClass = aClass;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("Поехали");
    }

    public void stop() {
        System.out.println("Останавливаемся");
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", aClass='" + aClass + '\'' +
                ", weight=" + weight +
                ", driver=" + driver +
                ", engine=" + engine +
                '}';
    }
}