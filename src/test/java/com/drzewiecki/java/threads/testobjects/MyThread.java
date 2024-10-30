package com.drzewiecki.java.threads.testobjects;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Blabla");
    }
}
