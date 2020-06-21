package com.future.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//Timer
//Change number of threads

public class FutureExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        //int numberoforders = 1;
        Instant start = Instant.now();
        for ( int numberoforders =1; numberoforders <=3; numberoforders++) {
            OrderFetcher orderFetcher = new OrderFetcher();
            OrderEnricher orderEnricher = new OrderEnricher("test");
            PaymentAccepter paymentAccepter = new PaymentAccepter();
            EmailSender emailSender = new EmailSender();
            //Placeholder or promise
            Future<String> future1 = executor.submit(orderFetcher);
            //System.out.println("Future is" + future1);
            Future<String> future2 = executor.submit(orderEnricher);
            Future<String> future3 = executor.submit(paymentAccepter);
            Future<String> future4 = executor.submit(emailSender);

            //Dependency Injection


            try {
                String order = future1.get();
                System.out.println("Order number #" + numberoforders + "Thread name " + order);
                //Future<String> future2 = executor.submit(orderEnricher);
                order = future2.get();
                System.out.println("Order number #" + numberoforders+"Thread name " + order);
                order = future3.get();
                System.out.println("Order number #" + numberoforders+"Thread name " + order);
                order = future4.get();
                System.out.println("Order number #" + numberoforders+"Thread name " + order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        System.out.println("Total time" + timeElapsed);
        executor.shutdown();


    }

}