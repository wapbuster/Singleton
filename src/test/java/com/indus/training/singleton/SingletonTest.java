package com.indus.training.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    //@Test
    public void testGetInstance() {

        Singleton expectedObj = Singleton.getInstance();
        Singleton actualObj = Singleton.getInstance();

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void testClone() {

        Singleton originalObj = Singleton.getInstance();
        Singleton cloneObj = null;
        try {
            cloneObj = (Singleton) originalObj.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        assertEquals(originalObj, cloneObj);
    }
}