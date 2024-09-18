package br.com.coutsoft.screensound.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MyMemoryResponse(@JsonAlias("translatedText") String translatedText) {
}
