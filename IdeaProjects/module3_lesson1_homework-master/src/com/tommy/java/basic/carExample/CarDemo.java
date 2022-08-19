package com.tommy.java.basic.carExample;

import com.tommy.java.basic.carExample.details.Engine;
import com.tommy.java.basic.carExample.professions.Driver;
import com.tommy.java.basic.carExample.vehicles.*;

public class CarDemo {

    public static void main(String[] args) {
        Driver bmwDriver = new Driver("Иванов В.В.", 50,  30);
        Engine bmwEngine = new Engine("60", "BMW");
        Car car = new Car("BMW", "C", 5000, bmwDriver, bmwEngine, false, false, false, false, "City");

        Driver lorryDriver = new Driver("Петров В.В.", 45,  20);
        Engine lorryEngine = new Engine("30", "LorryEngine");
        Lorry lorry = new Lorry("Грузовик", "D", 8000, lorryDriver, lorryEngine, 70);

        Driver sportDriver = new Driver("Сидоров В.В.", 30,  15);
        Engine sportEngine = new Engine("80", "SportEngine");
        SportCar sportCar = new SportCar("SportCar", "C", 4000, sportDriver, sportEngine, 300);

        System.out.println(car);
        System.out.println(lorry);
        System.out.println(sportCar);
    }
}