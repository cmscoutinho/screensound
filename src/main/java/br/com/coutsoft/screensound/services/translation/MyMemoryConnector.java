package br.com.coutsoft.screensound.services.translation;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyMemoryConnector {
    private final String BASE_URL = "https://api.mymemory.translated.net/get?q=";
    private final String LANG_PAIR = "en|pt-br";

    public String consume(String prompt) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + URLEncoder.encode(prompt) + "&langpair=" + LANG_PAIR))
                .build();

        String json = "";
        try {
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            json = response.body().toString();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return json;
    }
}
