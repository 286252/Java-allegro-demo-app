package pl.szczerbiak.demoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageDto {
    private final String url;

    @Override
    public String toString() {
        return "ImageDto{" +
                "url='" + url + '\'' +
                '}';
    }

    public ImageDto(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


}
