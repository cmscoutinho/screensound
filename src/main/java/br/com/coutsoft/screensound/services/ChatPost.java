package br.com.coutsoft.screensound.services;

import com.cohere.api.Cohere;
import com.cohere.api.requests.ChatRequest;
import com.cohere.api.types.NonStreamedChatResponse;

// TODO: set key in local environment variable
// TODO: filter response JSON
// TODO: translate response to brazilian portuguese
public class ChatPost {
    public static void test() {
        Cohere cohere = Cohere.builder().token(System.getenv("COHERE_KEY")).build();

        NonStreamedChatResponse response = cohere.chat(
                ChatRequest.builder()
                        .message("What year was Bruce Dickinson born?").build());

        System.out.println(response);
    }
}


