package br.com.coutsoft.screensound.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CohereMessage(@JsonAlias("text") String text) {
}
