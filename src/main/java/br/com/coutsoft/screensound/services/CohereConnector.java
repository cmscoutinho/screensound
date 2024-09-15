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
                        "prompt": "Tell me about football.",
                        "max_tokens": 100,
                        "temperature": 0.75
                    }
                    """;

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
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
