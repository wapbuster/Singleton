package com.indus.training.singleton;

public class Singleton implements Cloneable {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
