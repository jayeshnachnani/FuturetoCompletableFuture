package com.future.threads;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class OrderFetcher implements Callable<String> {



    public OrderFetcher (){
    }
    @Override
    public String call() throws Exception {
       // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("In Order Fetcher");
        sleep(200);
        return Thread.currentThread().getName() + "order fetched";
    }

}