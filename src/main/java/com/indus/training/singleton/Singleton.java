package com.indus.training.singleton;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static final long serialVersionUID = 1418859892557268010L;

    private static Singleton ourInstance = null;

    private final static Object LOCK = new Object();

    private Singleton() {
    }

    /*// lazy instantiation
    public static Singleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton();
        }
        return ourInstance;
    }*/

    /*//using synchronized so that only one thread can call the method.
    public synchronized static Singleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton();
        }
        return ourInstance;
    }*/

    public static Singleton getInstance() {
        if (ourInstance == null) {
            synchronized (LOCK) {
                if (ourInstance == null) {
                    ourInstance = new Singleton();
                }
            }
        }
        return ourInstance;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        return Singleton.getInstance();
    }

    public Object readResolve() throws Exception {

        return Singleton.getInstance();
    }
}
