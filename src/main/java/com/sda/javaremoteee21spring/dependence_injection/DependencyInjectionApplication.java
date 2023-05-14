package com.sda.javaremoteee21spring.dependence_injection;

public class DependencyInjectionApplication {
    public static void main(String[] args) {
        // created beans
        // injecting dependencies
        Dog dog = new Dog();
        Zoo zoo = new Zoo(dog); // injecting dog into zoo
        EntertainmentPark entertainmentPark = new EntertainmentPark(zoo); // injecting zoo into EP



    }
}
