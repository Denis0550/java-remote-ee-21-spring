package com.sda.javaremoteee21spring.dependence_injection;

public class Zoo {
    private final Dog kingOfTheZoo;

    public Zoo(Dog kingOfTheZoo) {
        this.kingOfTheZoo = kingOfTheZoo;
    }
}
