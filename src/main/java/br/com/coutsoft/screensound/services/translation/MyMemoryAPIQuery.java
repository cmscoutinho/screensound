package br.com.coutsoft.screensound.services.translation;

import br.com.coutsoft.screensound.model.MyMemoryTranslatedResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyMemoryAPIQuery {

    ObjectMapper mapper = new ObjectMapper();

    public String translate(String input) {
        MyMemoryAPIConsumer consumer = new MyMemoryAPIConsumer();

        String json = consumer.consume(input);

        MyMemoryTranslatedResponse response;

        try {
            response = mapper.readValue(json, MyMemoryTranslatedResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return response.response().translatedText();
    }
}
