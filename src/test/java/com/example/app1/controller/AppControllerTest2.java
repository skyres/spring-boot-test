package com.example.app1.controller;

import com.example.app1.model.RequestModel;
import com.example.app1.service.AppService;
import com.example.app1.util.StringUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
/* ---------- REST ASSURED ------------------------------------------------------------------------- */
class AppControllerTest2 {


    @Mock
    private AppService appService;

    @InjectMocks
    private AppController appController;


    @Autowired
    private WebApplicationContext context;

    @Rule
    public JUnitRestDocumentation jUnitRestDocumentation
            = new JUnitRestDocumentation();

    @BeforeEach
    public void initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.standaloneSetup(appController);  // Mock'lanmış
        //RestAssuredMockMvc.webAppContextSetup(context);  // Mock'lanmamış


    }


    @Test
    void home() throws Exception {
        String text = "testCaseVal";
/*
        RestAssuredMockMvc.given()
            .when()
            .get("/home/{inp}", text)
            .then()
            .log().ifValidationFails()
            .statusCode(OK.value())
            .contentType(JSON)
            .body("message", equalTo(text));
*/
        /*
        RestAssured.given(this.spec)
                .accept("application/json")
                .filter(document("controller-test-rest/{method-name}",
                                 //links(linkWithRel("home").description("The HOME resource")),
                                 pathParameters(
                                         parameterWithName("inp").description("The input of the testy")),
                                 responseFields(
                                         subsectionWithPath("message").description("message of response"),
                                         subsectionWithPath("success").description("success status of response"),
                                         subsectionWithPath("data").description("data value of response")),
                                 responseHeaders(headerWithName("Content-Type").description("The Content-Type of the payload"))
                                )
                       )
                .when()
                    .get("/home/{inp}", text)
                .then()
                    .assertThat()
                        .statusCode((Matcher<? super Integer>) is(200))
        ;
*/
    }

    @Test
    void homeTest() throws Exception {

        given()
                .body(new RequestModel("deneme alanı", 0, 0))
                .contentType(JSON)
                .when()
                .post("/").prettyPeek()
        ;

    }

    @Test
    void sum() throws Exception {

        RequestModel req = new RequestModel(StringUtils.emptyString(), 2, 5);

        given()
/*
                .filter(document("sum-test", requestParameters(
                        parameterWithName("num1").description("Number - 1 Value"),
                        parameterWithName("num2").description("Number - 2 Value")
                                                              )
                                )
                       )

 */
                .body(req)
                    .contentType(JSON)
                    //.contentType(JSON)
                .when()
                    .post("/sum").prettyPeek()
                ;

    }
}