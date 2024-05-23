package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class ApiTest {

    @BeforeMethod                    //лучше создать 1 абстрактный класс и от него неследовать все тестовые классы
    public void setUP() {
        RestAssured.baseURI = "https://reqres.in";
    }
    int id;
    @Test
    public void getTestIt(){
        given().log().all()
                .when().get("/api/users/2")
                .then().log().all().statusCode(200).header("Connection", "keep-alive");
    }

    @Test
    public void createUser(){
        File file = new File("src/test/resources/json/user.json");    //там статический (не динамический) json
        given().log().all()
//                .body("{\n" +                                   //а можно через file
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}")
                .body(file)
                .when().post("/api/users")
                .then().log().body().statusCode(201);
    }

    @Test
    public void updateUser(){
        Map<String, String> bodyInfo = new HashMap<>();
        bodyInfo.put("name", "new name");
        bodyInfo.put("job", "new job");
        given().log().all().contentType(ContentType.JSON).body(bodyInfo)
                .when().put("/api/users/2")
                .then().log().body().statusCode(200);
    }

    @Test
    public void deleteUser(){
        given().log().uri()
                .when().delete("/api/users/2")
                .then().statusCode(204);
    }


}
