import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.assertEquals;
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

        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        assertEquals("Hello Beautiful World", combined);


        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApplyAsync(s -> s + " World11");

        assertEquals("Hello World", future.get());
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
