package br.com.coutsoft.screensound.services;

import com.cohere.api.Cohere;
import com.cohere.api.requests.ChatRequest;
import com.cohere.api.types.NonStreamedChatResponse;

// TODO: filter response JSON
// TODO: translate response to brazilian portuguese
public class ChatPost {
    public static void test(String query) {
        // Use environment variable for token security
        String token = System.getenv("COHERE_KEY"); // Make sure you set this environment variable

        if (token == null || token.isEmpty()) {
            System.out.println("API token is not set.");
            return;
        }

        Cohere cohere = Cohere.builder().token(token).build();

        try {
            NonStreamedChatResponse response = cohere.chat(
                    ChatRequest.builder()
                            .message(query)  // Use the 'query' parameter
                            .build());

            System.out.println(response.getText());  // Printing the response text
        } catch (Exception e) {
            System.err.println("An error occurred while making the request: " + e.getMessage());
        }
    }
}


