package com.interview.demo.restdemo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestDemoApplicationTests {
	
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    private final Integer MIN_VALUE = 1;
    private final Integer MAX_VALUE = 6;

    @Test
    public void getRandomNumber() throws Exception {
        Integer number = this.restTemplate.getForObject("http://localhost:" + port + "/random/number",Integer.class);
        assertTrue(number >= MIN_VALUE && number<= MAX_VALUE);
    }
    

    @Test
    public void getRandomNumberWithValue() throws Exception {
        Integer number = this.restTemplate.getForObject("http://localhost:" + port + "/random/number?value=10",Integer.class);
        assertTrue(number >= MIN_VALUE && number<= 10);
    }

    @Test (expected = RestClientException.class)
    public void getRandomNumberWithWrongValue() throws Exception {
    	 this.restTemplate.getForObject("http://localhost:" + port + "/random/number?value=\"sdfjksd\"", Integer.class);
    }
    
    @Test
    public void getRandomNumberForZero() {
        Integer number = this.restTemplate.getForObject("http://localhost:" + port + "/random/number?value=0",Integer.class);
        assertTrue(number==MIN_VALUE);	
    	
    }

}
