package com.completablefuture.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.lang.Thread.sleep;

//Timer
//Change number of threads

public class CompletableFutureExample {
    private static int count=0;


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);


        Supplier<String> orderFetcher = () -> {
             sleep(200);
             count++;
             System.out.println("\n" + String.valueOf(count) + "\n") ;
             return Thread.currentThread().getName() +  "order fetched " + String.valueOf(count) + " ";
        };

        Function orderEnricher = order -> {
            return order + "order Enriched " + Thread.currentThread().getName();
        };



        Consumer<String> emailSender = orderEnriched -> {
            System.out.println(orderEnriched + "Email Sent for order " + Thread.currentThread().getName() + "\n") ;
            Instant end = Instant.now();
            System.out.println("End time " + end);

        };

        int numberoforders = 1;
        Instant start = Instant.now();
        System.out.println("Start time " + start);
        CompletableFuture cf1;
        for ( numberoforders =1; numberoforders <=3; numberoforders++) {

            cf1 = CompletableFuture.supplyAsync(orderFetcher,executor).thenApplyAsync(orderEnricher).thenAcceptAsync(emailSender,executor);
        }
        //cf1.complete(null);

        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("MAIN STILL HAS LOT OF FREE TIME...." + timeElapsed);
        //executor.shutdown();

        sleep(1000);
        executor.shutdown();


    }

    private static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
        }
    }

}