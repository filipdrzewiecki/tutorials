package com.drzewiecki.java.threads;

import com.drzewiecki.java.threads.testobjects.MyThread;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

    @Test
    void testThread() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
//        executor.execute(() -> System.out.println("Hello World"));
//
//        Future<String> future = executor.submit(() -> "Hello World");
//
//        String result = future.get();


        Runnable runnableTask = () -> {
            System.out.println("runnable task");
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution dasdsadasda";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        executor.execute(runnableTask);

        String result = executor.invokeAny(callableTasks);

        System.out.println("Rezultat=" + result);

        Future<String> future = executor.submit(callableTask);
        String rsultat = future.get();

        System.out.println("Rezultat of future=" + rsultat);

//        List<Future<String>> futures = executor.invokeAll(callableTasks);

//        executor.shutdown();
//
//
//        executor.execute(runnableTask);



    }

}
