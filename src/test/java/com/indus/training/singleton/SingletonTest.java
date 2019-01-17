package com.indus.training.singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void getInstance() {

        Singleton expectedObj = Singleton.getInstance();
        Singleton actualObj = Singleton.getInstance();

        assertEquals(expectedObj, actualObj);
    }
}