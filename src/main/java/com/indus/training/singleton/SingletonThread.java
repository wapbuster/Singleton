package com.indus.training.singleton;

public class SingletonThread extends Thread {

    private Singleton instanceThread = null;

    @Override
    public void run() {
        this.instanceThread = Singleton.getInstance();
    }

    public Singleton getInstanceThread() {
        return instanceThread;
    }


}
