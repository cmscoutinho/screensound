package br.com.coutsoft.screensound.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements  IDataConverter{

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T convertJson(String json, Class<T> outClass) {
        try {
            return mapper.readValue(json, outClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
