package com.company;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Cat extends Animal{

    public void interactWithReflection(Animal animal, String name, Integer age, String favouriteFood) throws IllegalAccessException {
        Class<? extends Animal> rClass =animal.getClass();
        for(Field field : rClass.getDeclaredFields()){
            if("name".equals(field.getName())){
                field.setAccessible(true);
                Object oldName = field.get(animal);
                field.set(animal, name);
                System.out.printf("Замінили старе ім'я %s на нове %s %n", oldName, name);
            }
            if("age".equals(field.getName())){
                field.setAccessible(true);
                Object oldAge = field.get(animal);
                field.set(animal, age);
                System.out.printf("Замінили старий вік %s на новий %s %n", oldAge, age);
            }
            if("favouriteFood".equals(field.getName())){
                field.setAccessible(true);
                Object oldfavouriteFood = field.get(animal);
                field.set(animal, favouriteFood);
                System.out.printf("Замінили стару улюблену страву %s на нову %s %n", oldfavouriteFood, favouriteFood);
            }
        }
    }
}
