package com.itacademy;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

// https://jsonplaceholder.typicode.com
//GET /posts
//GET /posts/1
//POST /posts
//PUT /posts/1
//DELETE /posts/1

public class MyAPITests {
    @BeforeMethod
    public void setUPTests(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void test1(){
        given().log().all()
                .when().get("/posts")
                .then().log().all().statusCode(200);
    }

    @Test
    public void test2(){
        given().log().all()
                .when().get("/posts/1")
                .then().log().all().statusCode(200);
    }

    @Test
    public void test3(){
        given().log().all()
                .body("{\n" +
                "    \"title\": \"new title\",\n" + "}")
                .when().post("/posts")
                .then().log().all().statusCode(201);
    }
    @Test
    public void test4(){
        File file = new File("src/test/resources/json/userHT.json");
        given().log().all()
                .when().put("/posts/1")
                .then().log().all();
    }

    @Test
    public void test5(){
        given().log().all()
                .when().delete("/posts/1")
                .then().log().all().statusCode(200);

    }
}
