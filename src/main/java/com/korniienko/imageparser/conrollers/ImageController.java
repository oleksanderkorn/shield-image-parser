package com.korniienko.imageparser.conrollers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping(path = "/api/v1/images")
public class ImageController {

    private static final String IMAGES_URL = "https://s3.amazonaws.com/shielddevtest/photo.txt";

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<JsonNode> getImages() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL(IMAGES_URL);
            return ResponseEntity.ok(mapper.readTree(IOUtils.toByteArray(url)));
        } catch (IOException e) {
            ObjectNode jsonError = JsonNodeFactory.instance.objectNode();
            jsonError.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonError);
        }
    }
}
