package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DescriptionDto {
    private final String text;

    public DescriptionDto(@JsonProperty("text") String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "DescriptionDto{" +
                "text='" + text + '\'' +
                '}';
    }
}
