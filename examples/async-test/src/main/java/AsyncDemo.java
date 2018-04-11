import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Future;

public class AsyncDemo {

    private JsonNode body;

    public static void main(String[] args)  throws Exception{
//        new AsyncDemo().singlePostCall();
        new AsyncDemo().multipleCalls();
    }

    private void singlePostCall() {
        try {
            HttpResponse<JsonNode> response = Unirest.post("http://httpbin.org/post")
                    .header("accept", "application/json")
                    .queryString("apiKey", "123")
                    .field("parameter", "value")
                    .field("foo", "bar")
                    .asJson();
            System.out.println("Response: " + response.getBody());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void multipleCalls() throws Exception {
        AsyncCall().get();
        AsyncCall().get();

        try{
//            Unirest.shutdown();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    private Future<HttpResponse<JsonNode>> AsyncCall() {

    return Unirest.post("http://httpbin.org/post")
            .header("accept", "application/json")
            .field("param1", "value1")
            .field("param2", "value2")
            .asJsonAsync(new Callback<JsonNode>() {

                public void failed(UnirestException e) {
                    System.out.println("The request has failed");
                }

                public void completed(HttpResponse<JsonNode> response) {
                    int code = response.getStatus();
                    Map headers = response.getHeaders();
                    JsonNode body = response.getBody();
                    InputStream rawBody = response.getRawBody();
                    System.out.println("Body: " + body);
                }

                public void cancelled() {
                    System.out.println("The request has been cancelled");
                }

            });
    }
}
