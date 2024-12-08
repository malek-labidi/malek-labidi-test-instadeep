import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchApiExample {
    public static void main(String[] args) {
        try {
            // Define the API URL
            String apiUrl = "https://api.example.com/data";

            // Create an HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Build the HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET() // Optional, as GET is the default
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the status code
            if (response.statusCode() == 200) {
                System.out.println("Data fetched successfully:");
                System.out.println(response.body()); // Print the response body
            } else {
                System.err.println("Error: HTTP " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
