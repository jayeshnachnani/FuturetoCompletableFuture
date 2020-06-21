package com.future.threads;

import java.util.concurrent.*;

public class ThreadNameFetcher implements Callable<String> {



    public ThreadNameFetcher (){
    }
    @Override
    public String call() throws Exception {
       // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("Thread fetcher call");

        return Thread.currentThread().getName();
    }

}