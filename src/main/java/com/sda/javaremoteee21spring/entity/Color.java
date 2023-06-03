package com.sda.javaremoteee21spring.entity;

public enum Color {
    SOUL_RED("Nice red"),
    RED("Normal red"),
    BLUE("Just blue"),
    PINK("Pinky"),
    GRAY("Graaaaaay");

    private String description;

    Color(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        Color soulRed = SOUL_RED;
        System.out.println(soulRed.getDescription());
    }
}
