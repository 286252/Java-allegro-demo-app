package pl.szczerbiak.demoapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract	 class DemoappApplicationTests {

	@Autowired
	protected TestRestTemplate httpClient;

	@LocalServerPort
	protected int port;

	@Autowired
	protected ObjectMapper objectMapper;

	/*@Test
	public void shouldReturnGreetings(){
		//given
		final String url = "http://localhost:" + port + "/hello";
		//when
		httpClient.getForEntity(url,String.class);
		ResponseEntity<String> response = httpClient.getForEntity(url, String.class);
		//wykonać request http na localhost:8081/hello

		//then
		//odpowiedź będzie zawierała napis "Hello World" i kod 200
		Assertions.assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Assertions.assertThat(response.getBody()).isEqualTo("Hello Heroku World");
	}*/
}
