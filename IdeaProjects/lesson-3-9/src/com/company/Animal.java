package com.company;

public class Animal {
    public String name;
    private Integer age;
    protected String favouriteFood;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setParameters(String name, Integer age, String favouriteFood) {
        this.name = name;
        this.age = age;
        this.favouriteFood = favouriteFood;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setAge(Integer age) {
        this.age = age;
    }



    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }
}
