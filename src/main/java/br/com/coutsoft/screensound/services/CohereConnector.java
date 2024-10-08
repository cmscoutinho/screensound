package br.com.coutsoft.screensound.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CohereConnector {
    public static String cohereConnect(String query) {

        try {
            // API URL for text generation
            String url = "https://api.cohere.ai/v1/chat";

            // API key, retrieved from environment variable for security
            String apiKey = System.getenv("COHERE_KEY"); // Set this in your environment

            if (apiKey == null || apiKey.isEmpty()) {
                System.out.println("API token is not set.");
                return null;
            }

            // Build the JSON request body
            String requestBody = """
                    {
                        "model": "command",
                        "message": "Tell me about music artist %s in short.",
                        "max_tokens": 30,
                        "temperature": 0.75
                    }
                    """.formatted(query);

            // Create an HTTP client
            HttpClient client = HttpClient.newHttpClient();

            // Create the POST request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response
            return response.statusCode() == 200 ? response.body() : "Invalid request!";

        } catch (InterruptedException | IOException e) {
            System.err.println(e.getMessage());
        }

        return "";
    }
}
