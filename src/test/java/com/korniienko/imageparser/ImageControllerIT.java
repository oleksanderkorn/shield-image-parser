package com.korniienko.imageparser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ImageControllerIT {

    @LocalServerPort
    private int port;

    private URL url;
    private JsonNode imagesJson;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.url = new URL("http://localhost:" + port + "/api/v1/images");
        this.imagesJson = new ObjectMapper().readTree(FileUtils.getFile("imagesResponse.json"));
    }

    @Test
    public void getImages() throws Exception {
        ResponseEntity<JsonNode> response = template.getForEntity(url.toString(), JsonNode.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody(), equalTo(imagesJson));
    }
}

