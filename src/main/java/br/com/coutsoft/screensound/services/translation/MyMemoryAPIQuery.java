package br.com.coutsoft.screensound.services.translation;

import br.com.coutsoft.screensound.model.MyMemoryTranslatedResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyMemoryAPIQuery {


    public static String translate(String input) {

        ObjectMapper mapper = new ObjectMapper();
        MyMemoryAPIConsumer consumer = new MyMemoryAPIConsumer();

        String json = consumer.consume(input);

        MyMemoryTranslatedResponse response;

        try {
            response = mapper.readValue(json, MyMemoryTranslatedResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return response.responseData().translatedText();
    }
}
