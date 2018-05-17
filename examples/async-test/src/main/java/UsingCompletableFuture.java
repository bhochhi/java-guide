import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingCompletableFuture {

    //TODO: 1. Take care of Async calls. 2. Take care of max wait time. 3. Take care of Exception from each async all. 4. Take care of putting all response into out output response.

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

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }


}


class AsyncResponse{


}

class AsyncRequest{

}

class AsyncUsingCompleteableFuture{



    List<AsyncResponse> invokeAll(List<AsyncRequest> requests){
        return null;
    }


}
