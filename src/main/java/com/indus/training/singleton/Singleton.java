package com.indus.training.singleton;

public class Singleton {
    private static Singleton ourInstance = null;

    private Singleton() {
    }

    // lazy instantiation
    public static Singleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton();
        }
        return ourInstance;
    }


}
