


import org.apache.http.HttpResponse;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.*;

import java.util.ArrayList;
        import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class AsyncUsingFuture
{
    public static void main(String[] args) throws Exception
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        String[] urls ={"http://httpbin.org/get?value=1","http://httpbin.org/get?value=2","http://httpbin.org/get?value=3","http://httpbin.org/get?value=4","http://httpbin.org/get?value=5","http://httpbin.org/get?value=6"};

        List<Callable<Response>> taskList = new ArrayList<>();


        for (String uri: urls) {
            taskList.add(new AsyncCallable(uri));
        }

        List<Future<Response>> futures = executor.invokeAll(taskList);


        for(Future<Response> future : futures)
        {
            try
            {
                System.out.println("Future result is - " + " - " + future.get(2, TimeUnit.SECONDS).getResponseBody() + "; And Task done is " + future.isDone());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }
}

class AsyncCallable implements Callable<Response>
{

    private String url;
    private AsyncHttpClient asyncHttpClient;

    public AsyncCallable(String url) {
       this.url = url;
        this.asyncHttpClient = asyncHttpClient();
    }

    @Override
    public Response call() throws Exception {
        Thread.sleep(new Random().nextInt(1000));
        System.out.println("calling url: "+url);
        Response response = this.asyncHttpClient.prepareGet(url).execute().get();
        this.asyncHttpClient.close();
        System.out.println("response for "+url+" done");
        return response;

    }
}
