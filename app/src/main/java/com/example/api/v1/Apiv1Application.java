package com.example.api.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Apiv1Application {

  public static void main(String[] args) {
    SpringApplication.run(Apiv1Application.class, args);
  }
}
