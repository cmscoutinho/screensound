package br.com.coutsoft.screensound.services;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class APIConsumer {

    public String connect() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().build();

        return "";
    }
} 
