package com.alex323glo.restvue.controller;

import com.alex323glo.restvue.model.User;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void register() throws Exception {
        User testUser = new User("register@gmail.com", "12345678");

        String parsedTestUserJSON = new JacksonJsonProvider().toJson(testUser);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/registration")
                        .contentType("application/json;charset=UTF-8")
                        .content(new JacksonJsonProvider().toJson(testUser)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void login() throws Exception {
        User testUser = new User("login@gmail.com", "12345678");

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/registration")
                        .contentType("application/json;charset=UTF-8")
                        .content(new JacksonJsonProvider().toJson(testUser)));

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/login")
                    .contentType("application/json;charset=UTF-8")
                    .content(new JacksonJsonProvider().toJson(testUser)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}