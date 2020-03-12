package com.example.app1.controller;

import com.example.app1.model.RequestModel;
import com.example.app1.util.ObjectUtils;
import com.example.app1.util.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
 */
@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest
/* --------------- MOCK MVC ----------------------------------------------------------------------------- */
class AppControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
            RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                //.alwaysDo(document("{class-name}/{method-name}",
                 //   preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
                .build();
    }

    @Test
    void home() throws Exception {
        String text = "testCaseVal";

        this.mockMvc.perform(
                get("/home/{inp}", text))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(StringUtils.isEqual(jsonPath("$.content", is(text))))
                .andDo(document("controller-test-mvc/{method-name}",
                                //links(linkWithRel("home").description("The HOME resource")),
                                pathParameters(
                                        parameterWithName("inp").description("The input of the testy")),
                                responseFields(
                                    subsectionWithPath("message").description("message of response"),
                                    subsectionWithPath("success").description("success status of response"),
                                    subsectionWithPath("data").description("data value of response")),
                                responseHeaders(headerWithName("Content-Type").description("The Content-Type of the payload"))
                               )
                      );

        /* // WORKS!!!!!
        this.mockMvc.perform(get("/", text)).andExpect(status().isOk())
                .andDo(document("index",
                                //links(linkWithRel("sum").description("The SUM resource")),
                                //pathParameters(
                                //        parameterWithName("inp").description("The input of the testy")),
                                responseFields(
                                    subsectionWithPath("message").description("message of response"),
                                    subsectionWithPath("success").description("success status of response"),
                                    subsectionWithPath("data").description("data value of response")),
                                responseHeaders(headerWithName("Content-Type").description("The Content-Type of the payload"))
                               )
                      );
         */


        /*
        mvc.perform(MockMvcRequestBuilders.get("/" + text))
                .andExpect(mvcResult -> StringUtils.isEqual(
                        MockMvcResultMatchers.jsonPath("$.data").toString(), text))
                .andDo(print())
                .andDo(document("Home First Test"));

         */
    }

    @Test
    void sum() throws Exception {

        String str = ObjectUtils.asJsonString(new RequestModel(StringUtils.emptyString(), 2, 5));


        this.mockMvc.perform(post("/sum")
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .content(str)
                                    //.accept(MediaType.APPLICATION_JSON)
                                     //.param("num1", "1").param("num2", "5").param("param", "")
                                //.param("req", new RequestModel(StringUtils.emptyString(), 2, 5))
                            ).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(document("controller-test-mvc/{method-name}",
                                //links(linkWithRel("home").description("The HOME resource")),
                                requestFields(
                                        fieldWithPath("num1").description("Num1 value"),
                                        fieldWithPath("num2").description("Num2 value"),
                                        fieldWithPath("param").description("param string")
                                             ),
                                responseFields(
                                        subsectionWithPath("message").description("message of response"),
                                        subsectionWithPath("success").description("success status of response"),
                                        subsectionWithPath("data").description("data value of response")),
                                responseHeaders(headerWithName("Content-Type").description("The Content-Type of the payload"))
                               )
                      );
                //.andExpect(jsonPath("$.message").value("Hello World John Doe!!!"))
                //.andExpect(jsonPath("$.data").value(1));
                ;

        //this.mockMvc.perform(post("/sum", ))

        /*
        this.mockMvc.perform(get("/")).andExpect(status().isOk())
                .andDo(document("index", links(linkWithRel("crud").description("The CRUD resource")),
                                responseFields(subsectionWithPath("_links").description("Links to other resources")),
                                responseHeaders(headerWithName("Content-Type").description("The Content-Type of the payload"))));

         */
    }
}