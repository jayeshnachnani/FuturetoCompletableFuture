package com.future.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ThreadNameFetcher threadNameFetcher = new ThreadNameFetcher();
        //Placeholder or promise
        Future<String> future1 = executor.submit(threadNameFetcher);


        try {
            String threadName = future1.get();
            System.out.println("Thread name " + threadName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //executor.shutdown();


    }

}