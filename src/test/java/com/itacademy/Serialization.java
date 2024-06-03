package com.itacademy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Serialization {

    @Test(priority = 1)
    public void createUserPojo() throws IOException {
        User user = new User();
        user.setName("pojo");
        user.setJob("pojo");

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);  //здесь конвертнули юзера в json
//        System.out.println(json);


//        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/test/resources/it.json"), user);    //сделай красиво и сохрани в файл
        User user2 = objectMapper.readValue(new File("src/test/resources/it.json"), User.class);
        System.out.println(user2.getName());
//        RestAssured.baseURI = "https://reqres.in";
//        given().contentType("application/json").log().uri()
//                .body(user)
//                .when().post("/api/users")
//                .then().statusCode(201).log().all()
//                .header("Content-Type", "application/json; charset=utf-8");
    }
    //  если мы хотим ИЗ Объекта сделать стрингу или файл, то пишем метод с writeValueAsString(user),
    // а если из стринги или файла сделать user, то используем readValue(new File("src/test/resources/it.json").

}
