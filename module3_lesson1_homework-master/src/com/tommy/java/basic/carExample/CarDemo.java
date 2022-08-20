package com.tommy.java.basic.carExample;

import com.tommy.java.basic.carExample.details.Engine;
import com.tommy.java.basic.carExample.professions.Driver;
import com.tommy.java.basic.carExample.vehicles.*;

public class CarDemo {

    public static void main(String[] args) {
        Driver bmwDriver = new Driver("Іванов В.В.", 50,  30);
        Engine bmwEngine = new Engine("60", "BMW");
        Car car = new Car();

        Driver lorryDriver = new Driver("Петров В.В.", 45,  20);
        Engine lorryEngine = new Engine("30", "LorryEngine");
        Lorry lorry = new Lorry();

        Driver sportDriver = new Driver("Сидоров В.В.", 30,  15);
        Engine sportEngine = new Engine("80", "SportEngine");
        SportCar sportCar = new SportCar();

        System.out.println(car);
        System.out.println(lorry);
        System.out.println(sportCar);
    }
}