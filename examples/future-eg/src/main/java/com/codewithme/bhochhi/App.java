package com.codewithme.bhochhi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! Hola" );

        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        
            executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
            
            
            
            
            try {
                System.out.println("attempt to shutdown executor");
                executor.shutdown(); //prefered way to shutdown
                executor.awaitTermination(5, TimeUnit.SECONDS);
            }
            catch (InterruptedException e) {
                System.err.println("tasks interrupted");
            }
            finally {
                if (!executor.isTerminated()) {
                    System.err.println("cancel non-finished tasks");
                }
                executor.shutdownNow(); //hard 
                System.out.println("shutdown finished");
            }
            
            //Callables and Futures
            
});
            

    }
}
