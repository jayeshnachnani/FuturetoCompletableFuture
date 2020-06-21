package com.future.threads;

import java.util.concurrent.Callable;

public class EmailSender implements Callable<String> {



    public EmailSender(){
    }
    @Override
    public String call() throws Exception {
       // Thread.sleep(waitTime);
        //return the thread name executing this callable task
        System.out.println("In Email Sender");

        return Thread.currentThread().getName() + "email sent";
    }

}