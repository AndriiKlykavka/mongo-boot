package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        /*=====1=====*/
        Animal animal = new Animal();
        animal.setParameters("Unknown", 0, "Unknown");
        printInfo(animal);
        Cat cat = new Cat();
        cat.interactWithReflection(animal, "Mursik", 4, "Chicken");
        printInfo(animal);

        /*=====2=====*/

        getInfoAboutClass(cat);
    }

    private static void printInfo(Animal animal) {
        System.out.println("Тварині з іменем " +  animal.getName() + " " + animal.getAge() + " років. ЇЇ улюблена їжа " + animal.getFavouriteFood());
    }

    private static void getInfoAboutClass(Object object){
        Class rClass = object.getClass();
        System.out.println("Інформація про клас " + rClass);
        for (Field field : rClass.getDeclaredFields()) {
            System.out.println("Поле - " + field.getName());
        }
        for (Method method : rClass.getDeclaredMethods()) {
            System.out.println("Метод - " + method.getName());
        }
    }
}
