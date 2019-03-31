package pl.szczerbiak.demoapp.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import pl.szczerbiak.demoapp.DemoappApplicationTests;

public class HelloWorldEndpoinTest extends DemoappApplicationTests {

    @Test
    public void shouldReturnGreetings(){
        //given
        final String url = "http://localhost:" + port + "/hello";

        //when
        ResponseEntity<String> response = httpClient.getForEntity(url, String.class);

        //wykonać request http na localhost:8081/hello

        //then
        //odpowiedź będzie zawierała napis "Hello World" i kod 200
        Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
        Assertions.assertThat(response.getBody()).isEqualTo("Hello Heroku World");
    }

}
