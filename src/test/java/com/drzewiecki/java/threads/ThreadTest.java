package com.drzewiecki.java.threads;

import com.drzewiecki.java.threads.testobjects.MyThread;
import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void testThread() {
        MyThread thread = new MyThread();
        thread.run();

        Thread thread2 = new Thread();
        thread2.run();

    }
}
