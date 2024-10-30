package com.drzewiecki.java.threads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceConditionTest {

    @Test
    void raceConditionTest() throws InterruptedException {
        Counter counter = new Counter();

        //each additional thread increases the impact of race condition
        Thread thread1 = new Thread(new Task(counter));
        Thread thread2 = new Thread(new Task(counter));
        Thread thread3 = new Thread(new Task(counter));
        Thread thread4 = new Thread(new Task(counter));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("Final counter value: " + counter.getCount());
        System.out.println("Final synchronized counter value: " + counter.getSynchronizedCount());
        assertThat(counter.getCount()).isLessThan(4000);
        assertThat(counter.getSynchronizedCount()).isEqualTo(4000);
    }

    @Getter
    class Counter {

        private int count = 0;
        private int synchronizedCount = 0;

        public void increment() {
            int temp = count;
            try {
                //increase sleep value to increase the impact of race condition
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = temp + 1;
        }

        public synchronized void synchronizedIncrement() {
            int temp = synchronizedCount;
            try {
                //increase sleep value to increase the impact of race condition
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronizedCount = temp + 1;
        }

    }

    @AllArgsConstructor
    class Task implements Runnable {

        private Counter counter;

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                counter.synchronizedIncrement();
            }
        }
    }
}
