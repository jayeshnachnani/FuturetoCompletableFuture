package com.future.threads;

import java.util.concurrent.Callable;

public class PaymentAccepter implements Callable<String> {



    public PaymentAccepter(){
    }
    @Override
    public String call() throws Exception {
       // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("In Payment Accepter");

        return Thread.currentThread().getName() + "payment accepted";
    }

}