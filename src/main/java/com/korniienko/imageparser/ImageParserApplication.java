package com.korniienko.imageparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class ImageParserApplication {

  public static void main(String[] args) {
    SpringApplication.run(ImageParserApplication.class, args);
  }
}
