import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

import static sun.swing.SwingUtilities2.submit;

public class UsingCompletableFuture {

    //TODO:
    // 1. Take care of Async calls.
    // 1.1. Take care of REST and SOAP calls
    // 2. Take care of max wait time.
    // 3. Take care of Exception from each async all.
    // 4. Take care of putting all response into out output response.

    /**
     * Steps:
     * 1. Initialize Executor
     * 2. Create list of Callable Tasks
     * 3.
     *
     */

    /**
     * INPUT: List of Request.
     * OUTPUT: List of Response.
     *
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> response = new UsingCompletableFuture().calculateAsync();
        System.out.println("Response: "+ response.get());

    }




    public Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            Thread.sleep(1);
            completableFuture.complete("Hello");
            return null;
        });
        executorService.awaitTermination(2, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        return completableFuture;
    }


}




class AsyncResponse{


}

class CompletableTask{

}

class AsyncUsingCompleteableFuture{



    List<AsyncResponse> invokeAll(List<?> requests){
        return null;
    }


}
