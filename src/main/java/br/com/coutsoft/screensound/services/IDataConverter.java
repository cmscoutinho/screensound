package br.com.coutsoft.screensound.services;

public interface IDataConverter {

    public <T> T convertJson(String json, Class<T> outClass);
}
