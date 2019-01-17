package com.indus.training.singleton;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class SingletonTest {

    //@Test
    public void testGetInstance() {

        Singleton expectedObj = Singleton.getInstance();
        Singleton actualObj = Singleton.getInstance();

        assertEquals(expectedObj, actualObj);
    }

    //@Test
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

    @Test
    public void testSerializeInMemory() {

        Singleton origObj = Singleton.getInstance();
        Singleton secondObj = null;

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream objOut = null;

        byte[] byteArray = null;

        try {
            objOut = new ObjectOutputStream(byteOut);
            objOut.writeObject(origObj);
            byteArray = byteOut.toByteArray();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            if (objOut != null) {
                try {
                    objOut.close();
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                }
            }
        }

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteArray);
        ObjectInputStream objIn = null;

        try {
            objIn = new ObjectInputStream(byteIn);
            try {
                secondObj = (Singleton) objIn.readObject();
            } catch (ClassNotFoundException clznfe) {
                clznfe.printStackTrace();
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            if (objIn != null) {
                try {
                    objIn.close();
                } catch (IOException ioEx) {
                    ioEx.printStackTrace();
                }
            }
        }
        assertEquals(origObj, secondObj);

    }
}