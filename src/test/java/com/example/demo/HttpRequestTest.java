package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/greeting",
                String.class)).contains("He that breaks a thing to find out what it is, has left the path of wisdom, Aaron");
    }

    @Test
    public  void helloShouldReturAform()throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:"+ port + "/hello", String.class)).contains("" +
                "<h1> Welcome to the server young Padawan</h1> " +
                "<h3> What is your name</h3>" +
                "<form method='post'> " +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me !'/>" +
                "</form>");



    }
}
