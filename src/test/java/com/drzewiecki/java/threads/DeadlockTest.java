package com.drzewiecki.java.threads;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DeadlockTest {

    @Test
    @Disabled
    void testDeadlock() throws InterruptedException {
        final Object resource1 = "Resource1";
        final Object resource2 = "Resource2";

        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        thread1.start();
        thread2.start();

        Thread.sleep(200);
        System.out.println("here");
        assertTimeout(Duration.ofSeconds(0), () -> {
            thread1.join();
            thread2.join();
        }, "Deadlock detected: threads did not complete within timeout");
    }


    @Test
    void testDeadlock2() throws InterruptedException {
        final Object resource1 = "Resource1";
        final Object resource2 = "Resource2";

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Void> task1 = () -> {
            synchronized (resource1) {
                System.out.println("Thread 1: locked resource 1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("Thread 1: locked resource 2");
                }
            }
            return null;
        };

        Callable<Void> task2 = () -> {
            synchronized (resource2) {
                System.out.println("Thread 2: locked resource 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("Thread 2: locked resource 1");
                }
            }
            return null;
        };

        Future<Void> future1 = executor.submit(task1);
        Future<Void> future2 = executor.submit(task2);

        boolean wasDeadlockDetected = false;
        try {
            future1.get(1, TimeUnit.SECONDS);
            future2.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Deadlock detected: threads did not complete within timeout");
            wasDeadlockDetected = true;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new AssertionError("Exception detected, but no deadlock");
        } finally {
            executor.shutdownNow();
        }
        assertTrue(wasDeadlockDetected);
    }

}
