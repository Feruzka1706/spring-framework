package com.cydeo.contoller;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)
class WelcomeControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void welcomeTest() throws Exception {
        //call /welcome end point
        //verify we got "welcome" text result

        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals(200,result.getResponse().getStatus());
        assertEquals("welcome",result.getResponse().getContentAsString());
    }


    @Test
    void welcomeTest2() throws Exception {

        //call /welcome end point
        //verify we got "welcome" text result

        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isOk()) //is(200)
                .andExpect(content().string("welcome"))
                .andReturn();
    }



}