package com.alex323glo.restvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Start point of this RESTful Web Service.
 *
 * All endpoints are described in MainController class.
 *
 * @author alex323glo
 * @version 1.0
 *
 * @see com.alex323glo.restvue.controller.MainController
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
