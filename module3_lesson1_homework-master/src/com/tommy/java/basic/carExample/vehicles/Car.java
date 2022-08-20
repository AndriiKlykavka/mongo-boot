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


    public boolean isLightsOn() {
            return lightsOn;
    }

    public void setLightsOn() {
        if(!this.lightsOn) {
            this.lightsOn =  true;
        } else {
            throw new IllegalArgumentException("Lights are already on!");
        }
    }

    public void setLightsOff(){
        if(this.lightsOn) {
            this.lightsOn =  false;
        } else {
            throw new IllegalArgumentException("Lights are already off!");
        }
    }

    public boolean isBacklightsOn() {
        return backlightsOn;
    }

    public void setBacklightsOn() {
        if(!this.backlightsOn) {
            this.backlightsOn =  true;
        } else {
            throw new IllegalArgumentException("Backlights are already on!");
        }
    }
    public void setBacklightsOff() {
        if(this.backlightsOn) {
            this.backlightsOn =  false;
        } else {
            throw new IllegalArgumentException("Backlights are already off!");
        }
    }

    public boolean isTurnsOn() {
        return turnsOn;
    }

    public void setTurnsOn() {
        if(!this.turnsOn) {
            this.turnsOn =  true;
        } else {
            throw new IllegalArgumentException("Turns are already on!");
        }
    }

    public void setTurnsOff() {
        if(this.backlightsOn) {
            this.backlightsOn =  false;
        } else {
            throw new IllegalArgumentException("Turns are already off!");
        }
    }

    public boolean isTrunkOpen() {
        return trunkOpen;
    }

    public void setTrunkOpen() {
        if(!this.trunkOpen) {
            this.trunkOpen =  true;
        } else {
            throw new IllegalArgumentException("Trunk is already opened!");
        }
    }
    public void setTrunkClosed() {
        if(this.trunkOpen) {
            this.trunkOpen =  false;
        } else {
            throw new IllegalArgumentException("Trunk Trunk already closed!");
        }
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        if(mode == "City" || mode == "Sport") {
            this.mode = mode;
        } else {
            throw new IllegalArgumentException("Unknown car mode");
        }
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