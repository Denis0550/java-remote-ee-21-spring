package com.sda.javaremoteee21spring.optional;

import java.sql.SQLOutput;
import java.util.Optional;

public class OptionalExample {


    public static void main(String[] args) {
        String nick = myNick();
        System.out.println("Nick" + nick);
        System.out.println("Nick length " + (nick != null ? nick.length(): 0));

        System.out.println("Play with optional");
        emptyNick().ifPresent(nickInside -> {
            System.out.println("Our nick is:" + nickInside);
        });

        System.out.println("Play with optional");
        withNick().ifPresent(nickInside -> {
            System.out.println("From withNick(), nick is:" + nickInside);
        });

    }


    public static String myNick() {
        return null;
    }


    public static Optional<String> emptyNick() {
        return Optional.empty();
    }

    public static Optional<String> withNick() {
        return Optional.of("Nick");
    }
}
