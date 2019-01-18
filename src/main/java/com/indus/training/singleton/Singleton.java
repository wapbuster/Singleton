package com.indus.training.singleton;

import java.io.Serializable;

public class Singleton implements Cloneable, Serializable {

    private static final long serialVersionUID = 1418859892557268010L;

    private static Singleton ourInstance = null;

    private Singleton() {
    }

    /*// lazy instantiation
    public static Singleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton();
        }
        return ourInstance;
    }*/

    public synchronized static Singleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton();
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
