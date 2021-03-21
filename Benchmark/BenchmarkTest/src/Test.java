import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Test {

    public static void main(String[] args){
        // TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);
        //StringBuilder sb = new StringBuilder();
        System.out.print("Enter a word to search for: ");
        String word = input.next();

        HttpClient client = HttpClient.newHttpClient();

        //build request
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/BenchmarkRestService/rest/verse/getverse/" + word)).build();

        // send async request using client
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();


    }
}
