package com.example.app1.controller;

import com.example.app1.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
class AppControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void home() throws Exception {
        String text = "testCaseVal";
        mvc.perform(MockMvcRequestBuilders.get("/" + text))
                .andExpect(mvcResult -> StringUtils.isEqual(
                        MockMvcResultMatchers.jsonPath("$.data").toString(), text))
                .andDo(print())
                .andDo(document("Home First Test"));
    }

    @Test
    void sum() {
    }
}